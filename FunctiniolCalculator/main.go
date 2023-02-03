package main

import (
	"fmt"
)

func main() {
	var NUMBER1, NUMBER2 int
	var OPERATION, CONTROL string
	var GEOMETRYMODES int
	fmt.Println("Please enter a number")
	fmt.Scan(&NUMBER1)
	fmt.Println("Please enter a number")
	fmt.Scan(&NUMBER2)
	fmt.Println("+ . - , * , / for first 4 equations. add ! to swap the numbers places. AD to enter Advanced mode")
	fmt.Scan(&OPERATION)

	switch OPERATION {
	case "+":
		fmt.Println(NUMBER1 + NUMBER2)
		fmt.Scan(&CONTROL)
		break
	case "-":
		fmt.Println(NUMBER1 - NUMBER2)
		fmt.Scan(&CONTROL)
		break
	case "*":
		fmt.Println(NUMBER1 * NUMBER2)
		fmt.Scan(&CONTROL)
		break
	case "/":
		if NUMBER1 == 0 || NUMBER2 == 0 {
			fmt.Println("Error. They cannot be 0")
			fmt.Scan(&CONTROL)
		} else {
			fmt.Println(NUMBER1 / NUMBER2)
			fmt.Scan(&CONTROL)
		}
		break
	case "+!":
		fmt.Println(NUMBER2 + NUMBER1)
		fmt.Scan(&CONTROL)
		break
	case "-!":
		fmt.Println(NUMBER2 - NUMBER1)
		fmt.Scan(&CONTROL)
		break
	case "*!":
		fmt.Println(NUMBER2 * NUMBER1)
		fmt.Scan(&CONTROL)
		break
	case "/!":
		if NUMBER1 == 0 || NUMBER2 == 0 {
			fmt.Println("Error. Main number cannot be smaller than 0")
			fmt.Scan(&CONTROL)
		} else {
			fmt.Println(NUMBER1 / NUMBER2)
			fmt.Scan(&CONTROL)
		}
		break
	case "AD":
		fmt.Println("1 to enter advanced mode 2 to enter rectangle mode 3 to enter triangle mode.4 to enter circle mode")
		fmt.Scan(&GEOMETRYMODES)
		break
	default:
		fmt.Println("Unknown Mode")
		break
	}

	var SQUAREMODE, RECTANGLEMODE, TRIANGLEMODE, CIRCLEMODE int
	switch GEOMETRYMODES {
	case 1:
		fmt.Println("1 to calculate the area of a square. 2 to calculate the perimeter of a square")
		fmt.Scan(&SQUAREMODE)
		break
	case 2:
		fmt.Println("1 to calculate the area of a rectangle. 2 to calculate the perimeter of a rectangle")
		fmt.Scan(&RECTANGLEMODE)
		break
	case 3:
		fmt.Println("1 to calculate the area of a triangle. 2 to calculate the perimeter of a triangle")
		fmt.Scan(&TRIANGLEMODE)
		break
	case 4:
		fmt.Println("1 to calculate the area of a circle. 2 to calculate the perimeter of a circle")
		fmt.Scan(&CIRCLEMODE)
		break
	default:
		fmt.Println("Unknown")
		break
	}

	var sq float32
	switch SQUAREMODE {
	case 1:
		squarearea(sq)
		fmt.Scan(&CONTROL)
		break
	case 2:
		squareperi(sq)
		fmt.Scan(&CONTROL)
		break
	default:
		fmt.Println("Unknown Mode")
	}

	var reclong, recshort float32
	switch RECTANGLEMODE {
	case 1:
		recarea(reclong, recshort)
		fmt.Scan(&CONTROL)
		break
	case 2:
		recperi(reclong, recshort)
		fmt.Scan(&CONTROL)
		break
	default:
		fmt.Println("Unknown")
		break
	}

	var tribase, triheight float32
	var triareay, triareax float32
	var tria, trib, tric float32
	switch TRIANGLEMODE {
	case 1:
		triarea(tribase, triheight, triareay, triareax)
		fmt.Scan(&CONTROL)
		break
	case 2:
		triperi(tria, trib, tric)
		fmt.Scan(&CONTROL)
		break
	default:
		fmt.Println("Unknown")
		break
	}

	var radius, circlearearesult, circleperimeterresult float32
	var pi float32 = 3.14

	switch CIRCLEMODE {
	case 1:
		circlearea(pi, radius, circlearearesult)
		fmt.Scan(&CONTROL)
		break
	case 2:
		circleperi(pi, radius, circleperimeterresult)
		fmt.Scan(&CONTROL)
		break
	default:
		fmt.Println("Unknwon")
		break
	}
}

func squarearea(sq float32) {
	fmt.Println("Please enter how long is the one side of square")
	fmt.Scan(&sq)
	if sq < 1 {
		fmt.Println("ERROR: Side Cannot be smaller than 1")
	} else {
		fmt.Println(sq * sq)
	}
}

func squareperi(sq float32) {
	fmt.Println("Please enter how long is the one side of square")
	fmt.Scan(&sq)
	if sq < 1 {
		fmt.Println("ERROR: Side Cannot be smaller than 1")
	} else {
		fmt.Println(sq + sq + sq + sq)
	}
}

func recarea(reclong, recshort float32) {
	fmt.Println("Please enter how long is the long side of the rectangle")
	fmt.Scan(&reclong)
	fmt.Println("Please enter how long is the short side of the rectangle")
	fmt.Scan(&recshort)

	if reclong < 1 || recshort < 1 {
		fmt.Println("Error. One of the sides cannot be smaller than 1")
		if reclong == recshort {
			fmt.Println("Error. They cannot be same")
		}
	} else {
		fmt.Println(recshort * reclong)
	}
}

func recperi(reclong, recshort float32) {
	fmt.Println("Please enter how long is the long side of the rectangle")
	fmt.Scan(&reclong)
	fmt.Println("Please enter how long is the short side of the rectangle")
	fmt.Scan(&recshort)

	if reclong < 1 || recshort < 1 {
		fmt.Println("Error. One of the sides cannot be smaller than 1")
		if reclong == recshort {
			fmt.Println("Error. They cannot be same")
		}
	} else {
		fmt.Println(recshort + recshort + reclong + reclong)
	}
}

func triarea(tribase, triheight, triareay, triareax float32) {
	fmt.Println("Please enter how long is the base of triangle")
	fmt.Scan(&tribase)
	fmt.Println("Please enter how long is the height of triangle")
	fmt.Scan(&triheight)

	if tribase < 1 || triheight < 1 {
		fmt.Println("They cannot be smaller than 1")
		if tribase == triheight {
			fmt.Println("They cannot be equal")
		}
	} else {
		triareay = tribase * triheight
		triareax = triareay / 2
		fmt.Println(triareax)
	}
}

func triperi(tria, trib, tric float32) {
	fmt.Println("Please enter how long is one side of the triangle")
	fmt.Scan(&tria)
	fmt.Println("Please enter how long is one side of the triangle")
	fmt.Scan(&trib)
	fmt.Println("Please enter how long is one side of the triangle")
	fmt.Scan(&tric)

	if tria < 0.1 || trib < 0.1 || tric < 0.1 {
		fmt.Println("They cannot be smaller than 1")
	} else {
		fmt.Println(tria + trib + tric)
	}
}

func circlearea(pi, radius, circlearearesult float32) {
	fmt.Println("Please enter how long is the radius")
	fmt.Scan(&radius)

	if radius < 0.1 {
		fmt.Println("Radius cannot be smaller than 0.1")
	} else {
		circlearearesult = radius * radius
		fmt.Println(circlearearesult * pi)
	}
}

func circleperi(pi, radius, circleperimeterresult float32) {
	fmt.Println("Please enter how long is the radius")
	fmt.Scan(&radius)

	if radius < 0.1 {
		fmt.Println("Radius cannot be smaller than 0.1")
	} else {
		circleperimeterresult = radius * pi
		fmt.Println(circleperimeterresult * 2)
	}
}
