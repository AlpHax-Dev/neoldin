#include <iostream>

using namespace std;

int main()
{
    int x, y;
    string z;

    int allmode;
    int sqmode;
    int trimode;
    int recmode;


    cout << "Please enter a number" << endl;
    cin >> x;
    cout << "Please enter a number" << endl;
    cin >> y;
    cout << "+,-,*,/ for 4 operations. add ! end of the symbol to reverse the number order. AD for advanced mode" << endl;
    cin >> z;

    if (z == "+") {
        cout << x + y << endl;
    }
    else if (z == "-") {
        cout << x - y << endl;
    }
    else if (z == "*") {
        cout << x * y << endl;
    }
    else if (z == "/") {
        if (x == 0) {
            cout << "Main Number cannot be 0" << endl;
        }
        else {
            cout << x / y << endl;
        }
    }
    else if (z == "+!") {
        cout << y + x << endl;
    }
    else if (z == "-!") {
        cout << y - x << endl;
    }
    else if (z == "*!") {
        cout << y * x << endl;
    }
    else if (z == "/!") {
        if (y == 0) {
            cout << "Error. Main Number Cannot be 0" << endl;
        }
        else {
            cout << y / x << endl;
        }
    }
    else if (z == "AD") {
        cout << "1 to enter square mode. 2 to enter rectangle mode 3 to enter triangle mode" << endl;
        cin >> allmode;
    }
    else {
        cout << "Unknown" << endl;
    }

    switch (allmode) {
        case 1:
            cout << "1 to calculate the area of a square. 2 to calculate the perimeter of a square" << endl;
            cin >> sqmode;
            break;
        case 2:
            cout << "1 to calculate the area of a rectangle. 2 to calculate the perimeter of a rectangle" << endl;
            cin >> recmode;
            break;
        case 3:
            cout << "1 to calculate the area of a triangle. 2 to calculate the perimeter of a triangle" << endl;
            cin >> trimode;
            break;
        default:
            cout << "Unknown Mode" << endl;
            break;
    }

    int sq;

    switch (sqmode){
        case 1:
            cout << "Please enter how long onse side of the square" << endl;
            cin>>sq;
            if (sq < 1){
                cout << " Error. Side cannot be smaller then 1" << endl;
            } else {
                cout << sq * sq << endl;
            }
            break;
        case 2:
            cout << "Please enter how long onse side of the square" << endl;
            cin>>sq;
            if (sq < 1){
                cout << " Error. Side cannot be smaller then 1" << endl;
            } else {
                cout << sq + sq + sq + sq << endl;
            }
        default:
            cout << "Unknown Mode" << endl;
            break;
    }
    int reclong;
    int recshort;

    switch (recmode){
        case 1:
            cout << "Please Enter how long the long side of the rectangle" << endl;
            cin >> reclong;
            cout << "Please Enter how long one the short of the rectangle" << endl;
            cin >> recshort;

            if (reclong < 1 || recshort < 1){
                cout << "Any of these sides cannot be 0" << endl;
            } else {
                cout << reclong * recshort << endl;
            }
            break;
        case 2:
            cout << "Please Enter how long the long side of the rectangle" << endl;
            cin >> reclong;
            cout << "Please Enter how long one the short of the rectangle" << endl;
            cin >> recshort;

            if (reclong < 1 || recshort < 1){
                cout << "Any of these sides cannot be 0" << endl;
            } else {
                cout << reclong + recshort + recshort + reclong << endl;
            }
            break;
        default:
            cout << "Unknown Mode" << endl;
            break;
    }

    int tribase,triheight;
    int tria,trib,tric;

    switch (trimode){
        case 1:
            cout << "Please enter how long is the base of triangle" << endl;
            cin >> tribase;
            cout << "Please enter how long is the base of triangle" << endl;
            cin >> triheight;

            if (triheight < 1 || tribase < 1){
                cout << "One of the main things cannot be smaller than 1" << endl;
            } else {
                int triareay = tribase * triheight;
                int triareax = triareay / 2;
                cout << triareax << endl;
            }
            break;
        case 2:
            cout << "Please enter how long is one side of the  triangle" << endl;
            cin >> tria;
            cout << "Please enter how long is one side of the  triangle" << endl;
            cin >> trib;
            cout << "Please enter how long is one side of the  triangle" << endl;
            cin >> tric;

            if (tria < 5 || trib < 5 || tric < 5){
                cout << "Error" << endl;
            } else {
                cout << tria + trib + tric << endl;
            }
            break;
        default:
            cout << "Unknown" << endl;
    }

    return 0;
}