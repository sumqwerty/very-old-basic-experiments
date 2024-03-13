#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include "File.h"
#include<iostream>
namespace sdds {
   FILE* fptr;
   bool openFile(const char filename[]) {
      
      fptr = fopen(filename, "r");
      
      return fptr != NULL;
   }
   int noOfRecords() {
      int noOfRecs = 0;
      char ch;
      while (fscanf(fptr, "%c", &ch) == 1) {
         noOfRecs += (ch == '\n');
      }
      rewind(fptr);
      return noOfRecs;
   }

   bool read(char *name){
      if(fscanf(fptr, "%[^,],", name)==1)return true;
      return false;
   }

   bool read(int &num){
      if(fscanf(fptr, "%d,",&num)==1)return true;
      return false;
   }

   bool read(char &g){
      if(fscanf(fptr, "%c\n", &g)==1)return true;
      return false;
   }


   void closeFile() {
      if (fptr) fclose(fptr);
   }



}