package maobohe;

public class AbstrctTestImpl extends AbstractTest {

	public AbstrctTestImpl() {
		super.add();
		System.out.println(super.a);
	}

	public String a = "我是子类变量";

	public void add() {
		System.out.println("我是子类方法");
	}

	public static void main(String[] args) {
		AbstrctTestImpl aa = new AbstrctTestImpl();
		System.out.println(aa.a);
		aa.add();
	}

}
