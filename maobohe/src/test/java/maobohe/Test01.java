package maobohe;

import java.util.concurrent.locks.Lock;

public class Test01 {

	public String XXX = "";
	public static String bbb = "静态变量bbb";
	public void ccc() {
		System.out.println("ccc");
	}
	public static void bbb() {
		System.out.println("静态方法："+bbb);
	}
	{
		System.out.println("代码块");
	}
	static {
		System.out.println("静态代码块！");
	}
	public static String aaa = "静态变量aaa";
	public static void aaa() {
		System.out.println(aaa);
	}
	class Test02{
		private void syso() {
			System.out.println("我是内部类");

		}
	}
	public Test01(){
		System.out.println("构造器！");
	}
	public static void main(String[] args) {
		Test01 t = new Test01();
//		t.ccc();
//		bbb();
//		aaa();
		/*String s1 = "aaa";
		String s2 = "aaa";
		String s3 = new String("aaa");
		String s4 = "aa"+"a";
		String s5 = "a";
		String s6 = "aa"+s5;
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println(s1==s4);
		System.out.println(s1.equals(s4));
		System.out.println(s1==s6);
		System.out.println(s1.hashCode());
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s6.hashCode());*/
	}
}
