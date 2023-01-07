package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
)

func main() {
	read := bufio.NewReader(os.Stdin)
	fmt.Println("Enter text: ")
	text, _ := read.ReadString('\n')
	text1, _ := read.ReadString('\n')
	text2, _ := read.ReadString('\n')
	text3, _ := read.ReadString('\n')
	text4, _ := read.ReadString('\n')

	file, err := os.Create("output.md")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	fmt.Fprintln(file, text)
	file.Close()
}
