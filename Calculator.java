public class Calculator
{
 public int add(int a,int b)
 {
int c=a+b;
return c;
 }
 public int square(int x)
 {
int z=x*x;
 }
public static void main(String args[])
{
Calculator cal = new Calculator();
System.out.println("The sum of two numbers is "+(cal.add(2,3)));
System.out.println("The Square of the number is "+(cal.square41));
}
}
