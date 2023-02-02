package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	var filename string
	fmt.Print("Enter file name: ")
	fmt.Scanf("%s\n", &filename)

	file, err := os.OpenFile(filename, os.O_RDWR|os.O_CREATE, 0666)
	if err != nil {
		fmt.Printf("Error opening/creating file: %v\n", err)
		return
	}
	defer file.Close()

	fmt.Println("Enter text. Press Ctrl+D to save and exit.")
	for scanner.Scan() {
		_, err := file.WriteString(scanner.Text() + "\n")
		if err != nil {
			fmt.Printf("Error writing to file: %v\n", err)
			return
		}
	}

	fmt.Println("File saved.")
}
