import java.util.Scanner;

public class HelloWorld {
  public static void main(String[] args) {
    Scanner s;
    double weight;
    double height;
    double result;
    s = new Scanner(System.in);
    System.out.println("Welcome, can you enter your Weight?");
    weight = s.nextInt();
    System.out.println("You can enter your Height");
    height = s.nextInt();
    result = ( weight / (height * height)) * 10000;
    System.out.printf("%n Your weight in kilos: " + weight);
    System.out.printf("%n Your height: " + height);
    System.out.printf("%n Your BMI is " + (result) + ".");
    if(weight<=45)    System.out.printf("you are skinny");
    if(weight>45 && weight < 90)    System.out.printf("you are athletic");
    if(weight > 90)    System.out.printf("you are fat");
  }
}