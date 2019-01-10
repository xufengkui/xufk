package maobohe;

import java.util.Random;

public class StringTest {
	
	public static void main(String[] args) {
		/*String aa = "kabc1525fkjhfjka";
		String b = "bc";
		System.out.println(aa.regionMatches(2, b, 0, 2));
		System.out.println(aa.charAt(2));
		System.out.println(aa.codePointAt(2));
		System.out.println(aa.codePointBefore(2));
		System.out.println(aa.codePointCount(0, 4));
		System.out.println(aa.getBytes());*/
		Random random = new Random();
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(99999));
	}
}
