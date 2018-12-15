package cn.sxt.collection;

import java.util.HashMap;

/***
 * 
 * @author Administrator
 *
 */
public class MyHashSet {

	HashMap map;
	private static final Object PRESENT = new Object();


	public int size() {
		return map.size();
	}

	public MyHashSet() {
		map = new HashMap();
	}

	public void add(Object obj) {
		map.put(obj, PRESENT); // set的不可重复性就是利用了map里面键对象的不可重复！
	}

	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add("aaa");
		set.add(3243);
		set.add(new String("aaa"));

		System.out.println(set.size());

	}
}
