import java.util.Arrays;

import java.util.List;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordSearch {
    private static final String usage = "usage: java WordSearch [-h] [-v] [#threads] [#puzzles] [puzzleFile]...";

    public WordSearch(List<String> args) {

        // Validate the command line arguments
        if (args.size() > 0 && args.get(0).equals("-h")) {
            System.out.println(usage);
            System.exit(0);
        }
        if (args.size() > 0 && args.get(0).equals("-v")) {
            verbose = true;
            args.remove(0);
        } else {
            verbose = false;
        }
        int threads = 0;
        try {
            // Can't assign NUM_THREADS here because javac worries
            // it may not be assigned a value
            threads = Integer.parseInt(args.get(0));
            args.remove(0);
        } catch (Exception e) {
            System.err.println("Error: Invalid number of threads\n" + usage);
            System.exit(-1);
        }
        NUM_THREADS = threads;
        int numPuzzles = 0;
        try {
            // Can't assign NUM_THREADS here because javac worries
            // it may not be assigned a value
            numPuzzles = Integer.parseInt(args.get(0));
            args.remove(0);
        } catch (Exception e) {
            System.err.println("Error: Invalid number of puzzles\n" + usage);
            System.exit(-1);
        }

        // Load the puzzles!
        for (String puzzleName : args) {
            try (BufferedReader br = new BufferedReader(new FileReader(puzzleName))) {
                puzzles.add(new Puzzle(puzzleName, br));
            } catch (IOException e) {
                System.err.println("Unable to load puzzle " + puzzleName);
            }
        }

        // Verify all puzzles loaded successfully
        // No error is printed, as a message should be printed for each failed load
        // above
        if (puzzles.size() != args.size())
            System.exit(-3);

        // Delete or duplicate puzzles to get the right number
        if (numPuzzles < puzzles.size())
            puzzles.subList(numPuzzles, puzzles.size()).clear();
        else if (numPuzzles > puzzles.size()) {
            for (int i = puzzles.size(); i < numPuzzles; ++i)
                puzzles.add(puzzles.get(i % puzzles.size()));
        }
        NUM_PUZZLES = puzzles.size();

        // -------- All Puzzles Loaded --------
    }

    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    // Modify THIS method to divide up the puzzles among your threads!
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void solve() {
        System.err.println("\n" + NUM_PUZZLES + " puzzles with " + NUM_THREADS + " threads");

        // Create an array of threads
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadID = i;
            int puzzlesPerThread = NUM_PUZZLES / NUM_THREADS;
            int firstPuzzle = threadID * puzzlesPerThread;
            int lastPuzzlePlusOne = (threadID + 1) * puzzlesPerThread;

            // Last thread may get extra puzzles
            if (threadID == NUM_THREADS - 1) {
                lastPuzzlePlusOne = NUM_PUZZLES;
            }
            final int finalFirstPuzzle = firstPuzzle;
            final int finalLastPuzzlePlusOne = lastPuzzlePlusOne;

            // Create and start a thread for each range
            threads[i] = new Thread(() -> {
                solve(threadID, finalFirstPuzzle, finalLastPuzzlePlusOne);
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }

        // Print solutions if verbose
        if (verbose) {
            printSolutions();
        }
    }

    private final Object puzzlesLock = new Object(); // Lock for puzzles collection
    private final Object solutionsLock = new Object(); // Lock for solutions collection

    public void solve(int threadID, int firstPuzzle, int lastPuzzlePlusOne) {
        System.err.println("Thread " + threadID + ": " + firstPuzzle + "-" + (lastPuzzlePlusOne - 1));

        for (int i = firstPuzzle; i < lastPuzzlePlusOne; ++i) {
            int puzzleIndex;

            // Use a synchronized block to get the next puzzle index safely
            synchronized (puzzlesLock) {
                if (sharedPuzzleCounter < NUM_PUZZLES) {
                    puzzleIndex = sharedPuzzleCounter;
                    sharedPuzzleCounter++;
                } else {
                    break; // No more work to do, exit the loop
                }
            }

            Puzzle p = puzzles.get(puzzleIndex);
            Solver solver = new Solver(p);
            for (String word : p.getWords()) {
                try {
                    Solution s = solver.solve(word);
                    if (s == null)
                        System.err.println("#### Failed to solve " + p.name() + " for '" + word + "'");
                    else {
                        synchronized (solutionsLock) {
                            solutions.add(s);
                        }
                    }
                } catch (Exception e) {
                    System.err.println("#### Exception solving " + p.name() + " for " + word + ": " + e.getMessage());
                }
            }
        }

        // -------- All Puzzles Solved --------
    }

    public void printSolutions() {
        for (Solution s : solutions)
            System.out.println(s);
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch(new LinkedList<>(Arrays.asList(args)));
        ws.solve();
        if (ws.verbose)
            ws.printSolutions();
    }

    public final int NUM_THREADS;
    public final int NUM_PUZZLES;
    public final boolean verbose;

    private int sharedPuzzleCounter = 0;
    private List<Puzzle> puzzles = new ArrayList<>();;
    private SortedSet<Solution> solutions = new java.util.TreeSet<>();
}