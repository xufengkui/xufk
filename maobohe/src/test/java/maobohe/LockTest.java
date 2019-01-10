package maobohe;

import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {

	String aa = "默认值";

	public synchronized void setA() throws Exception {
		Thread.sleep(1000);
		System.out.println("AAAAAA");
		setB();
	}

	public synchronized void setB() throws Exception {
		Thread.sleep(1000);
		System.out.println("BBBBBBB");
	}

	ReentrantReadWriteLock r = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		LockTest ll = new LockTest();
		new Thread() {
			public void run() {
				ll.read();
			}
		}.start();

		new Thread() {
			public void run() {
				ll.add();
			}
		}.start();
	}

	public void add() {
		// 写操作
		r.writeLock().lock();
		try {
			// aa = "我是写锁";
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 2) {
				System.out.println(Thread.currentThread().getName() + ":" + aa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			r.writeLock().unlock();
		}
	}

	public void read() {
		// 写操作
		r.readLock().lock();
		try {

			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 2) {
				System.out.println(Thread.currentThread().getName() + ":" + aa);
			}
			aa = "我是读锁";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			r.readLock().unlock();
		}
	}
}
