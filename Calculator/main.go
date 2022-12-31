//go 1.19.4

package main

import "fmt"

func main() {
	var x, y int
	var z string
	var control string

	fmt.Print("Please enter the first number: ")
	fmt.Scan(&x)

	fmt.Print("Please enter the second numbers: ")
	fmt.Scan(&y)
	fmt.Println("Please Enter A Number. Symbols +,-,*,/ are for first four main equations. +!,-!,*!,/! are what if these numbers place is switched")
	fmt.Scan(&z)

	var d, d1 int
	if x == 0 || y == 0 {
		fmt.Println("Cannot divide by 0")
	} else {
		d = x / y
		d1 = y / x
	}

	a := x + y
	b := x - y
	c := x * y

	a1 := y + x
	b1 := y - x
	c1 := y * x

	switch z {
	case "4":
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
	default:
		fmt.Println("İnvalid")
		fmt.Scan(&control)
	}
}
