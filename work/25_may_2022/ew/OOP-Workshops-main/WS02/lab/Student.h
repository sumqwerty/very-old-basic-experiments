#ifndef SDDS_STUDENT_H_
#define SDDS_STUDENT_H_
#include "File.h"
namespace sdds{
    struct Student {
        char* m_name;
        int m_studentNumber;
        char m_grade;
    };
    bool load(const char filename[]);
    bool load(Student &stdnt);
    void sort();
    void display(const Student &stdnt);
    void display();
    void deallocateMemory();
}
#endif