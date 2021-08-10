#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
#include<cmath> 
using namespace std;

int N,M; // 입력값 
int eachPower; // 병사수 
char map[100][100]; // 전쟁터 
int dx[] = {0,0,-1,1}; // 상하좌우 움직이는 템플릿 
int dy[] = {-1,1,0,0}; // 상하좌우 움직이는 템플릿 
vector<int> wPower, bPower; // 위력을 담는 vector


void dfs(int x, int y){
	
	eachPower++; // 병사수 증가 
	map[x][y] = 'F'; // 'B', 'W'가 아닌 값으로 임의로 치환 
	
	for(int i=0; i<4; i++){ // 템플릿 (탐색) 
		
		int nx = x + dx[i];
		int ny = y + dy[i];
		
		if(nx>=N || ny>=M || nx<0 || ny<0 || map[nx][ny] == 'F') continue; // 'F' 인 경우 무시
		
		if(map[nx][ny] == 'W'){ 
			 dfs(nx,ny); // 깊이우선탐색 		
		}
	}		
}

void dfs2(int x, int y){
	
	eachPower++; // 병사수 증가 
	map[x][y] = 'F'; // 'B', 'W'가 아닌 값으로 임의로 치환 
	
	for(int i=0; i<4; i++){ // 템플릿 (탐색) 
		
		int nx = x + dx[i];
		int ny = y + dy[i];
		
		if(nx>=N || ny>=M || nx<0 || ny<0 || map[nx][ny] == 'F') continue; // 'F' 인 경우 무시
		
		if(map[nx][ny] == 'B'){ 
			 dfs2(nx,ny); // 깊이우선탐색 		
		}
	}		
}


int main(){
	
	cin >> N >> M;
	
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			cin >> map[i][j];
		}
	}
	
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			if(map[i][j] == 'W'){
				eachPower = 0;
				dfs(i,j);
				wPower.push_back(eachPower);
			}
		}
	}	
	
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			if(map[i][j] == 'B'){
				eachPower = 0;
				dfs2(i,j);
				bPower.push_back(eachPower);
			}
		}
	}	
		
	int wSize = wPower.size(); // 하얀팀 지수 값
	int bSize = bPower.size(); // 파란팀 지수 값
	
	//printf("%d %d", wPower.size(), bPower.size());
	
	int wRst = 0, bRst = 0;
	
	for(int i=0; i<wSize; i++){
		wRst += pow(wPower[i],wSize);	
	}
	
	for(int i=0; i<wSize; i++){
		bRst += pow(bPower[i],bSize);	
	}
	
	printf("%d %d", wRst, bRst);
	
	return 0;
}

 
