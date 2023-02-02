use std::io;
fn main() {
    let mut input1 = String::new();

    println!("Please Enter a number");

    io::stdin()
    .read_line(&mut input1)
    .expect("You Fucked Up");

    let num: i32 = input1.trim().parse().expect("Please Type a number");

    let mut input2 = String::new();

    io::stdin()
    .read_line(&mut input2)
    .expect("You Fucked up");

    let numb: i32 = input2.trim().parse().expect("Please Type a number");

    let mut input3 = String::new();

    io::stdin()
    .read_line(&mut input3)
    .expect("You Fucked up");

    let numf: i32 = input3.trim().parse().expect("Please Type a number");

    let mut sum = numb + numf;
    let mut equ = numb - numf;
    let mut mul = numb * numf;
    let mut div = numb / numf;
    let mut rsum = numf + numb;
    let mut requ = numf - numb;
    let mut rmul = numf* numb;
    let mut rdiv = numf / numb;


    if num == 1 {
        println!("{}", sum);
    } else if num == 2 {
        println!("{}", equ);
    } else if num == 3 {
        println!("{}", mul);
    } else if num == 4 {
        println!("{}", div);
    } else if num == 5 {
        println!("{}", rsum);
    } else if num == 6 {
        println!("{}", requ);
    } else if num == 7 {
        println!("{}", rmul);
    } else if num == 8 {
        println!("{}", rdiv);
    }

}