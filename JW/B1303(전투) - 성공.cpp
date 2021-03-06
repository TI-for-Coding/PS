#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
#include<cmath> 
#include<cstring>

using namespace std;

int N,M; // 입력값 
int eachPower; // 병사수 
char map[100][100], cpy[100][100]; // 전쟁터 
int dx[] = {0,0,-1,1}; // 상하좌우 움직이는 템플릿 
int dy[] = {-1,1,0,0}; // 상하좌우 움직이는 템플릿 
vector<int> wPower, bPower; // 위력을 담는 vector


// 'W' 병사수 카운트 (아군) 
void dfs(int x, int y){
	
	eachPower++; // 병사수 증가 
	map[x][y] = 'F'; // 'B', 'W'가 아닌 값으로 임의로 치환 
	
	for(int i=0; i<4; i++){ // 템플릿 (탐색) 
		
		int nx = x + dx[i];
		int ny = y + dy[i];
		
		if(nx>=M || ny>=N || nx<0 || ny<0) continue; // 'F' 인 경우 무시
		
		if(map[nx][ny] == 'W'){
			dfs(nx,ny); 			
		}
		
	}		
}

// 'B' 병사수 카운트 (적군) 
void dfs2(int x, int y){
	
	eachPower++; // 병사수 증가 
	cpy[x][y] = 'F'; // 'B', 'W'가 아닌 값으로 임의로 치환 
	
	for(int i=0; i<4; i++){ // 템플릿 (탐색) 
		
		int nx = x + dx[i];
		int ny = y + dy[i];
		
		if(nx>=M || ny>=N || nx<0 || ny<0) continue; // 'F' 인 경우 무시
		
		if(cpy[nx][ny] == 'B'){
			dfs2(nx,ny); 			
		}
		
	}		
}



int main(){
	
	cin >> N >> M;
	
	// 입력받 
	for(int i=0; i<M; i++){
		for(int j=0; j<N; j++){
			cin >> map[i][j];
		}
	}
	
	// copy
	for(int i=0; i<M; i++){
		for(int j=0; j<N; j++){
			cpy[i][j] = map[i][j];
		}
	}
	
	
	for(int i=0; i<M; i++){
		for(int j=0; j<N; j++){
			if(map[i][j] == 'W'){
				eachPower = 0;
				dfs(i,j);
				wPower.push_back(eachPower);
			}
		}
	}
	
	for(int i=0; i<M; i++){
		for(int j=0; j<N; j++){
			if(cpy[i][j] == 'B'){
				eachPower = 0;
				dfs2(i,j);
				bPower.push_back(eachPower);
			}
		}
	}
	
		
	int wSize = wPower.size(); // 하얀팀 지수 값
	int bSize = bPower.size(); // 파란팀 지수 값
	
	int wRst = 0, bRst = 0;
	
	for(int i=0; i<wSize; i++){
		wRst += pow(wPower[i],2);	
	}
	
	for(int i=0; i<bSize; i++){
		bRst += pow(bPower[i],2);	
	}
	
	printf("%d %d", wRst, bRst);
	
	return 0;
}

