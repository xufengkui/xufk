package maobohe;

import java.io.IOException;

public class StreamTest {

	public static void main(String[] args) throws IOException {
		/*
		 * File f = new File("xinjian"); FileInputStream fio = new FileInputStream(f);
		 * 
		 * FileInputStream fio1 = new FileInputStream("xinjian");
		 * 
		 * OutputStream os = new FileOutputStream("111");
		 * 
		 * Writer w = new Writer(); Reader r = new Reader();
		 */

		/*
		 * System.out.println(System.getProperty("user.dir")); Charset c =
		 * Charset.forName("ISO-8859-1"); String a = "abcd131"; ByteBuffer b =
		 * c.encode(a); byte[] bb = b.array(); ByteBuffer bbb = ByteBuffer.wrap(bb);
		 * CharBuffer cc = c.decode(bbb); System.out.println(a);
		 * System.out.println(cc.toString());
		 */
		/*
		 * File fi = new File("F:\\TEST\\excel解析.rar"); fi.delete();
		 * System.out.println("删除成功"); FileInputStream fio = new FileInputStream(fi);
		 * ZipInputStream zip = new ZipInputStream(fio); File fo = new
		 * File("F:\\TEST\\copy\\excel解析.rar"); if(!fo.exists()) { fo.mkdirs(); }
		 * FileOutputStream foo = new FileOutputStream(fo); ZipOutputStream zipOut = new
		 * ZipOutputStream(foo); ZipEntry entry; while((entry = zip.getNextEntry()) !=
		 * null) { String fileName = entry.getName(); ZipEntry outEntry = new
		 * ZipEntry(fileName); zipOut.putNextEntry(outEntry); zip.closeEntry();
		 * zipOut.closeEntry(); } zipOut.close();
		 * 
		 * Path ab = Paths.get("F:\\TEST\\excel"); Path cd = ab.resolve(ab);
		 * System.out.println(ab); Path re = cd.resolveSibling("F:\\TEST\\tmp");
		 * System.out.println(re);
		 * 
		 * Path path = Paths.get("F:\\TEST\\excel\\年终考核.doc"); List<String> list =
		 * Files.readAllLines(path, Charset.forName("ISO8859-1")); List l = new
		 * ArrayList(); l.add(null); l.add(null); List ll = new LinkedList();
		 * ll.add(null); ll.add(null);
		 * 
		 * Map mm = new HashMap(); mm.put("1", "2"); System.out.println(mm.hashCode());
		 * Map t = new TreeMap(); mm.put(null, null); System.out.println(t);
		 */
		System.out.println(tableSizeFor(6));

	}

	public static int indexFor(int h, int length) {
		return h & (length - 1);
	}

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
//		n |= n >>> 8;
//		n |= n >>> 16;
		// return (n < 0) ? 1 : (n >= 30) ? 30 : n + 1;
		return n;
	}
}
