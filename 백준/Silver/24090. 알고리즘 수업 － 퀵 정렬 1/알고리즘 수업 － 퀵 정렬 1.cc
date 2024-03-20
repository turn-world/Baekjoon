#include <iostream>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
using namespace std;
int N, chance, cnt = 0;

int partition(int arr[], int p, int r)
{
    int x, i, tmp;

    x = arr[r];    // 기준원소
    i = p - 1;   // i는 x보다 작거나 작은 원소들의 끝지점
    for (int j = p; j < r; j++)  // j는 아직 정해지지 않은 원소들의 시작 지점
    {
        if (arr[j] <= x) // i값 증가 후 A[i] <-> A[j] 교환
        {
            tmp = arr[j];
            arr[j] = arr[++i];
            arr[i] = tmp;
            cnt++;
            if (cnt == chance)
            {
                cout << arr[i] << ' ' << arr[j] << '\n';
                return (-1);
            }
        }
    }
    if (i + 1 != r) // i + 1과 r이 서로 다르면 A[i + 1]과 A[r]을 교환
    {
        tmp = arr[r];
        arr[r] = arr[i + 1];
        arr[i + 1] = tmp;
        cnt++;
        if (cnt == chance)
        {
            cout << arr[i + 1] << ' ' << arr[r] << '\n';
            return (-1);
        }
    }
    return i + 1;
}

void quick_sort(int arr[], int p, int r)
{
    int q;
    if (p < r)
    {
        q = partition(arr, p, r);  // 분할
        if (q == -1)
            return ;
        quick_sort(arr, p, q - 1);  // 왼쪽 부분 배열 정렬
        quick_sort(arr, q + 1, r);  // 오른쪽 부분 배열 정렬
    }
}

int main()
{
    fast;
    cin >> N >> chance;
    int *arr = new int[N];

    for (int i = 0; i < N; i++)
        cin >> arr[i];
    quick_sort(arr, 0, N-1);
    if (cnt < chance)
        cout << -1;

    delete[] arr;
}