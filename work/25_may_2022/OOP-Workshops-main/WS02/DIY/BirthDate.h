#ifndef SDDS_BIRTHDATE_H_
#define SDDS_BIRTHDATE_H_

namespace sdds{
    bool beginSearch(const char* filename);
    bool readBirthDate(int month);
    void sort();
    void displayBirthdays();
    void deallocate();
    void endSearch();
}


#endif