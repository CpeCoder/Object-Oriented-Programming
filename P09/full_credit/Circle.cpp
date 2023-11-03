#include <iostream>
#include <string>
#include <cmath>
#include "Shape.h"
#include "Circle.h"

Circle::Circle(double radius) 
    : radius{radius} {}
std::string Circle::name() {
    return "Circle with radius " + std::to_string(radius);
}
double Circle::area() {
    return M_PI * radius * radius;
}