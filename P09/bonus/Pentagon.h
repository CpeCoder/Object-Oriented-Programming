#ifndef PENTAGON_H
#define PENTAGON_H

#include "Shape.h"

class Pentagon : public Shape{
    private:
    double apothem;

    public:
    Pentagon(double a);
    std::string name() override;
    double area() override;
};

#endif