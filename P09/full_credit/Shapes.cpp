#include <iostream>
#include <vector>
#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"

int main() {
    std::vector<Shape*> shapes;

    Rectangle rectangle{4.0, 3.0};
    Circle circle{2.0};

    shapes.push_back(&rectangle);
    shapes.push_back(&circle);

    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }
    
    return 0;
}
