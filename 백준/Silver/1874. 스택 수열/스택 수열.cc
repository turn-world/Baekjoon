#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {
	int n;
	int cnt = 1;
	int num;
	vector<char> s;
	stack<int> st;

	cin >> n;
	while (n--) {

		cin >> num;

		while (cnt <= num) {
			st.push(cnt);
			cnt++;
			s.push_back('+');

		}

		if (!st.empty() && st.top() == num) {
			st.pop();
			s.push_back('-');
		}
		else {
			cout << "NO";
			return 0;
		}
	}

		for (int i = 0; i < s.size(); i++) {
			cout << s.at(i) << '\n';
		}

}