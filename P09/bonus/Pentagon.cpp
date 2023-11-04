#include <iostream>
#include <cmath>
#include <string>
#include "Pentagon.h"
#include "Shape.h"

Pentagon::Pentagon(double a)
    : apothem{a} {}

std::string Pentagon::name(){
    return "Pentagon with apothem " + std::to_string(apothem);
}
    
double Pentagon::area(){
    return 0.25*sqrt(5*(5+2*sqrt(5)))*apothem*apothem;
}