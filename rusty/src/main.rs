use std::io;
use std::io::Read;

fn main() {
    let mut control = String::new();

    let mut number1 = {
        println!("Enter an integer: ");
        let mut number1_raw = String::new();
        io::stdin().read_line(&mut number1_raw).unwrap();
        match number1_raw.trim().parse::<i32>() {
            Ok(num) => num,
            Err(_) => {
                println!("Invalid input: not an integer");
                return;
            }
        }
    };

    let mut number2= {
        println!("Enter an integer: ");
        let mut number2_raw = String::new();
        io::stdin().read_line(&mut number2_raw).unwrap();
        match number2_raw.trim().parse::<i32>(){
            Ok(num) => num,
            Err(_) => {
                println!("Invalid input");
                return;
            }
        }
    };

    let mut geometry;

    println!("Please enter an operation: ");

    let mut operation_raw = String::new();
    io::stdin().read_line(&mut operation_raw).unwrap();

    let operation = input.trim();

    match operation {
        "+" => {
            println!("{}", number1 + number2);
            io::stdin().read_line(&mut control).unwrap();
        },
        "-" => {
            println!("{}", number1 - number2);
            io::stdin().read_line(&mut control).unwrap();
        },
        "*" => {
            println!("{}", number1 * number2);
            io::stdin().read_line(&mut control).unwrap();
        },
        "/" => {
            if number1 == 0 || number2 == 0 {
                println!("Any of the numbers cannot be zero");
                io::stdin().read_line(&mut control).unwrap();
            } else {
                println!("{}", number1 / number2);
                io::stdin().read_line(&mut control).unwrap();
            }
        },
        "AD" => {
                geometry = {
                println!("Enter an integer: ");
                let mut geometry_raw = String::new();
                io::stdin().read_line(&mut geometry_raw).unwrap();
                match geometry_raw.trim().parse::<i32>(){
                    Ok(num) => num,
                    Err(_) => {
                        println!("Invalid input");
                        return;
                    }
                }
            };
        }
    }
}
