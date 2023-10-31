CXXFLAGS += --std=c++17

all: hello_me hello_all

hello: hello_me.cpp
	$(CXX) $(CXXFLAGS) hello.cpp -o hello

hello_all: hello_all.cpp
	$(CXX) $(CXXFLAGS) hello_all.cpp -o hello_all

clean:
	-rm -f *.o *.gch *~ a.out hello hello_all
