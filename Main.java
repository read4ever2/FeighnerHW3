import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    Thread[] threadArray = new Thread[3];
    threadArray[0]= new Thread(new LoopPrinter(1));
    threadArray[1]= new Thread(new LoopPrinter(2));
    threadArray[2]= new Thread(new LoopPrinter(3));

    for (Thread thread : threadArray) {
      thread.start();
      try {
        Thread.sleep(25);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class LoopPrinter implements Runnable {

  private final int identifier;

  LoopPrinter(int identifier) {
    this.identifier = identifier;
  }

  @Override
  public void run() {
    for (int i = 1; i < 6; i++) {
      System.out.print("Thread " + identifier + " -- iteration " + i + "\n");
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}