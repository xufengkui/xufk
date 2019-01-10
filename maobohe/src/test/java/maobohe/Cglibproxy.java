package maobohe;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Cglibproxy implements MethodInterceptor {

	private TargetImpl target;

	private Cglibproxy() {
		target = new TargetImpl();
	}

	private Cglibproxy(Object obj) {
		target = (TargetImpl) obj;
	}

	public Object getInstance() {
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		return en.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("我是动态代理CGLIB");
		Object object = method.invoke(target, args);
		return object;
	}

	public static void main(String[] args) {
		Cglibproxy cglib = new Cglibproxy();
		TargetImpl proxy = (TargetImpl) cglib.getInstance();
		proxy.sell();
	}
}
