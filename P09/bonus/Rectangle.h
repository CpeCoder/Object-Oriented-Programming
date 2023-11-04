#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape {
    double width;
    double height;

    public:
    Rectangle(double width, double height);

    std::string name() override;
    double area() override;
};

#endif 
