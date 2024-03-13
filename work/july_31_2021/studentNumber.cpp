/*
STUDENT NAME :
STUDENT NUMBER :
*/

#include<iostream>
#include<ctime>
#include<cstdlib>

using namespace std;

void disp(int *arr, int n){
    for(int i=0; i<n; ++i){
        cout<<arr[i]<<" , ";
    }
    cout<<endl;
}
// function to return random number between 1 and 10
int getRandom()
{
    return (rand() % 11);
}

// function that stores 100 random numbers as students’ answers and returns an array contains the frequency of the ratings
int *getFrequency()
{
    int numOfStud = 100;
    int studentResponses[numOfStud]; // array to store student response

    for(int i=0; i<numOfStud; ++i)studentResponses[i] = getRandom(); // filling random responses from 1 to 10

    static int freq[10]; // array to store response frequency

    for(int i=0; i<10; ++i){
        int cnt = 0;
        for(int j=0; j<numOfStud; ++j){
            if((i+1) == studentResponses[j])++cnt; // calulating frequency
        }
        freq[i] = cnt;
    }

    return freq;

}


// prints a table shows the frequency of the ratings.
void dispFreqRatings(int *freq)
{
    cout<<"Rating           Frequency"<<endl; // TABLE HEADINGS
    cout<<"-------         ----------"<<endl;
    for(int i=0; i<10; ++i){
        if(i==9)cout<<(i+1)<<"                   "<<freq[i]<<endl;
        else cout<<(i+1)<<"                    "<<freq[i]<<endl;

    }
    cout<<endl;

}


// prints a bar chart that shows the frequency of the ratings.
void dispBarChart(int *freq)
{
    cout<<"Rating           Frequency"<<endl;
    cout<<"-------         ----------"<<endl;
    for(int i=0; i<10; ++i){
        string bar = "";
        for(int j=0; j<freq[i]; ++j)bar += "*";

        if(i==9)cout<<(i+1)<<"                   "<<bar<<endl;
        else cout<<(i+1)<<"                    "<<bar<<endl;

    }
    cout<<endl;

}

// returns the number of students answers above 5.
int ansAbove5(int *freq)
{
    int num_above_5 = 0;
    for(int i=0; i<10; ++i) if(freq[i]>5)num_above_5 += freq[i];
    return num_above_5;

}

// displays a menu of report options and returns user selection.
int menu()
{
    cout<<"How would you like to display the result?"<<endl;
    cout<<"  1- Tabular form"<<endl;
    cout<<"  2- Bar chart"<<endl;
    cout<<"Please enter either 1 or 2. You can end the program if you enter any other number: ";
    int choice;
    cin>>choice;
    cout<<endl;
    return choice;
}



int main()
{
    srand(time(0)); // initalize seed for the rand() function

    bool gameLoop = true; // run the program until user wants to end it

    int *studentRes;
    studentRes = getFrequency(); // generate 100 random student responses once when the program starts

    // event loop that asks for user input
    while(gameLoop){
        int choice = menu(); // ask the user for the choice
        if(choice == 1) dispFreqRatings(studentRes); // to display ratings
        else if(choice == 2) dispBarChart(studentRes); // to display bar graph
        else{ // to quit the program
            gameLoop = false;
            break;
        }
        cout<<endl;
        cout<<"Number of students answers above 5 is "<<ansAbove5(studentRes)<<"%"<<endl; // display number of students that rated above 5

    }
    return 0;
}
