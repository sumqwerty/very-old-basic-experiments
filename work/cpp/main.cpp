#include <bits/stdc++.h>
using namespace std;

void printTheArray(int arr[], int n)
{
    bool fine=true;
	for (int i = 1; i < n; i++) {
		if(arr[i]==0 && arr[i-1] == 0){
            fine=false;
            return;
		}
	}
	if(fine)
	{
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
    }
	cout << endl;
}


void generateBinaryStrings(int n, int arr[], int i)
{
	if (i == n) {
		printTheArray(arr, n);
		return;
	}
	arr[i] = 0;
	generateBinaryStrings(n, arr, i + 1);

	arr[i] = 1;
	generateBinaryStrings(n, arr, i + 1);
}

// Driver Code
int main()
{
	int n;
	cout<<"Enter n: ";
	cin>>n;

	int arr[n];

	generateBinaryStrings(n, arr, 0);

	return 0;
}

