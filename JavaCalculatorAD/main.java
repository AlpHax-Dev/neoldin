import java.util.*;

// Compiler version JDK 19.0.2

class main
{
    public static void main(String args[])
    {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter A Number");
        int y = scanner.nextInt();
        System.out.println("Please Enter A Number");
        int z = scanner.nextInt();
        System.out.println("Please Enter A Number for the operation. + - * / are for four main equations and rest of them what if these numbers switched places. 99 to enter advenced mode");
        String x = scanner.next();

        int sum = y + z;
        int equ = y - z;
        int mul = y * z;
        int div = y / z;
        int rsum = z + y;
        int requ = z - y;
        int rmul = z * y;
        int rdiv = z / y;

        int sqcontrol = 0;
        int sq = 0;
        int recmode = 0;
        int trimode = 0;


        switch (x) {
            case "+":
                System.out.println(sum);
                break;
            case "-":
                System.out.println(equ);
                break;
            case "*":
                System.out.println(mul);
                break;
            case "/":
                System.out.println(div);
                break;
            case "+!":
                System.out.println(rsum);
                break;
            case "-!":
                System.out.println(requ);
                break;
            case "*!":
                System.out.println(rmul);
                break;
            case "/!":
                System.out.println(rdiv);
                break;
            case "AD":
                System.out.println("1 To calculate the area of a square. 2 to calculate the perimeter of a square. 3 to enter rectangle mode. 4 to to enter triangle mode");
                sqcontrol = scanner.nextInt();
            default:
                System.out.println("Unknown");
                break;
        }

        switch (sqcontrol) {
            case 1:
                System.out.println("Please Enter How Long a side of the Square");
                sq = scanner.nextInt();
                int sqarea = sq * sq;
                System.out.println(sqarea);
                break;
            case 2:
                System.out.println("Please Enter How Long a side of the Square");
                sq = scanner.nextInt();
                int sqperi = sq * 4;
                System.out.println(sqperi);
                break;
            case 3:
                System.out.println("You entered Rectangle Mode. 1 Calculate the area of a rectangle. 2 to calculate the perimeter of rectangle");
                recmode = scanner.nextInt();
                break;
            case 4:
                System.out.println("You entered triangle mode. 1 to calculate the area of a triangle. 2 to calculate the perimeter of a triangle");
                trimode = scanner.nextInt();
                break;
            default:
                System.out.println("Unknown Mode");
                break;
        }

        switch (recmode) {
            case 1:
                System.out.println("Please enter how long the short side of the rectangle");
                int vb = scanner.nextInt();
                System.out.println("Please enter how long the short side of the rectangle");
                int bv = scanner.nextInt();

                int recarea = vb * bv;
                System.out.println(recarea);
                break;
            case 2:
                System.out.println("Please enter how long the short side of the rectangle");
                int ty = scanner.nextInt();
                System.out.println("Please enter how long the short side of the rectangle");
                int yt = scanner.nextInt();

                int recperi = ty + ty + yt + yt;
                System.out.println(recperi);
                break;
            default:
                System.out.println("Unknown Mode");
                break;
        }

        switch (trimode) {
            case 1:
                System.out.println("Please Enter how long is the height of the triangle");
                int triheight = scanner.nextInt();
                System.out.println("Please Enter how long is the base of the triangle");
                int tribase = scanner.nextInt();

                int triareax = tribase * triheight;
                int triareay = triareax / 2;

                System.out.println(triareay);
                break;
            case 2:
                System.out.println("Please Enter how long the first side of the triangle");
                int tria = scanner.nextInt();
                System.out.println("Please Enter how long the second side of the triangle");
                int trib = scanner.nextInt();
                System.out.println("Please Enter how long the third side of the triangle");
                int tric = scanner.nextInt();

                int triall = tria + trib + tric;
                System.out.println(triall);
                break;
            default:
                System.out.println("Unknown mode");
                break;
        }
    }
}
