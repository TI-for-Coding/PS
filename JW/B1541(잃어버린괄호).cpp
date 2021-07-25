#include<bits/stdc++.h>
using namespace std; 

string str; 
string temp = ""; 
int rst =0; 

int main() 
{ 
	cin>> str; 
	bool chk=false; 
	for(int i=0;i<=str.size();i++) { 
		if(str[i]=='+' || str[i]=='-' || str[i]=='\0') 
		{ 
			if (chk) 
			{ 
				rst-=stoi(temp); 
			} else { 
				rst+=stoi(temp); 
			} temp=""; 
		
			if(str[i]=='-') 
			{ 
				chk=true; 
			} 
		} else { 
			temp+=str[i]; 
		} 
	} 
	
	cout<< rst; 
}

