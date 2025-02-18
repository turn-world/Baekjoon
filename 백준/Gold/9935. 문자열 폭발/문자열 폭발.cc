#include <bits/stdtr1c++.h>
#include <stack>
#include <algorithm>
#include <string>
using namespace std;
string word, boom;
stack <char> ans;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> word >> boom;

    string result;

    result.reserve(1000000);

    for(int i = 0; i < word.size(); i++)
    {
        ans.push(word[i]);

        if(word[i] == boom[boom.size()-1] && ans.size() >= boom.size())
        {
            string temp;
            for(int j = 0; j <boom.size(); j++)
            {
                temp.push_back(ans.top());
                ans.pop();
            }
            reverse(temp.begin(),temp.end());

            if(temp.compare(boom) != 0)
            {
                for(int a= 0; a <temp.size(); a++) ans.push(temp[a]);
            }
        }
    }

    while(!ans.empty())
    {
        result.push_back(ans.top());
        ans.pop();
    }

    reverse(result.begin(),result.end()); // 뒤집어서 순서대로 나오게함
    if(result.empty()) cout << "FRULA"; // 스택이 비어있다면 모두 폭발한 것
    else cout << result;
}
