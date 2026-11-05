class ShapeCalculator {

    public void area(int radius) {
        System.out.println("Area of Circle : " + (int) 3.14 * (radius * radius));
    }

    public void area(int length, int width) {
        System.out.println("Area of Circle : " + length * width);
    }

    public void area(int base1, int base2, int height) {
        System.out.println("Area of Circle : " + (int) ((base1 + base2) * height) / 2);
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        ShapeCalculator calc = new ShapeCalculator();
        calc.area(2);
        calc.area(2, 3, 2);
        calc.area(2, 3);
    }
}

/*
 * Design a class ShapeCalculator that calculates the area of different shapes
 * using method overloading. Implement the below attributes and methods to
 * calculate the area of different shapes :
 * 
 * Methods :
 * 
 * area (integer radius) : Calculates and print the area of circle using the
 * formula π×radius2 .
 * area (integer length, integer width) : Calculates and print the area of
 * rectangle using the formula (length * width).
 * area (integer base1, integer base2, integer height) : Calculates and print
 * the area of Trapezoid using the formula ( (base1 + base2) * height) / 2.
 * Refer the sample examples for understanding the output format.
 * 
 * Refer the commented code for the output statements.
 * 
 * Consider π = 3.14
 * 
 * Note : Print the Area in integer format. Round down to nearest integer i.e.
 * 3.9 should b 3, 2.1 should be 2.
 * 
 * Example 1:
 * Input : base1 = 2 , base2 = 3, height = 2, length = 2, radius = 2 , width = 3
 * 
 * Output :
 * 
 * Area of Circle : 12
 * 
 * Area of Rectangle : 6
 * 
 * Area of Trapezoid : 5
 * 
 * Explanation :
 * 
 * We create the object of the class ShapeCalculator.
 * Calls the area method with radius as argument. It calculates and prints the
 * area of circle.
 * Calls the area method with length and width as arguments. It calculates and
 * prints the area of rectangle.
 * Calls the area method with base1, base2, height as arguments. It calculates
 * and prints the area of trapezoid.
 */