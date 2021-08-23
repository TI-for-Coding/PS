#include<cstdio>
#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n,m;
int paper[500][500];
vector<int> srt;
int area;
int dx[] = {0,0,-1,1};
int dy[] = {-1,1,0,0};
bool chk = false;
int maxArea = 0, cnt = 0;

void dfs(int x, int y){

	paper[x][y] = 0;
	area++;
	
	for(int i=0; i<4; i++){
		
		int nx = x + dx[i];
		int ny = y + dy[i];
		
		if(maxArea < area){
			maxArea = area;
		}
		
		if(nx < 0 || ny < 0 || nx >= n || ny >= m || paper[nx][ny] == 0) continue;
		
		dfs(nx,ny);
		
	}

}



int main(){


	cin >> n >> m;


	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			cin >> paper[i][j];
		}
	}

	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){	
			if(paper[i][j] == 1){				
				area = 0;				
				dfs(i,j);
				cnt++;			
				srt.push_back(area);
			}
		}
	}

	
	
	printf("%d\n",cnt);
	printf("%d\n",maxArea);			
	
	return 0;

}
