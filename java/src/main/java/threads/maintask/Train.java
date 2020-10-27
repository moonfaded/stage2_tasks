package threads.maintask;

import java.util.concurrent.Semaphore;

class Train extends Thread {
  private Semaphore semaphore;
  private int id;

  Train(Semaphore semaphore, int id) {
    this.semaphore = semaphore;
    this.id = id;
  }

  public void run() {
    try {
      semaphore.acquire();
      System.out.println("Train " + id + " has entered the tunnel");
      sleep(2000);

      System.out.println("Train " + id + " has left the tunnel");
      semaphore.release();

      sleep(1000);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
