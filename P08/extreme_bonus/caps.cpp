#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

bool comp_str(const std::string &str1, const std::string &str2) {
    return str1 < str2;
}

bool comp_len(const std::string &str1, const std::string &str2) {
    if (str1.length() == str2.length()) {
        return str1 < str2;
    }
    return str1.length() < str2.length();
}

int main(int argc, char** argv) {
	std::vector<std::string> caps;
    	std::vector<std::string>* no_caps = new std::vector<std::string>;
    	std::string prev_str;

    	for (int i = 1; i < argc; i++) {
        	std::string arg_str = argv[i];
        	char first_char = arg_str[0];

        	if (isupper(first_char)) {
            		if (prev_str != arg_str)
                		caps.push_back(arg_str);
        	}
        	else {
            		if (prev_str != arg_str)
                		no_caps->push_back(arg_str);
        	}
        	prev_str = arg_str;
    	}	
    
    	std::sort(caps.begin(), caps.end(), comp_str);
    	std::cout << "Capitalized:" << std::endl;

    	for (const auto& i : caps) {
        	std::cout << i << std::endl;
    	}

        std::sort(no_caps->begin(), no_caps->end(), comp_len);
    	std::cout << "\nLower Case:" << std::endl;
    	
	for (const auto& str : *no_caps) {
        	std::cout << str << std::endl;
    	}

    	delete no_caps;

    	return 0;
}

