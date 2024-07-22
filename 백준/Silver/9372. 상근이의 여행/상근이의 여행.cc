#include <iostream>
#include <queue>
#include <vector>

using namespace std;

void test() {
	
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T,N,M;
	int a, b;
	cin >> T;
	while (T--)
	{
		cin >> N >> M;
		for (int i = 0; i < M; i++) {
			cin >> a >> b;
		}
		cout << N - 1 << endl;
	}
	return 0;
}