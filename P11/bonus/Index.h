#ifndef INDEX_H
#define INDEX_H

#include <iostream>
#include <map>
#include <set>
#include <string>

#include "Location.h"

class Index {
public:
    using Word = std::string;
    using Locations = std::set<Location>;

    void add_word(const std::string& filename, int line, const Word& word);
    friend std::ostream& operator<<(std::ostream& os, const Index& index);

private:
    std::map<Word, Locations> _index;
};

#endif
