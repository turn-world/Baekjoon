#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {

	while (true) {
		stack<char> st;
		string s;
		getline(cin, s);

		if (s == ".") {
			break;
		}

		for (int i = 0; i < s.size(); i++) {
			if (s[i] != '[' && s[i] != ']' && s[i] != '(' && s[i] != ')')
				continue;

			if (st.empty()) {
				st.push(s[i]);
			}

			else {
				if (st.top() == '[' && s[i] == ']') {
					st.pop();
				}
				else if(st.top() == '(' && s[i] == ')'){
					st.pop();
				}
				else {
					st.push(s[i]);
				}
			}
		}

		if (st.empty()) {
			cout << "yes"<<"\n";
		}
		else {
			cout << "no"<<"\n";
		}
	}
}