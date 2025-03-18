#include <bits/stdc++.h>
using namespace std;
int n,m;
int x[4] = {1,-1,0,0};
int y[4] = {0,0,1,-1};
int field[601][601] = {0};
int check [601][601] = {0};
int result = 0;
void find_people(int start_x,int start_y)
{
    if(field[start_x][start_y] == 0) // 필드가 아닌 경우
            return;

    if(check[start_x][start_y] == 0){ // 방문 안한 경우

        if(field[start_x][start_y] != -1) // X만 아니면
        {
            check[start_x][start_y] = 1;
            if(field[start_x][start_y] == 1) // P인 경우
            {
                result+=1;
            }
            for(int i = 0; i < 4; i++)
            {
                find_people(start_x+x[i],start_y+y[i]);
            }
        }
        else // X인 경우
        {
            return;
        }
    }
    else // 방문한 경우
    {
        return;
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    cin >> n >> m;
    char temp;
    int start_x, start_y;
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            cin >> temp;

            if(temp == 'O') // 비어 있는 경우
                field[i][j] = -2;
            else if(temp == 'I') // I인 경우
            {
                field[i][j] = -2;
                start_x = i;
                start_y = j;
            }
            else if (temp == 'X') // X인 경우
                field[i][j] = -1;
            else if(temp == 'P') // P 찾는 사람
                field[i][j] = 1;
        }
    }

    find_people(start_x,start_y);
    if(result == 0)
    {
        cout << "TT";
    }else{
        cout << result;
    }
}
