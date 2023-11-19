#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>

class Location {
public:
    Location(const std::string& filename, int line);

    bool operator<(const Location& location) const;
    bool operator==(const Location& location) const;
    bool operator!=(const Location& location) const;
    bool operator<=(const Location& location) const;
    bool operator>(const Location& location) const;
    bool operator>=(const Location& location) const;

    friend std::ostream& operator<<(std::ostream& os, const Location& location);

    static std::string last_filename;
    static void next_word();
private:
    std::string _filename;
    int _line;
};

#endif
