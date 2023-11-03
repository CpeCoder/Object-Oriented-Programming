#include <iostream>
#include <string>
#include "Shape.h"

class Rectangle : public Shape {
private:
    double width;
    double height;

public:
    Rectangle(double width, double height) 
        : width{width}, height{height} {}

    std::string name() override {
        return "Rectangle with width " + std::to_string(width) + " and height " + std::to_string(height);
    }

    double area() override {
        return width * height;
    }
};