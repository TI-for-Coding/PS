#include<bits/stdc++.h>

using namespace std;


/*
1. return 할 식 정의 (자기자신반드시포함) 
2. 종료조건 명시 (if문) 
*/

int factorial(int n){
	
	if(n == 0) return 1;
	
	
	return n * factorial(n-1);
}



void solve03(){
	
	int n;
	int rst = 0;
	
	cin >> n;	

	rst = factorial(n);
	
	cout << rst << endl;
	
	
}


int main(){
	
	
	
	solve03();
	//solve04();	

	
	
	
	
	
}
