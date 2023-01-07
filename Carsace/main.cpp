#include <iostream>
using namespace std;

int main()
{
  string way[5];

    cout<<"OOOO"<<endl;
    cout<<"O  O"<<endl;
    cout<<"O XO"<<endl;
    cout<<"OOOO"<<endl;

    cin>>way[0];

    if (way[0] == "W") {
      cout<<"OOOO"<<endl;
      cout<<"O XO"<<endl;
      cout<<"O  O"<<endl;
      cout<<"OOOO"<<endl;

      cin>>way[1];
    }

    if (way[0] == "S") {
      cout<<"CANNOT MOVE"<<endl;
    }

    if (way[0] == "D") {
      cout<<"CANNOT MOVE"<<endl;
    }

    if (way[0] == "A") {
      cout<<"OOOO"<<endl;
      cout<<"O  O"<<endl;
      cout<<"OX O"<<endl;
      cout<<"OOOO"<<endl;

      cin>>way[1];
    }

    if (way[0] == "A") {
      cout<<"OOOO"<<endl;
      cout<<"O  O"<<endl;
      cout<<"OX O"<<endl;
      cout<<"OOOO"<<endl;

      cin>>way[1];
    }
}
