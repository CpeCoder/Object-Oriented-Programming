#include "Index.h"

void Index::add_word(const std::string& filename, int line, const Word& word) {
    // Insert the word and location into the multimap
    _index.emplace(word, Location(filename, line));
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    Index::Word current_word;
    Index::Locations::const_iterator current_location;

    for (auto it = index._index.begin(); it != index._index.end(); ++it) {
        if (it->first != current_word) {
            if (!current_word.empty()) {
                os << '\n';
            }
            os << it->first << ": ";
            current_word = it->first;
            current_location = it;
            os << current_location->second;
        } 
        else if (it->second != current_location->second) {
            os << ", " << it->second;
            current_location = it;
        }
    }

    os << '\n';
    return os;
}

