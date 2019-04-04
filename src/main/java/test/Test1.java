package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class Test1 {

  public static void main(String[] args) throws InterruptedException {

      SynchronizedTest o1 = new SynchronizedTest("01");
      Thread t1 = new Thread(){
          @Override
          public void run() {
              o1.synchMethod();
          }
      };
      Thread t2 = new Thread(){
          @Override
          public void run() {
              SynchronizedTest.staticSynchMethod();
          }
      };
      Thread t3 = new Thread(){
          @Override
          public void run() {
              SynchronizedTest.staticSynchMethod();
          }
      };

      t1.start();
      t2.start();
      t3.start();
      t1.join();
      t2.join();
      t3.join();

      List<Double> list = new ArrayList<>();
      Double avg = list.stream().mapToDouble(value -> value).average().orElse(Double.NaN);
  }
}

class SynchronizedTest{
    private String name;


    public SynchronizedTest(String name) {
        this.name = name;
    }

    public static synchronized void staticSynchMethod(){
        System.out.println("SM1");
        System.out.println("SM2");
    }

    public synchronized void synchMethod(){
        System.out.println(name + "M1");
        System.out.println(name + "M2");
    }

}


