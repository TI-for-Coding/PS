//#include<bits/stdc++.h>
#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;
int n, m, cnt;
int map[500][500];

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };
vector<int> v;
bool chk = false; 

void dfs(int x, int y) {
    cnt++;
    map[x][y] = 0;


    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m || !map[nx][ny]) continue;
        dfs(nx, ny);
    }
}
int main()
{

    cin >> n >> m; // 세로, 가로
    
    // cin x
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &map[i][j]);
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (map[i][j] == 1) {
            	chk = true;
                cnt = 0;
                dfs(i, j);
                v.push_back(cnt);
            }
        }
    }
	
    
    if(chk){
    	sort(v.rbegin(), v.rend());   
		cout << v.size() << endl;
    	cout << v.front() << endl;    	
	}else{		
		cout << v.size() << endl;
		cout << 0 << endl;		
	}
    

    return 0;
}
