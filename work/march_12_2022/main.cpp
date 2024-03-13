#include<iostream> // for inputs and outputs
#include<vector> // for vector to store first n integers
#include<cstdlib> // for rand(), srand() to generate random numbers
#include <algorithm> // for next_permutation to generate permutations

using namespace std;

// swapping elements on index i and j, in a vector arr
void swap(vector<int> &arr, int i, int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

// function to display the content of the vector
void disp(vector<int> arr){
	for(int i=0; i<arr.size(); ++i)cout<<arr[i]<<" ";
	cout<<endl;
}

// function to generate and return a random permutation of the input series of integers
vector<int> permute(vector<int> arr, int n){
	int it = rand() % n + 1; // this generates a random number
	while((it--) && next_permutation(arr.begin(), arr.end())); // this loop runs and iterates through all the permutations a random number of times and
	// returns the randomly choosen permutation from all the posstible permutations
	return arr;
}

//sorting function
int bubbleSort(vector<int> &arr){
	int res=0; // counter variable for counting number of comparisons
	for(int i=0; i<arr.size(); ++i){
		bool swp = false; // flag to check it there has be any swaps
		for(int j=0; j<arr.size()-i-1; ++j){
			if(arr[j] > arr[j+1]){
				swap(arr,j,j+1);
				swp = true;
			}
			++res;
		}
		if(!swp)break; // break out of the loop if there was no swap. NO SWAP -> LIST IS SORTED
	}

	return res;
}


//funtion to calculate factorial
int factorial(int n){

	if(n == 1 || n == 0)return 1;
	return n*factorial(n-1);
}


// starting point of the program
int main(){

	srand(time(NULL)); // set random seed
	int n,m;
	cout<<"Enter n: ";
	cin>>n;
	cout<<"Enter number of permutations(m): ";
	cin>>m;

	int choice = factorial(n); // calculating number of possible permutations
	vector<int> arr(n);
	for(int i=1; i<=n; ++i){
		arr[i-1] = i;;
	}
	cout<<"Frist "<<n<<" integers are: ";
	disp(arr);

	int compSum = 0; // overall sums of number of comparisons for all the permutations
	int cases = m;
	while(cases--){
		arr = permute(arr,choice);
		compSum += bubbleSort(arr);
	}
	int avg = compSum/m; // calculating average comparisons over all the permutations 
	cout<<"Average number of comparisons: "<<avg<<endl;
	return 0;
}

