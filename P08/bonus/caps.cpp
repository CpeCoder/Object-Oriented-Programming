#include <iostream>
#include <vector>
#include <string>

int main(int argc, char** argv) {
    	std::vector<std::string> caps;
    	std::vector<std::string>* no_caps = new std::vector<std::string>;
	std::string prev_str;

	for(int i = 1; i < argc; i++) {
        	std::string arg_str = argv[i];
        	char first_char = arg_str[0];

        	if(isupper(first_char)) {
            		if(prev_str != arg_str)
				caps.push_back(arg_str);
		} 
		else 	{
			if(prev_str != arg_str)	
				no_caps->push_back(arg_str);
		}
		prev_str = arg_str;
    	}

    	std::cout << "Capitalized:" << std::endl;

    	for(const auto& i : caps)
    	{
		std::cout << i << std::endl;	
    	}
	
     	std::cout << "\nLower Case:" << std::endl;
    	for (std::vector<std::string>::iterator it = no_caps->begin(); it != no_caps->end(); it++) {
        	std::cout << *it << std::endl;
    	}

    delete no_caps;

    return 0;
}

