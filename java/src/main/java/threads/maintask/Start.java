package threads.maintask;

import java.util.concurrent.Semaphore;

public class Start {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(2);
    for (int i = 0; i < 10; i++)
      new Train(semaphore, i).start();
  }
}
