package maobohe;

public abstract class Test02 {
	public abstract void run();
	public String aa = "11";
	public void say() {
		System.out.println("good bye");
	}
	public Test02() {
		System.out.println("构造方法");
	}
	class Test03 extends Test02{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		Test02 t = new Test02() {

			@Override
			public void run() {
				System.out.println("run");
				
			}
		
		};
		t.run();
		t.say();
		
	}
}
