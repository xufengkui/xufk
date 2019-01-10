package maobohe;

public class ProxyTest implements TargetInterface {

	private TargetInterface target;

	private ProxyTest() {
		target = new TargetImpl();
	}

	@Override
	public void sell() {
		System.out.println("代理类");
		target.sell();
	}

	public static void main(String[] args) {
		TargetInterface t = new ProxyTest();
		t.sell();
	}

}
