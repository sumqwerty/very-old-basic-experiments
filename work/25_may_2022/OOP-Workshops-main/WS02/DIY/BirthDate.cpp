#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <iostream>
#include <string.h>
#include "BirthDate.h"
using namespace std;
namespace sdds{
    struct  Employee{
        char *e_name;
        int month;
        int year;
        int day;
    };

    Employee *employees;

    int noOfEmp;

    FILE *fptr;
    

    bool beginSearch(const char* filename){
        fptr = fopen(filename, "r");
        if(fptr != NULL){
            std::cout<<"Birthdate search program\n";
            return true;
        }
        std::cout<<"Data file "<<filename<<" not found!"<<std::endl;
        return false;
    }

    bool readBirthDate(int month){
        noOfEmp=0;
        char name[128];

        int m,d,y;
        
        while (fscanf(fptr, "%[^,],%i/%i/%i\n", name, &m, &d, &y) == 4) {
            
            if(month == m){
                ++noOfEmp;
                
            }
        }
        
        rewind(fptr);

        if(noOfEmp < 1)return false;

        cout<<noOfEmp<<" birthdates found:"<<endl;

        // load the employee details in an array
        employees = new Employee[noOfEmp];
        int i=0;
        while (fscanf(fptr, "%[^,],%i/%i/%i\n", name, &m, &d, &y) == 4) {
            
            if(month == m){
                employees[i].e_name = new char[strlen(name)+1];
                strcpy(employees[i].e_name,name);
                employees[i].month = m;
                employees[i].day = d;
                employees[i].year = y;
                ++i;
            }
        }
        rewind(fptr);

        return true;

    }

    void sort() {
        int i, j;
        Employee temp;
        for (i = noOfEmp - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (employees[j].year > employees[j + 1].year) {
                    temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
            }
        }
    }

    void displayBirthdays(){

        for(int i=0; i<noOfEmp; ++i){
            cout<<(i+1)<<") "<<employees[i].e_name<<":"<<endl;
            cout<<employees[i].year<<"-"<<employees[i].month<<"-"<<employees[i].day<<endl;
            cout<<"==================================="<<endl;
        }
        
    }

    void deallocate(){
        for(int i=0; i<noOfEmp; ++i){
            delete [] employees[i].e_name;
        }
        delete [] employees;
    }

    void endSearch(){
        fclose(fptr);
        cout<<"Birthdate Search Program Closed."<<endl;
    }




}