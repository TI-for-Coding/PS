#include<iostream>
using namespace std;

int col[15];
int N;
int cnt = 0;

bool promising(int i) {
	for (int j = 0; j < i; j++) {
		if (col[j] == col[i] || abs(col[i] - col[j]) == (i - j)) return false;
	}
	return true;
}


void dfs(int i) { //i는 놓은 queen의 수이기도 하면서 행을 뜻한다.
	if (i == N) cnt++;
	else {
		for (int j = 0; j < N; j++) {
			col[i] = j;
			if (promising(i)) dfs(i + 1);
		}
	}
}


int main() {

	cin >> N;

	dfs(0);

	cout << cnt;

	return 0;
}
