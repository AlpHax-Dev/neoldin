package main

import (
	"fmt"
)

func main() {
	var way [5]string

	fmt.Println("OOOO")
	fmt.Println("O  O")
	fmt.Println("O XO")
	fmt.Println("OOOO")
	fmt.Println("Please Enter a direction")
	fmt.Scanln(&way[0])

	if way[0] == "w" {
		fmt.Println("OOOO")
		fmt.Println("O XO")
		fmt.Println("O  O")
		fmt.Println("OOOO")
		fmt.Println("Please Enter a direction")
		fmt.Scanln(&way[1])
	}
	if way[0] == "s" {
		fmt.Println("İNVALİD FOR CURRENT POSİTİON")
	}
	if way[0] == "a" {
		fmt.Println("OOOO")
		fmt.Println("O  O")
		fmt.Println("OX O")
		fmt.Println("OOOO")
		fmt.Println("Please Enter a direction")
		fmt.Scanln(&way[1])
	}
	if way[0] == "d" {
		fmt.Println("İNVALİD FOR CURRENT POSİTİON")
	}
}
