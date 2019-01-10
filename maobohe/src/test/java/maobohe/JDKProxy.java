package maobohe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

	private TargetInterface target;

	private JDKProxy() {
		target = new TargetImpl();
	}

	private JDKProxy(Object obj) {
		target = (TargetInterface) obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("动态代理类");
		method.invoke(target, args);
		return null;
	}

	public static void main(String[] args) {
//		JDKProxy proxy = new JDKProxy();
		InvocationHandler h = new JDKProxy();
		TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(TargetInterface.class.getClassLoader(),
				new Class[] { TargetInterface.class }, h);
		proxy.sell();
		proxy.toString();
	}

}
