#include<string.h>
#include<iostream>
#include <cstdio>
#include "Student.h"


using namespace std;

namespace sdds{
    int noOfStudents;
    Student* students;
    bool load(Student &stdnt){
        char nm[128];
        if(read(nm)){
            int len = strlen(nm);
            ++len;
            
            stdnt.m_name = new char[len];
            
            strcpy(stdnt.m_name,nm);

        }
        else return false;

        if(!read(stdnt.m_studentNumber))return false;
        if(!read(stdnt.m_grade))return false;
        
        return false;
    }



    bool load(const char filename[]){
        
        if(openFile(filename)){
            
            noOfStudents = noOfRecords();
            
            students = new Student[noOfStudents];

            int cnt = 0;

            for(int i=0; i<noOfStudents; ++i){
                ++cnt;
                load(students[i]);

            }

            if(cnt != noOfStudents){
                cout<<"Error: incorrect number of records read; the data is possibly corrupted."<<endl;
                return false;
            }

            return true;


        }
        return false;

    }

    void sort() {
        int i, j;
        Student temp;
        for (i = noOfStudents - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
            if (students[j].m_grade > students[j + 1].m_grade) {
                temp = students[j];
                students[j] = students[j + 1];
                students[j + 1] = temp;
            }
            }
        }
    }


    void display(const Student &stdnt){
        cout<<stdnt.m_name<<", "<<stdnt.m_studentNumber<<": "<<stdnt.m_grade<<endl;
    }

    void display(){
        sort();
        for(int i=0; i<noOfStudents; ++i){
            cout<<(i+1)<<": "<<students[i].m_name<<", "<<students[i].m_studentNumber<<": "<<students[i].m_grade<<endl;
        }
    }

    void deallocateMemory(){

        for(int i=0; i<noOfStudents; ++i){
            delete students[i].m_name;
        }
        delete students;
        closeFile();
    }
}