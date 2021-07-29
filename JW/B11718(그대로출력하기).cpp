// B11718 그대로출력하기 
#include<bits/stdc++.h>


using namespace std;


int main(){
	
	string str;


 	// 반복문을 돌며 입력이 없는 경우 즉 입력된 값이 NULL 인 경우까지 무한으로 돈다.	
	while(true){
		
		getline(cin, str);
		
		// NULL 인 경우 BREAK 
		if(str == "") break;
		
		cout << str << endl;
		
	}	
	
}
