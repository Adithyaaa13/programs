import java.io.*;
class c1
{
public static void disp()
{
System.out.println("in disp c1");
}
}
class c2 
{
public static void disp()
{
System.out.println("in disp c2");
}
}
class stat2
{
public static void disp()
{
System.out.println("in disp");
}
public static void main(String args[])
{
disp();
c1.disp();
c2.disp();
}
}