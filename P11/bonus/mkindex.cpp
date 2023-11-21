#include "Index.h"
#include "Location.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <cctype>
#include <map>
#include <set>

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Input: " << argv[0] << " file1_name file2_name ..." << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; i++) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error, file not open: " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int line_num = 1;
        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;

            while (iss >> word) {
                while (!word.empty() && !std::isalnum(word.front())) {
                    word.erase(0, 1);
                }
                while (!word.empty() && !std::isalnum(word.back())) {
                    word.pop_back();
                }
                for (char& c : word) {
                    c = std::tolower(c);
                }
                
                index.add_word(argv[i], line_num, word);
            }

            ++line_num;
        }

        file.close();
    }

    std::cout << index;

    return 0;
}
