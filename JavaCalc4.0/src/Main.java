import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter A Number");
        int x = scanner.nextInt();
        System.out.println("Please Enter A Number");
        int y = scanner.nextInt();
        System.out.println("Please Enter A Number for the operation. + - * / are for four main equations and rest of them what if these numbers switched places. 99 to enter advenced mode");
        String z = scanner.next();


        switch (z) {
            case "+":
                System.out.println(x + y);
                break;
            case "-":
                System.out.println(x - y);
                break;
            case "*":
                System.out.println(x * y);
                break;
            case "/":
                System.out.println(x / y);
                break;
            case "+!":
                System.out.println(y + x);
                break;
            case "-!":
                System.out.println(y - x);
                break;
            case "*!":
                System.out.println(y * x);
                break;
            case "/!":
                System.out.println(y / x);
                break;
            case "AD":
                System.out.println("1 to enter square mode. 2 to enter rectangle mode 3 to enter triangle mode ");
                int allmode = scanner.nextInt();
                switch (allmode) {
                    case 1:
                        System.out.println("1 to calculate the area of a square 2 to calculate the perimeter of a square");
                        int sqmode = scanner.nextInt();
                        switch (sqmode) {
                            case 1:
                                System.out.println("Please Enter how long one side of the square");
                                int sq = scanner.nextInt();
                                if (sq < 1) {
                                    System.out.println("Error. Side cannot be smaller than 0");
                                } else {
                                    System.out.println(sq * sq);
                                }
                                break;
                            case 2:
                                System.out.println("1 to calculate the area of a square. 2 to calculate the perimeter of Square");
                                int sqa = scanner.nextInt();
                                if (sqa < 1) {
                                    System.out.println("Error. Side cannot be smaller than 0");
                                } else {
                                    System.out.println(sqa + sqa + sqa + sqa);
                                }
                                break;
                            default:
                                System.out.println("Unknown");
                                break;

                        }
                    case 2:
                        System.out.println("1 to calculate the area of a rectangle 2 to calculate the perimeter of a rectangle");
                        int recmode = scanner.nextInt();
                        switch (recmode) {
                            case 1:
                                System.out.println("Please enter how long is the long is the long side of the rectangle");
                                int reclong = scanner.nextInt();
                                System.out.println("Please enter how long is the long is the long side of the rectangle");
                                int recshort = scanner.nextInt();

                                if (reclong < 1 || recshort < 1) {
                                    System.out.println("One of the sides cannot be smaller than 1");
                                } else {
                                    System.out.println(reclong * recshort);
                                }
                                break;
                            case 2:
                                System.out.println("Please enter how long is the long is the long side of the rectangle");
                                int reclonga = scanner.nextInt();
                                System.out.println("Please enter how long is the long is the long side of the rectangle");
                                int recshorta = scanner.nextInt();

                                if (reclonga < 1 || recshorta < 1){
                                    System.out.println("One of the sides cannot be smaller than 1");
                                } else {
                                    System.out.println(reclonga + reclonga + recshorta + recshorta);
                                }
                                break;
                            default:
                                System.out.println("Unknown");
                                break;
                        }
                    case 3:
                        System.out.println("1 to calculate the area of a triangle 2 to calculate the perimeter of a rectangle");
                        int trimode = scanner.nextInt();
                        switch (trimode){
                            case 1:
                                System.out.println("Please enter how long is the base of the triangle");
                                int tribase = scanner.nextInt();
                                System.out.println("Please enter how long is the base of the triangle");
                                int triheight = scanner.nextInt();

                                int triareay;
                                int triareax;

                                if (tribase < 1 || triheight < 1){
                                    System.out.println("Any of them cannot be smaller than 1");
                                } else {
                                    triareay = tribase * triheight;
                                    triareax = triareay / 2;
                                    System.out.println(triareax);
                                }
                                break;
                            case 2:
                                System.out.println("Please Enter how long is the first side of the triangle");
                                int tria = scanner.nextInt();
                                System.out.println("Please Enter how long is the first side of the triangle");
                                int trib = scanner.nextInt();
                                System.out.println("Please Enter how long is the first side of the triangle");
                                int tric = scanner.nextInt();

                                if (tria < 1 || trib < 1 || tric < 0){
                                    System.out.println("Error they cannot be smaller than 1");
                                } else {
                                    System.out.println(tria + trib + tric);
                                }
                                break;
                            default:
                                System.out.println("Unknown");
                                break;
                        }
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
        }
    }
}
