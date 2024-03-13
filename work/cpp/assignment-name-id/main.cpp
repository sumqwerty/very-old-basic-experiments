#include <bits/stdc++.h>
using namespace std;

void printRes(int arr[], int n)
{
    bool fine=true;
	for (int i = 1; i < n; i++) {
		if(arr[i]==0 && arr[i-1] == 0){
            fine=false;
            return;
		}
	}
	if(fine) // print only if binary string is valid
	{
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
    }
	cout << endl;
}

// generating binary sequence recursivley
void binSequence(int n, int arr[], int i)
{
	if (i == n) {
		printRes(arr, n);
		return;
	}
	arr[i] = 0;
	binSequence(n, arr, i + 1);

	arr[i] = 1;
	binSequence(n, arr, i + 1);
}

// Driver Code
int main()
{
	int n;
	cout<<"Enter n: ";
	cin>>n;

	int arr[n];

	binSequence(n, arr, 0);

	return 0;
}

