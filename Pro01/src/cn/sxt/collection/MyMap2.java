package cn.sxt.collection;

import java.util.LinkedList;

/***
 * 自定义Map升级版 1. 提高查询的效率 --> Map 的底层实现：数组+链表 (数组里面存放链表) 2. HashCode 和 Equals
 * 如果equals为true，则HashCode 相等。 反之则不然
 * 
 * @author Administrator
 *
 */
public class MyMap2 {

	// MyEntry[] arr = new MyEntry[999];

	// Map 的底层实现：数组+链表 (数组里面存放链表)
	LinkedList[] arr = new LinkedList[999]; // MyLinkedLisk
	int size;

	public void put(Object key, Object value) {
		MyEntry e = new MyEntry(key, value);

		// int a = key.hashCode() % arr.length;
		// HashCode可能是负值
		int hash = key.hashCode();
		hash = hash < 0 ? -hash : hash;

		int a = hash % arr.length;

		if (arr[a] == null) {
			LinkedList   list = new LinkedList();
			arr[a] = list;
			list.add(e);
		} else {

			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				MyEntry e2 = (MyEntry) list.get(i);
				if (e2.key.equals(key)) {
					e2.value = value; // 键值重复直接覆盖
					return;
				}
			}

			arr[a].add(e);
		}
	}

	public Object get(Object key) {
		// return arr[key.hashCode() % arr.length];
		int a = key.hashCode() % arr.length;
		if (arr[a] != null) {
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				MyEntry e = (MyEntry) list.get(i);
				if (e.key.equals(key)) {
					return e.value;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		MyMap2 map = new MyMap2();
		map.put("LS", new Wife("杨幂"));
		map.put("WW", new Wife("小骨"));
		map.put("WW", new Wife("小骨2"));

		Wife w = (Wife) map.get("WW");
		System.out.println(w.name);
		System.out.println(map.size);

	}
}

/**
 * HashCode 和 Equals 如果equals为true，则HashCode 相等。 反之则不然
 * 
 * @author Administrator
 *
 */
class Student {

	private int id;
	private String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
