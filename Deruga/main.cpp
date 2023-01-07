#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
    string text1;

    cout<<"Please Enter Text: "<<endl;
    getline(cin, text);

    ofstream file("file.md");
    file << text << endl;
    file.close();

    return 0;
}
