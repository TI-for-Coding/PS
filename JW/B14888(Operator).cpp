#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n, k;
int maxV = -2e9, minV = 2e9; // 최대최소값 c언어 설정법 
int arr[20];
vector<int> op;



void init()
{
	
	cin >> n;
	
	for(int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int j = 0; j < 4; j++) {
		cin >> k;		
		while (k--) op.push_back(j);
	}
}

void simulation()

{

	do {

		int sum = arr[0];

		for (int i = 0; i < n - 1; i++)

		{

			if (op[i] == 0) sum += arr[i+1];

			else if (op[i] == 1) sum -= arr[i + 1];

			else if (op[i] == 2) sum *= arr[i + 1];

			else if (op[i] == 3) sum /= arr[i + 1];

		}

		maxV = max(sum, maxV);

		minV = min(sum, minV);

	} while (next_permutation(op.begin(), op.end()));

}

int main()

{

	init();

	simulation();

	printf("%d\n%d\n", maxV, minV);

	return 0;

}
