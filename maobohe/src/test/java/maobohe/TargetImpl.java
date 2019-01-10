package maobohe;

public class TargetImpl implements TargetInterface {
	@Override
	public void sell() {
		System.out.println("我是目标类！");
	}

	public static void main(String[] args) {
		Class[] a = new Class[] { TargetInterface.class };
		System.out.println(a[0].getName());
	}
}
