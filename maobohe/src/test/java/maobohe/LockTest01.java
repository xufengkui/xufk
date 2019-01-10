package maobohe;

public class LockTest01 implements Runnable {

	public synchronized void get() {
		System.out.println("2 get thread name-->" + Thread.currentThread().getName());
		set();
		System.out.println("4 leave run thread name-->" + Thread.currentThread().getName());
	}

	public synchronized void set() {
		System.out.println("3 set thread name-->" + Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println("1 run thread name-->" + Thread.currentThread().getName());
		get();
	}

	public static void main(String[] args) {
		LockTest01 test = new LockTest01();
		for (int i = 0; i < 5; i++) {
			new Thread(test, "thread-" + i).start();
		}
	}
}
