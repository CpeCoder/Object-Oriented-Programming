#include <iostream>
#include <string>
#include <cmath>
#include "Shape.h"

class Circle : public Shape {
private:
    double radius;

public:
    Circle(double radius) 
        : radius{radius} {}

    std::string name() override {
        return "Circle with radius " + std::to_string(radius);
    }

    double area() override {
        return M_PI * radius * radius;
    }
};