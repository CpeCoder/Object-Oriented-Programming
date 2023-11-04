#include <iostream>
#include <vector>
#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include "Pentagon.h"

int main() {
    std::vector<Shape*> shapes;

    Rectangle rectangle{4.0, 3.0};
    Circle circle{2.0};
    Pentagon pentagon{6.9};

    shapes.push_back(&rectangle);
    shapes.push_back(&circle);
    shapes.push_back(&pentagon);

    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }
    
    return 0;
}
