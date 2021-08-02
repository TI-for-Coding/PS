#include<bits/stdc++.h>

using namespace std;


/*
- DFS와 BFS문제 구분법
 
BFS는 너비우선탐색으로 현재 나의 위치에서 가장 가까운 노드를 먼저 방문하는 것이다
방문하면서 현재 위치는 pop해주고 방문한 곳은 체크한 뒤, 방문할 곳은 큐에 넣는 과정입니다
따라서, 미로 탐색과 같은 알고리즘은 최단 거리만을 가지고 탈출하는 것이기에 BFS가 적합합니다

하지만 가령, 미로탐색을 진행하는데, 이동할 때마다 가중치가 붙어서 이동한다거나, 
이동 과정에서 여러 제약이 있을 경우, DFS로 구현하는 것이 좋습니다.

*/

// 01. 변수선언 
int n, div, eachDiv;
vector<int> vEachDiv;

int dx[] = {0,0,-1,1}; // 상하좌우 이동을 위한 템플릿 
int dy[] = {1,-1,0,0};// 상하좌우 이동을 위한 템플릿
int map[25][25]; // input배열 

// 초기화 함수 
void init(){
	
	div = 0, eachDiv = 0; // 초기화 
		
	cin >> n;	
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			cin >> map[i][j];
		}
	}
}

int dfs(int x, int y){
	
	// 01. 종료조건
	
	
	// 02. 식세우기 
	 
}


// 있는지 쭈욱 체크하고 그 갯수를 카운팅 하는 것이므로 최단거리를 측정하는 느낌이 아니므로 DFS가 적합  
void solve04() {
	
	// 01. 입력값 셋팅 
	init();
	
	/*
	생각한 방법
	
	1. 배열의 값이 1인 경우 재귀호출 시작
	2. 재귀함수가 종료될 때마다 1을 리턴하며 div 를 증가 => 단지수  
	3. 재귀함수 안에서 eachDiv를 증가하며 단지마다 가구 수를 증가 => 단지별 가구수 
	 
	*/
		
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(map[i][j] == 1){
								
				div += dfs(i,j); // 1인 경우 깊이우선탐색 start 
				
				
			} 
			
		}
	}
	
	sort(vEachDiv.begin(), vEachDiv.end()); // 단지별 가구수 오름차순 정렬 
	
	
	cout << div << endl;
	
	for(int i=0; i<div; i++){
		cout << vEachDiv[i] << endl;
	}	
	
}


int main(){
	
	
	
	//solve03(); // 팩토리얼 
	solve04(); // 단지번호붙이기  
	
	return 0;
}
