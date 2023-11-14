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
    Time(int hour = 0, int minute = 0, int second = 0);

    bool operator==(const Time& time) const;
    bool operator!=(const Time& time) const;
    bool operator<(const Time& time) const;
    bool operator>(const Time& time) const;
    bool operator<=(const Time& time) const;
    bool operator>=(const Time& time) const;

    Time operator+(Time time);
    Time& operator++();
    Time operator++(int);

    friend std::ostream& operator<<(std::ostream& os, const Time& time);
    friend std::istream& operator>>(std::istream& is, Time& time);
};

#endif // TIME_H
