#include <iostream>
using namespace std;

int main() {
    // Write C++ code here
    string parola="qwerty";
    string input;
    
    do{
     	cout<<"parolanizi giriniz"<<endl;
     	cin>>input;
     	if(input!=parola){
     		cout<<"Parola yalnis"<<endl;
     	 }
	}while(input!=parola);

    cout<<"parola dogru"<<endl;

    return 0;
}
