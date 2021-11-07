public class Main {

  private volatile Integer count = 3;
  private volatile Integer nextThread = 1;
  private final Object object = new Object();

  public static void main(String[] args) {

    Main threadHolder = new Main();
    Thread threadOne = new Thread(threadHolder.new ThreadPrinter(1));
    Thread threadTwo = new Thread(threadHolder.new ThreadPrinter(2));
    Thread threadThree = new Thread(threadHolder.new ThreadPrinter(3));

    threadOne.start();
    threadTwo.start();
    threadThree.start();
  }


  class ThreadPrinter implements Runnable {

    private final int threadIdentifier;

    public ThreadPrinter(int threadIdentifier) {
      super();
      this.threadIdentifier = threadIdentifier;
    }

    @Override
    public void run() {
      try {
        while (count <= 17) {
          synchronized (object) {
            if (threadIdentifier != nextThread) {
              object.wait();
            } else {
              System.out.print("Thread " + threadIdentifier + " -- iteration " + count / 3 + "\n");
              count++;
              // nextThread = (threadIdentifier + 1) % 3;

              switch (threadIdentifier) {
                case 1 -> nextThread = 2;
                case 2 -> nextThread = 3;
                case 3 -> nextThread = 1;
              }
              object.notifyAll();
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}

