#include <iostream>
#include <stack>
using namespace std;

int main() {
	int k;
	int num;
	int sum = 0;
	stack<int> s;

	cin >> k;

	for (int i = 0; i < k; i++) {
		cin >> num;
		if (num == 0) {
			s.pop();
		}
		else
			s.push(num);
	}

	int stack_size = s.size();
	for (int i = 0; i < stack_size; i++) {
		sum += s.top();
		s.pop();
	}
	cout << sum;
	return 0;
}
