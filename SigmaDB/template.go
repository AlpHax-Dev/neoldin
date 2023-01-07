package main

import "fmt"

const maxSize = 500 // maximum size of the database

// Person represents a person's information
type Person struct {
	Name   string
	Age    int
	Adress string
}

// Database is a simple in-memory database of people
type Database struct {
	People []Person
	Size   int
}

// AddPerson adds a person to the database
func (db *Database) AddPerson(name string, age int, adress string) {
	if db.Size < maxSize {
		db.People = append(db.People, Person{Name: name, Age: age, Adress: adress})
		db.Size++
	} else {
		fmt.Println("Error: Database is full.")
	}
}

// RemovePerson removes a person from the database
func (db *Database) RemovePerson(name string) {
	// search for the person in the database
	for i, person := range db.People {
		if person.Name == name {
			// person found, remove them by slicing the slice
			db.People = append(db.People[:i], db.People[i+1:]...)
			db.Size--
			return
		}
	}

	// person not found
	fmt.Println("Error: Person not found in the database.")
}

// ModifyAge modifies a person's age in the database
func (db *Database) ModifyAge(name string, age int) {
	// search for the person in the database
	for i, person := range db.People {
		if person.Name == name {
			// person found, update their age
			db.People[i].Age = age
			return
		}
	}

	// person not found
	fmt.Println("Error: Person not found in the database.")
}

func main() {
	// create a new database
	db := &Database{}

	// add some people to the database
	db.AddPerson("Joshua", 25, "San Fransisco")
	db.AddPerson("Alex", 30, "Los Angeles")
	db.AddPerson("Charlie", 35, "Alexandretta")
	db.AddPerson("Alexander", 14, "Hannover")

	// modify Alex's age
	db.ModifyAge("Alex", 32)

	// remove Charlie from the database
	//db.RemovePerson("Charlie")

	// print the contents of the database
	for _, person := range db.People {
		fmt.Printf("%s: %d %s\n", person.Name, person.Age, person.Adress)

	}
}
