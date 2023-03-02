package test;

/**
 * 当线程执行wait()时，会把当前的锁释放，然后让出CPU，进入等待状态。
 * <p>
 * 当执行notify/notifyAll方法时，会唤醒一个处于等待该 对象锁 的线程，然后继续往下执行，直到执行完退出对象锁锁住的区域（synchronized修饰的代码块）后再释放锁。
 */
public class ThreadTest {

    private final Object flag = new Object();

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadA threadA = threadTest.new ThreadA();
        threadA.start();
        ThreadB threadB = threadTest.new ThreadB();
        threadB.start();
    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 1; i <= 100; i += 2) {
                    flag.notify();
                    System.out.println(i); // 奇数
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 2; i <= 100; i += 2) {
                    flag.notify();
                    System.out.println(i); // 偶数
                    if (i == 100) {
                        // 当输出了最后一个数字的时候，不能再wait了
                        break;
                    }
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
