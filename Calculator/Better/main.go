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
		fmt.Println("1 to enter advanced mode 2 to enter rectangle mode 3 to enter triangle mode")
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
		fmt.Println("1 to calculate the area of a square. 2 to calculate the perimeter of a square")
		fmt.Scan(&CIRCLEMODE)
	default:
		fmt.Println("Unknown")
		break
	}

	var sq int
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

	var reclong, recshort int
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

	var tribase, triheight int
	var triareay, triareax int
	var tria, trib, tric int
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
		fmt.Scan(&CONTROL)
	}

	var radius, circleareay int
	var circleareax float32
	var pi float32 = 3.14
	var circleperimeter float32
	switch CIRCLEMODE {
	case 1:
		circlearea(pi, circleareax, radius, circleareay)
		fmt.Scan(&CONTROL)
		break
	case 2:
		circleperi(pi, circleperimeter, radius)
		fmt.Scan(&CONTROL)
		break
	default:
		fmt.Println("Unknown")
		fmt.Scan(&CONTROL)
	}
}

func squarearea(sq int) {
	fmt.Println("Please enter how long is the one side of square")
	fmt.Scan(&sq)
	if sq < 1 {
		fmt.Println("ERROR: Side Cannot be smaller than 1")
	} else {
		fmt.Println(sq * sq)
	}
}

func squareperi(sq int) {
	fmt.Println("Please enter how long is the one side of square")
	fmt.Scan(&sq)
	if sq < 1 {
		fmt.Println("ERROR: Side Cannot be smaller than 1")
	} else {
		fmt.Println(sq + sq + sq + sq)
	}
}

func recarea(reclong, recshort int) {
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

func recperi(reclong, recshort int) {
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

func triarea(tribase, triheight, triareay, triareax int) {
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

func triperi(tria, trib, tric int) {
	fmt.Println("Please enter how long is one side of the triangle")
	fmt.Scan(&tria)
	fmt.Println("Please enter how long is one side of the triangle")
	fmt.Scan(&trib)
	fmt.Println("Please enter how long is one side of the triangle")
	fmt.Scan(&tric)

	if tria < 1 || trib < 1 || tric < 1 {
		fmt.Println("They cannot be smaller than 1")
	} else {
		fmt.Println(tria + trib + tric)
	}
}

func circlearea(pi, circleareax float32, radius, circleareay int) {
	fmt.Println("Please enter how long is the radius of circle")
	fmt.Scan(&radius)
	if radius < 1 {
		fmt.Println("Radius cannot be smaller than 1 ")
	} else {
		circleareay = radius * radius
		circleareax = float32(circleareay) * 3.14
		fmt.Println(circleareax)
	}
}

func circleperi(pi, circleperimeter float32, radius int) {
	fmt.Println("Please enter how long is the radius of circle")
	fmt.Scan(&radius)
	if radius < 1 {
		fmt.Println("Radius cannot be smaller than 1 ")
	} else {
		circleperimeter = float32(radius) * float32(radius)
		fmt.Println(circleperimeter * pi)
	}
}
