package thread;


class First extends Thread {

  private Boolean isFirst;

  public First(Boolean isFirst) {
    super();
    this.isFirst = isFirst;
  }

  @Override
  public void run() {
    try {
      while (!isFirst) {
        wait();
      }
      System.out.println("First");
      isFirst = !isFirst;
      notify();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}


class Second extends Thread {

  private Boolean isFirst;

  public Second(Boolean isFirst) {
    super();
    this.isFirst = isFirst;
  }

  @Override
  public void run() {
    try {
      while (isFirst) {
        wait();
      }
      System.out.println("Second");
      isFirst = !isFirst;
      notify();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}


public class Sequencer {

  public static void main(String[] args) {


    Boolean isFirst = true;

    int count = 100;

    First first = new First(isFirst);
    Second second = new Second(isFirst);

    while (count-- > 0) {

    }

  }
}
