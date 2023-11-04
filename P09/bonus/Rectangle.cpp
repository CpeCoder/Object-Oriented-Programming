#include <iostream>
#include <string>
#include "Shape.h"
#include "Rectangle.h"

Rectangle::Rectangle(double width, double height) 
    : width{width}, height{height} {}

std::string Rectangle::name() {
    return "Rectangle with width " + std::to_string(width) + " and height " + std::to_string(height);
}

double Rectangle::area() {
    return width * height;
}
