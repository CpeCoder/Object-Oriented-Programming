#include "/usr/include/gtkmm-3.0/gtkmm.h"
#include <iostream>
#include <cmath>
#include <vector>
#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include "Pentagon.h"

// set the value for rectangle width and height here
double rect_width = 9;
double rect_height = 4.5;

class MyWindow : public Gtk::Window
{
public:
    MyWindow()
    {
        set_title("Rectangle");
        set_default_size(25*rect_width + 10, 25*rect_height + 10);

        add(canvas);

        canvas.signal_draw().connect(sigc::mem_fun(*this, &MyWindow::on_draw));
    }

protected:
    bool on_draw(const Cairo::RefPtr<Cairo::Context>& cr)
    {
        cr->set_source_rgb(0.0, 0.0, 0.0);
        cr->paint();

        cr->set_source_rgb(0.0, 0.0, 1.0);

        double x = 25;
        double y = 25;
        double width = rect_width*25;
        double height = rect_height*25;

        cr->rectangle(x, y, width, height);
        cr->fill();

        return true;
    }

    Gtk::DrawingArea canvas;
};

int main(int argc, char* argv[])
{
    auto app = Gtk::Application::create(argc, argv);

    MyWindow window;
    std::vector<Shape*> shapes;

    Rectangle rectangle{rect_width, rect_height};
    Circle circle{2.0};
    Pentagon pentagon{6.9};
    
    shapes.push_back(&rectangle);
    shapes.push_back(&circle);
    shapes.push_back(&pentagon);

    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }
    
    return app->run(window);
}
