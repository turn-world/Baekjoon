#include <bits/stdc++.h>
using namespace std;
vector <int> arr;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N;
    int avg = 0, mid = 0, range, most_val;
    int temp;
    int most_arr[8001] ={0, };
    int max_val = INT_MIN;
    bool not_first = false;

    cin >> N;

    for(int i = 0; i < N; i++)
    {
        cin >> temp;
        arr.push_back(temp);
        avg += temp;
        most_arr[temp+4000]++;
    }
    sort(arr.begin(), arr.end());
    for(int i = 0; i < 8001; i++)
    {
        if(most_arr[i] == 0)
            continue;

        if(most_arr[i] == max_val)
        {
            if(not_first)
            {
                most_val = i - 4000;
                not_first = false;
            }
        }
        if(most_arr[i] > max_val)
        {
            max_val = most_arr[i];
            most_val = i -4000;
            not_first = true;
        }
    }


    mid = arr[arr.size()/2];
    avg = round(float(avg) / N);
    range = arr.back() - arr.front();

    cout << avg << '\n' << mid << '\n' << most_val << '\n' << range;
    }
