#include <iostream>
#include <string>

class Shape {
public:
    virtual std::string name() {
        return "Shape";
    }

    virtual double area() {
        return 0.0;
    }

    std::string to_string() {
        return name() + " have area of" + std::to_string(area());
    }
};