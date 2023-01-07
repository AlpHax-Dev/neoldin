//go 1.19.4

package main

import "fmt"

func main() {
	var x, y int
	var z string
	var control string
	var recmode int
	var recshort int
	var reclong int

	fmt.Print("Please enter the first number: ")
	fmt.Scan(&x)

	fmt.Print("Please enter the second numbers: ")
	fmt.Scan(&y)
	fmt.Println("Please Enter A Number. Symbols +,-,*,/ are for first four main equations. +!,-!,*!,/! are what if these numbers place is switched. Write AD To enable advenced Calculations")
	fmt.Scan(&z)

	var d, d1 int
	if x == 0 || y == 0 {
		fmt.Println("Cannot divide by 0")
	} else {
		d = x / y
		d1 = y / x
	}

	var sqcontrol int
	var sq int

	a := x + y
	b := x - y
	c := x * y

	a1 := y + x
	b1 := y - x
	c1 := y * x

	switch z {
	case "+":
		fmt.Println(a)
		fmt.Scan(&control)
	case "-":
		fmt.Println(b)
		fmt.Scan(&control)
	case "*":
		fmt.Println(c)
		fmt.Scan(&control)
	case "/":
		fmt.Println(d)
		fmt.Scan(&control)
	case "+!":
		fmt.Println(a1)
		fmt.Scan(&control)
	case "-!":
		fmt.Println(b1)
		fmt.Scan(&control)
	case "*!":
		fmt.Println(c1)
		fmt.Scan(&control)
	case "/!":
		fmt.Println(d1)
		fmt.Scan(&control)
	case "AD":
		fmt.Println("Please enter a mode. 1 to calculate the area of a square. 2 to calculate the perimeter of square. 3 to start rectangle mode ")
		fmt.Scan(&sqcontrol)
	default:
		fmt.Println("İnvalid")
		fmt.Scan(&control)
	}

	switch sqcontrol {
	case 1:
		fmt.Println("Please Enter how long a side of the square")
		fmt.Scan(&sq)
		fmt.Println(sq * sq)
		fmt.Scan(&control)
	case 2:
		fmt.Println("Please Enter How Long a side of the square")
		fmt.Scan(&sq)
		fmt.Println(sq + sq + sq + sq)
		fmt.Scan(&control)
	case 3:
		fmt.Println("Please Enter A mode. 1 to calculate the area of the rectangle. 2 to calculate the perimeter of a rectangle")
		fmt.Scan(&recmode)
	default:
		fmt.Println("İnvalid")
	}

	switch recmode {
	case 1:
		fmt.Println("Please enter how long the short side of the rectangle")
		fmt.Scan(&recshort)
		fmt.Println("Please enter how long the long side of the rectangle")
		fmt.Scan(&reclong)

		fmt.Println(recshort * reclong)
		fmt.Scan(&control)
	case 2:
		fmt.Println("Please enter how long the short side of the rectangle")
		fmt.Scan(&recshort)
		fmt.Println("Please enter how long the long side of the rectangle")
		fmt.Scan(&reclong)

		fmt.Println(recshort + recshort + reclong + reclong)
		fmt.Scan(&control)
	}

}
