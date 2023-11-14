#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <iomanip>

class Time {
private:
    int _hour;
    int _minute;
    int _second;

    void rationalize();

public:
    Time();
    Time(int hour, int minute, int second);

    bool operator==(const Time& time) const;
    bool operator!=(const Time& time) const;
    bool operator<(const Time& time) const;
    bool operator>(const Time& time) const;
    bool operator<=(const Time& time) const;
    bool operator>=(const Time& time) const;

    Time operator+(Time time);
    Time operator+(int seconds) const;
    Time& operator++();
    Time operator++(int);
    int operator[](int index);

    friend Time operator+(int seconds, const Time& time);
    friend std::ostream& operator<<(std::ostream& os, const Time& time);
    friend std::istream& operator>>(std::istream& is, Time& time);
};

#endif // TIME_H
