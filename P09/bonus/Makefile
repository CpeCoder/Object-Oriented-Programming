CXXFLAGS += --std=c++17

shapes: Shape.o Circle.o Rectangle.o Pentagon.o Shapes.o *.h
	$(CXX) $(CXXFLAGS) Shape.o Circle.o Rectangle.o Pentagon.o Shapes.o -o shapes
Circle.o: Circle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Circle.cpp -o Circle.o
Rectangle.o: Rectangle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Rectangle.cpp -o Rectangle.o
Pentagon.o: Pentagon.cpp *.h
	$(CXX) $(CXXFLAGS) -c Pentagon.cpp -o Pentagon.o
Shape.o: Shape.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shape.cpp -o Shape.o
Shapes.o: Shapes.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shapes.cpp -o Shapes.o
clean:
	rm -f *.o *.gch *~ a.out shapes
