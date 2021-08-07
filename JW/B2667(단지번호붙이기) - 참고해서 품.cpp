//#include<bits/stdc++.h>
#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;
int n, cnt;
int map[25][25];

int dx[4] = {0,0,-1,1}; 
int dy[4] = {-1,1,0,0};
vector<int> v;

/*
아래까지 쭉 탐색한 후 
탈출조건을 정의하지 않아도 됨 
전역변수로 구간이 나뉠 때 마다 체크  
*/
void dfs(int x, int y){
    cnt++;
    map[x][y] = 0;
    for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx<0 || ny<0 || nx>=n || ny>=n || !map[nx][ny]) continue;
        dfs(nx,ny);
    }
}
int main()
{
	
	cin >> n;
    
    // cin x
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			scanf("%1d",&map[i][j]);			
		}
	}
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(map[i][j] == 1){
				cnt = 0;
				dfs(i,j);
				v.push_back(cnt);
			}
		}
	}

	cout << v.size() << endl;
	
	sort(v.begin(), v.end());
	
	for(int i=0; i<v.size(); i++){
		cout << v[i] << endl;
	}
	

	return 0;    
}
