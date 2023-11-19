#include "Index.h"

void Index::add_word(const std::string& filename, int line, const Word& word) {
    _index.insert(std::make_pair(word, Location(filename, line)));
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    Index::Word current_word;

    for (auto it = index._index.begin(); it != index._index.end(); ++it) {
        if (it->first != current_word) {
            if (!current_word.empty()) {
                os << '\n';
            }
            Location::next_word();
            os << it->first << ": ";
            current_word = it->first;
        } else {
        
            os << ", ";
        }
        
        os << it->second;
    }

    os << '\n';
    return os;
}