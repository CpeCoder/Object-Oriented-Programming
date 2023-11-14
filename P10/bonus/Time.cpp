#include "Time.h"

void Time::rationalize() {
    int totalSeconds = _hour * 3600 + _minute * 60 + _second;
    totalSeconds = (totalSeconds + (24*3600)) % (24*3600);
    _hour = totalSeconds / 3600;
    _minute = (totalSeconds % 3600) / 60;
    _second = totalSeconds % 60;
}

Time::Time() :
    _hour{0}, _minute{0}, _second{0} {}

Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second) {
    rationalize();
}

bool Time::operator==(const Time& time) const {
    return _hour == time._hour && _minute == time._minute && _second == time._second;
}

bool Time::operator!=(const Time& time) const {
    return !(*this == time);
}

bool Time::operator<(const Time& time) const {
    if (_hour != time._hour) return _hour < time._hour;
    if (_minute != time._minute) return _minute < time._minute;
    return _second < time._second;
}

bool Time::operator>(const Time& time) const {
    return !(*this < time || *this == time);
}

bool Time::operator<=(const Time& time) const {
    return (*this < time || *this == time);
}

bool Time::operator>=(const Time& time) const {
    return !(*this < time);
}

Time Time::operator+(Time time) {
    int newHour = this->_hour + time._hour;
    int newMinute = this->_minute + time._minute;
    int newSecond = this->_second + time._second;
    return Time(newHour, newMinute, newSecond);
}

Time Time::operator+(int seconds) const {
    int totalSeconds = _hour * 3600 + _minute * 60 + _second + seconds;

    totalSeconds = (totalSeconds + 86400) % 86400;

    int newHour = totalSeconds / 3600;
    int newMinute = (totalSeconds % 3600) / 60;
    int newSecond = totalSeconds % 60;

    return Time(newHour, newMinute, newSecond);
}


Time& Time::operator++() {
    ++_second;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time temp = *this;
    ++(*this);
    return temp;
}

Time operator+(int seconds, const Time& time) {
    int totalSeconds = time._hour * 3600 + time._minute * 60 + time._second + seconds;
    totalSeconds = (totalSeconds + 86400) % 86400;

    int newHour = totalSeconds / 3600;
    int newMinute = (totalSeconds % 3600) / 60;
    int newSecond = totalSeconds % 60;

    return Time(newHour, newMinute, newSecond);
}

std::ostream& operator<<(std::ostream& os, const Time& time) {
    return os << std::setfill('0') << std::setw(2) << time._hour << ":"
              << std::setfill('0') << std::setw(2) << time._minute << ":"
              << std::setfill('0') << std::setw(2) << time._second;
}

std::istream& operator>>(std::istream& is, Time& time) {
    char discard;
    is >> time._hour >> discard >> time._minute >> discard >> time._second;
    time.rationalize();
    return is;
}
