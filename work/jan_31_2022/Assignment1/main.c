#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char id[100][127];
int credit[100];
float grade[100];
int listSize=0;


// convert grade to points for GPA calculations
float getPoints(float grd)
{
    if(grd>=90) return 4;
    else if(grd>=85 && grd <= 89)return 3.8;
    else if(grd>=85 && grd <= 89)return 3.8;
    else if(grd>=80 && grd <= 84)return 3.6;
    else if(grd>=75 && grd <= 79)return 3.3;
    else if(grd>=70 && grd <= 74)return 3;
    else if(grd>=65 && grd <= 69)return 2.5;
    else if(grd>=60 && grd <= 64)return 2;
    else if(grd>=55 && grd <= 59)return 1.5;
    else if(grd>=50 && grd <= 54)return 1;
    return 0;
}


int menu()
{
    printf("---------------------------------\n");
    printf("Operations on Courses\n");
    printf("---------------------------------\n");
    printf("1.Update Course Grade\n");
    printf("2.Find Maximum Grade\n");
    printf("3.Display Courses\n");
    printf("4.Compute Accumulative GPA\n");
    printf("5.Save the courses to a File\n");
    printf("6.Exit\n");
    printf("Enter your choice\n");
    int n;
    scanf("%d",&n);
    return n;
}

void displayCourses()
{
    printf("Display Courses:\n");
    for(int i=0; i<listSize; ++i){
        printf(" %s\t\t%d\t%.2f \n",id[i],credit[i],grade[i]);
    }
}

void upgradeGrade()
{
    printf("Update Course Grade:\n");
    printf("Enter Course ID:\n");

    char ch[9];
    scanf("%s",ch);

    printf("Enter Course Grade:\n");
    float grd;
    scanf("%f",&grd);

    int iter=0;
    int found = 0;

    while(!found && iter<listSize){
        if(strcmp(ch,id[iter]) == 0)found=1;
        else ++iter;
    }
    if(!found) printf("Wrong ID");

    else{
        grade[iter] = grd;
    }
}

void maxGrade(){
    printf("Find Maximum Grade:\n");

    float res = 0.0;

    for(int i=0; i<listSize; ++i){
        if(grade[i] > res)res = grade[i];
    }

    printf("%.2f \n",res);
}

void accGpa(){
    printf("Compute Accumulative GPA:\n");

    int creditSum = 0;
    float gradeSum = 0;
    for(int i=0; i<listSize; ++i){
        creditSum += credit[i];
        gradeSum += (credit[i] * getPoints(grade[i]));
    }

    float gpa = gradeSum/creditSum;

    printf("GPA  %.2f\n",gpa);
}

// to read the data and store it in arrays to that it can be accessed and updates easily
void fillData()
{
    FILE *file ;
    char dataRead[127];
    file = fopen("grades.txt", "r") ;
    if ( file == NULL )
    {
        printf( "failed to open.") ;
    }
    else
    {
        int col = 1;
        int sz=0;
        char x[127];
        while(fscanf(file, " %127s", x) == 1){

            if(col==1){
                strcpy(id[sz],x);
                ++col;
            }
            else if(col == 2){
                credit[sz] = atoi(x);
                ++col;
            }
            else if(col == 3){
                grade[sz] = (float) atoi(x);
                col = 1;
                ++sz;
            }
        }
        fclose(file);
        listSize = sz;
    }
}

// to write and save the updated data in the text file
void writeData()
{
    FILE *file ;
    char dataRead[127];
    file = fopen("grades.txt", "w") ;
    if ( file == NULL )
    {
        printf( "failed to open.") ;
    }
    else
    {
        for(int i=0; i<listSize; ++i){
            fprintf(file, "%s %d %.2f\n",id[i],credit[i],grade[i]);
        }
        fclose(file);
    }
}

int main()
{
    char name[50];
    printf ( "Enter Student Name:");
    gets (name);
    printf("Welcome ");
    puts (name);
    int gameOver = 0;
    fillData();
    while(!gameOver){
        int choice = menu();
        switch(choice){
            case 1:
                upgradeGrade();
                break;
            case 2:
                maxGrade();
                break;
            case 3:
                displayCourses();
                break;
            case 4:
                accGpa();
                break;
            case 5:
                printf("Saving Courses to the File...\n");
                writeData();
                break;
            case 6:
                printf("Exiting...\n");
                gameOver=1;
                break;
        }
    }
    return 0;
}
