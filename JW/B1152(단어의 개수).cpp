// B1152_단어의개수 
#include<bits/stdc++.h>
using namespace std;

/*
	' '
	'a'
	' a a '
	' aa a '
	'aa a a a a'
	' a '
	' a a'
	'a a '
	'a aaaaa a'	
	*/

// c
void solve01(){
	
	char a[1000000];
	int rst;
	
	scanf("%[^\n]",a);	

	int last = strlen(a);
	if(last == 1){
		if(a[0] == ' '){
			printf("0\n");
			return 0;
		}else{
			printf("1\n");
		}		
	}else{
		rst = 0;
		if(a[0] == ' ' && a[last-1] == ' '){
			for(int i=0; i<strlen(a); i++){
				if(a[i] >= 'A' && a[i] <= 'z') continue;
				else rst++;
			}
			printf("%d", rst-1);
			return 0;	
		}else if(a[0] != ' ' && a[last-1] != ' '){
			for(int i=0; i<strlen(a); i++){
				if(a[i] >= 'A' && a[i] <= 'z') continue;
				else rst++;
			}
			printf("%d",rst+1);
			return 0;	
		}else{
			for(int i=0; i<strlen(a); i++){
				if(a[i] >= 'A' && a[i] <= 'z') continue;
				else rst++;
			}
			printf("%d",rst);
		
}


// c++
void solve02(){
	
	string str;
	int rst = 1;
	bool chk = false;
	// str.erase(remove(str.begin(), str.end(), ' '), str.end()); -- 모든 공백제거  
	getline(cin,str);
	
	if(str.length() == 0) {
		cout << 0 << endl;
		return;	
	}
	
	if(str[0] == ' ' && str[str.length()-1] == ' '){
		str.erase(str.begin());
		str.erase(str.end()-1);	
	}else if(str[0] == ' '){
		str.erase(str.begin());
	}else if(str[str.length()-1] == ' '){
		str.erase(str.end()-1);
	}
	
	
	for(int i=0; i<str.length(); i++){
		if(str[i] == ' ') {
			chk = true;
			rst++;	
		}
	}	

		
	
	if(!chk) cout << 1 << endl;
	else cout << rst << endl;		
	
		
}

int main(){
	
	
	//solve01(); // 정답 
	solve02(); // 틀림 - 푸는중 
	
	return 0;
}
