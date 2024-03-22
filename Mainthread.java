public class Mainthread {
public static void main(String[] args) {
Thread oddThread = new OddThread();
Thread evenThread = new EvenThread();
oddThread.start();
evenThread.start();
try {
oddThread.join();
evenThread.join();
} catch (InterruptedException e) {
e.printStackTrace();

}
System.out.println( "All threads have finished executing. ");
}
}
class OddThread extends Thread {
public void run() {
System.out.println( "Odd numbers between 1 and 100: ");
for (int i = 1; i <= 100; i += 2) {
System.out.print(i +  "  ");
}
System.out.println();
}
}
class EvenThread extends Thread {
public void run() {
System.out.println( "Even numbers between 1 and 100: ");
for (int i = 2; i <= 100; i += 2) {
System.out.print(i +  "  ");
}
System.out.println();
}
}