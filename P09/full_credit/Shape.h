#ifndef SHAPE_H
#define SHAPE_H

#include <string>

class Shape {
public:
    virtual std::string name();
    virtual double area();
    std::string to_string();
};

#endif
