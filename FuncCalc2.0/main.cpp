#include <iostream>
using namespace std;

int squarearea(int sq){
    cout << "Please Enter How long is a one side of the square" << endl;
    cin >> sq;
    if (sq < 1){
        cout << "Cannot be smaller than 1 " << endl;
    } else {
        cout << "Result: " << sq * sq << endl;
    }
    return 0;
}

int squareperimeter(int sq){
    cout << "Please Enter How long is a one side of the square" << endl;
    cin >> sq;
    if (sq < 1){
        cout << "Cannot be smaller than 1 " << endl;
    } else {
        cout << "Result: " << sq * 4 << endl;
    }

    return 0;
}

int recarea(float reclong, float recshort){
    cout << "Please Enter How long is the long side of rectangle" << endl;
    cin >> reclong;
    cout << "Please Enter How long is the short side of rectangle" << endl;
    cin >> recshort;
    if (reclong < 1 ||recshort < 1){
        cout << "Any of them cannot be smaller than 1" << endl;
    } else {
        cout << "Result: " << recshort * reclong << endl;
    }
    return 0;
}
int recperi(float reclong, float recshort){
    cout << "Please Enter How long is the long side of rectangle" << endl;
    cin >> reclong;
    cout << "Please Enter How long is the short side of rectangle" << endl;
    cin >> recshort;
    if (reclong < 1 ||recshort < 1){
        cout << "Any of them cannot be smaller than 1" << endl;
    } else {
        cout << "Result: " << reclong + reclong + recshort + recshort << endl;
    }
    return 0;
}

int triarea(float tribase, float triheight, float triareay, float triareax){
    cout << "Please enter how long is the base od triangle" << endl;
    cin >> tribase;
    cout << "Please enter how long is the triheight od triangle" << endl;
    cin >> triheight;

    if (triheight < 1 || triheight < 1 || triheight == tribase){
        cout << "Cannot be smaller than 1 or base and height is equal" << endl;
    } else {
        triareax = triheight * tribase;
        triareay = triareax / 2;
        cout << "Result: " << triareay << endl;
    }
    return 0;
}

int triperimeter(float tria, float trib, float tric){
    cout << "Please enter how  long is the first side of triangle" << endl;
    cin >> tria;
    cout << "Please enter how  long is the second side of triangle" << endl;
    cin >> trib;
    cout << "Please enter how  long is the second side of triangle" << endl;
    cin >> tric;

    if (tria < 0.1 || trib < 0.1 || tric < 0.1){
        cout << "Error. any of the sides cannot be smaller than 1 " << endl;
    } else {
        cout << "Result: " << tria + trib + tric << endl;
    }
    return 0;
}

int circlearea(float pi, float radius, float circlearean){
    cout << "Please enter how long is the radius of circle" << endl;
    cin >> radius;
    if (radius < 0.1){
        cout << "Radius cannot be smaller than 0.1" << endl;
    } else {
        circlearean = radius * radius;
        return circlearean * pi;
    }
}

int circleperimeter(float pi, float radius, float circlepararesult){
    cout << "Please enter how long is the radius of circle" << endl;
    cin >> radius;
    if (radius < 1){
        cout << "Radius cannot be smaller than 0.1" << endl;
    } else {
        circlepararesult = radius * pi;
        cout << "Result: " << circlepararesult * 2 << endl;
    }
    return 0;
}

int main() {
    int NUMBER1, NUMBER2, GEOMETRY, CONTROL;
    string OPERATION;
    cout << "Please enter a number" << endl;
    cin >> NUMBER1;
    cout << "Please enter a number" << endl;
    cin >> NUMBER2;
    cout << "+,-,*,/ for first equations . AD to enter Advanced mode" << endl;
    cin >> OPERATION;

    if (OPERATION == "+") {
        cout << "Result: " << NUMBER1 + NUMBER2 << endl;
        cin >> CONTROL;
    } else if (OPERATION == "-") {
        cout << "Result: " << NUMBER1 - NUMBER2 << endl;
        cin >> CONTROL;
    } else if (OPERATION == "*") {
        cout << "Result: " << NUMBER1 * NUMBER2 << endl;
        cin >> CONTROL;
    } else if (OPERATION == "/") {
        if (NUMBER1 == 0 || NUMBER2 == 0) {
            cout << "Error. They cannot be zero" << endl;
            cin >> CONTROL;
        } else {
            cout << "Result: " << NUMBER1 / NUMBER2 << endl;
            cin >> CONTROL;
        }
    } else if (OPERATION == "AD") {
        cout << "1 to enter Square mode. 2 to enter rectangle mode. 3 to enter Triangle mode" << endl;
        cin >> GEOMETRY;
    } else {
        cout << "Unknown" << endl;
        cin >> CONTROL;
    }

    int SQUAREMODE, RECTANGLEMODE, TRIANGLEMODE, CIRCLEMODE;

    switch (GEOMETRY) {
        case 1:
            cout << "1 to calculate the area of a square. 2 to calculate the perimeter of a square" << endl;
            cin >> SQUAREMODE;
            break;
        case 2:
            cout << "1 to calculate the area of a square. 2 to calculate the perimeter of a square" << endl;
            cin >> RECTANGLEMODE;
            break;
        case 3:
            cout << "1 to calculate the area of a square. 2 to calculate the perimeter of a square" << endl;
            cin >> TRIANGLEMODE;
            break;
        case 4:
            cout << "1 to calculate the area of a square. 2 to calculate the perimeter of a square" << endl;
            cin >> CIRCLEMODE;
            break;
        default:
            cout << "Unknown" << endl;
            break;
    }

    int sq;

    switch (SQUAREMODE) {
        case 1:
            squarearea(sq);
            cin >> CONTROL;
            break;
        case 2:
            squareperimeter(sq);
            cin >> CONTROL;
            break;
        default:
            cout << "Unknown" << endl;
            cin >> CONTROL;
            break;
    }

    float reclong, recshort;
    switch (RECTANGLEMODE) {
        case 1:
            recarea(reclong, recshort);
            cin >> CONTROL;
            break;
        case 2:
            int RECTANGLE_PERİMETER = recperi(reclong, recshort);
            cout << "Result: " << RECTANGLE_PERİMETER << endl;
            cin >> CONTROL;
            break;
    }
    float tribase, triheight, triareay, triareax;
    float tria, trib, tric;
    switch (TRIANGLEMODE) {
        case 1:
            triarea(tribase, triareay, triareax, triheight);
            cin >> CONTROL;
            break;
        case 2:
            triperimeter(tria, trib, tric);
            cin >> CONTROL;
            break;
        default:
            cout << "Unknown " << endl;
            cin >> CONTROL;
    }

    float radius;
    float pi = 3.14;
    float circlearean,circlepararesult;

    switch (CIRCLEMODE) {
        case 1:
            circlearea(pi, radius, circlearean);
            cin >> CONTROL;
            break;
        case 2:
            circleperimeter(pi, radius, circlepararesult);
            cin >> CONTROL;
            break;
    }

    return 0;
}
