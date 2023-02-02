package main

import "fmt"

func main() {
	var op string
	var control string
	var x, y int

	var allmode int
	var sqmode int
	var recmode int
	var trimode int

	var sq float32

	var reclong float32
	var recshort float32

	var tribase int
	var triheight int
	var triareax, triareay int
	var tria, trib, tric float32

	fmt.Println("Please Enter a number")
	fmt.Scan(&x)
	fmt.Println("Please Enter a number")
	fmt.Scan(&y)
	fmt.Println("Please Enter an Operation. +,-,*,/ for firs 4 operations. add ! to end of the symbols to switch the numbers places. Write AD to enter Advenved mode")
	fmt.Scan(&op)

	switch op {
	case "+":
		fmt.Println(x + y)
		fmt.Scan(&control)
	case "-":
		fmt.Println(x - y)
		fmt.Scan(&control)
	case "*":
		fmt.Println(x * y)
		fmt.Scan(&control)
	case "/":
		if x == 0 {
			fmt.Println("Main Number cannot be 0")
			fmt.Scan(&control)
		} else {
			fmt.Println(x / y)
			fmt.Scan(&control)
		}
	case "+!":
		fmt.Println(y + x)
		fmt.Scan(&control)
	case "-!":
		fmt.Println(y - x)
		fmt.Scan(&control)
	case "*!":
		fmt.Println(y * x)
		fmt.Scan(&control)
	case "/!":
		if y == 0 {
			fmt.Println("Main Number cannot be 0")
			fmt.Scan(&control)
		} else {
			fmt.Println(y / x)
			fmt.Scan(&control)
		}
	case "AD":
		fmt.Println("1 to enter Square Mode.2 to enter rectangle mode. 3 to enter triangle mode")
		fmt.Scan(&allmode)
	default:
		fmt.Println("What")
	}

	switch allmode {
	case 1:
		fmt.Println("1 to calculate the area of a square 2 to calculate the perimeter of a square")
		fmt.Scan(&sqmode)
	case 2:
		fmt.Println("1 to calculate the area of a square 2 to calculate the perimeter of a square")
		fmt.Scan(&recmode)
	case 3:
		fmt.Println("1 to calculate the area of a square 2 to calculate the perimeter of a square")
		fmt.Scan(&trimode)
	default:
		fmt.Println("Unknown mode")
	}

	switch sqmode {
	case 1:
		fmt.Println("Please enter how long one side of the square")
		fmt.Scan(&sq)
		fmt.Println(sq * sq)
		fmt.Scan(&control)
	case 2:
		fmt.Println("Please enter how long one side of the square")
		fmt.Scan(&sq)
		fmt.Println(sq + sq + sq + sq)
		fmt.Scan(&control)
	default:
		fmt.Println("Unknown Mode")
	}

	switch recmode {
	case 1:
		fmt.Println("Please enter how long the long side of the square")
		fmt.Scan(&reclong)
		fmt.Println("Please enter how long the short side of the square")
		fmt.Scan(&recshort)

		if reclong < 0 || recshort < 0 {
			fmt.Println("One side cannot be smaller than zero")
		} else {
			fmt.Println(reclong * recshort)
			fmt.Scan(&control)
		}
	case 2:
		fmt.Println("Please enter how long the long side of the square")
		fmt.Scan(&reclong)
		fmt.Println("Please enter how long the short side of the square")
		fmt.Scan(&recshort)
		if reclong < 0 || recshort < 0 {
			fmt.Println("One side cannot be smaller than zero")
		} else {
			fmt.Println(reclong + recshort + recshort + recshort)
			fmt.Scan(&control)
		}
	default:
		fmt.Println("Unknown Operation")
	}

	switch trimode {
	case 1:
		fmt.Println("Please enter how long is the base of triangle")
		fmt.Scan(&tribase)
		fmt.Println("Please enter how long is the base of triangle")
		fmt.Scan(&triheight)

		if triheight < 0 || triheight < 0 {
			fmt.Println("An input cannt be zero or smaller")
		} else {
			triareay = tribase * triheight
			triareax = triareay / 2
			fmt.Println(triareax)
		}
	case 2:
		fmt.Println("Please enter how long one side of the triangle")
		fmt.Scan(&tria)
		fmt.Println("Please enter how long one side of the triangle")
		fmt.Scan(&trib)
		fmt.Println("Please enter how long one side of the triangle")
		fmt.Scan(&tric)

		if tria < 0 || trib < 0 || tric < 0 {
			fmt.Println("One side cannot be smaller than 0")
		} else {
			fmt.Println(tria + trib + tric)
		}
	default:
		fmt.Println("Unknown Operation")
	}
}
