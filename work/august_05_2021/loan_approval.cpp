#include<iostream>
#include<fstream>
#include<vector>
#include<string>

using namespace std;


class LoanApplicants
{
    private:
        string full_name="";
        int education;
        int experience;
        int loan_amount;
        int *yearly_profits;
        int sz;
    public:
        LoanApplicants(string _name, int _edu, int _exp, int _amt, int *_profit, int _sz)
        {
            full_name = _name;
            education = _edu;
            experience = _exp;
            loan_amount = _amt;
            sz = _sz-1;
            yearly_profits = new int[sz];
            for(int i=0; i<sz; ++i)yearly_profits[i] = _profit[i];
        }

        string getName(){ return full_name; }

        int getEdu(){ return education; }

        int getExp(){ return experience; }

        int getLoanAmt() { return loan_amount; }

        int getAvg()
        {
            int res=0;
            for(int i=0; i<sz; ++i)
            {
                res += yearly_profits[i];
            }
            res = res/sz;
            return res;

        }

        void disp()
        {
            cout<<full_name<<endl;
        }
};


vector<LoanApplicants> active_applications;
vector<LoanApplicants> denied_applications;
vector<LoanApplicants> approved_applications;
int budget;
string date;


void addActiveApplication(LoanApplicants temp)
{
    if(active_applications.size()<5000) // limit of applications that can be stored
    {
        if(active_applications.size() == 0)active_applications.push_back(temp);
        else
        {
            int i=0;

            while(i<active_applications.size() && temp.getAvg()<=active_applications[i].getAvg())
                ++i;

            active_applications.insert(active_applications.begin()+i,temp);
        }
    }
}

void saveApplication(vector<string> command)
{
    int sz = command.size() - 4;
    int profit[sz];

    for(int i=5,j=0; i<command.size(); ++i,++j)
    {
        profit[j] = stoi(command.at(i));
    }

    LoanApplicants temp(command.at(1), stoi(command.at(2)), stoi(command.at(3)), stoi(command.at(4)), profit,sz);
    addActiveApplication(temp);


}

void makeDecisions(vector<string> command)
{

    date = command[1];
    budget = stoi(command[2]);
    int sz = active_applications.size();

    for (int i = 0; i < active_applications.size(); ++i)
    {

        if(active_applications[i].getEdu() + active_applications[i].getExp() < 10)
        {
            // deny application
            denied_applications.push_back(active_applications[i]);
            active_applications.erase(active_applications.begin()+i);
            --i;
        }
        else
        {
            if(budget >= active_applications[i].getLoanAmt())
            {
                // grant loan
                budget = budget - active_applications[i].getLoanAmt();
                approved_applications.push_back(active_applications[i]);
                active_applications.erase(active_applications.begin()+i);
                --i;
            }

        }
    }
}


void print()
{
    string actv = "(";
    cout<<"active_applications"<<'\t';
    for(int i=0; i<active_applications.size(); ++i)
    {
        cout<<"("<<active_applications[i].getName()<<","<<active_applications[i].getLoanAmt()<<")"<<'\t';
    }
    cout<<endl;
    cout<<"approved_applications"<<'\t';
    for(int i=0; i<approved_applications.size(); ++i)
    {
        cout<<"("<<approved_applications[i].getName()<<","<<approved_applications[i].getLoanAmt()<<","<<date<<")"<<'\t';
    }
    cout<<endl;

    cout<<"denied_applications"<<'\t';
    for(int i=0; i<denied_applications.size(); ++i)
    {
        cout<<"("<<denied_applications[i].getName()<<","<<denied_applications[i].getLoanAmt()<<","<<date<<")"<<'\t';
    }
    cout<<endl;


}

// Parsing commands
void commands(char *str)
{
    vector<string> comm;
    string st = "";
    for(int i=0; str[i-1]!='\0'; ++i)
    {
        if(str[i] == '\t' || str[i] == '\0')
        {
            comm.push_back(st);
            st = "";
        }
        else st += str[i];
    }

    if(comm.at(0) == "save_application")saveApplication(comm);
    else if(comm.at(0) == "make_decisions")makeDecisions(comm);
    else if(comm.at(0) == "print")print();


}


int main(int argc, char *argv[])
{
    ifstream fil(argv[1], ios::in); // open commands.txt
    char line[256];

    while(!fil.eof())
    {
        fil.getline(line,255); // read line by line
        commands(line);
    }

    fil.close(); // close commands.txt
	return 0;
}















