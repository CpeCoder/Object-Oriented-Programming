#include "Location.h"

Location::Location(const std::string& filename, int line)
    : _filename{filename}, _line{line} {}

bool Location::operator==(const Location& location) const {
    return _filename == location._filename && _line == location._line;
}

bool Location::operator!=(const Location& location) const {
    return !(*this == location);
}

bool Location::operator<(const Location& location) const {
    if (_filename == location._filename) {
        return _line < location._line;
    }
    return _filename < location._filename;
}

bool Location::operator>(const Location& location) const {
    return location < *this;
}

bool Location::operator<=(const Location& location) const {
    return !(location < *this);
}

bool Location::operator>=(const Location& location) const {
    return !(*this < location);
}

std::ostream& operator<<(std::ostream& os, const Location& location) {
    os << location._filename << " line " << location._line;
    return os;
}
