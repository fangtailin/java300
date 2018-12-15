package cn.sxt.collection;

import java.util.LinkedList;

/***
 * �Զ���Map������ 1. ��߲�ѯ��Ч�� --> Map �ĵײ�ʵ�֣�����+���� (��������������) 2. HashCode �� Equals
 * ���equalsΪtrue����HashCode ��ȡ� ��֮��Ȼ
 * 
 * @author Administrator
 *
 */
public class MyMap2 {

	// MyEntry[] arr = new MyEntry[999];

	// Map �ĵײ�ʵ�֣�����+���� (��������������)
	LinkedList[] arr = new LinkedList[999]; // MyLinkedLisk
	int size;

	public void put(Object key, Object value) {
		MyEntry e = new MyEntry(key, value);

		// int a = key.hashCode() % arr.length;
		// HashCode�����Ǹ�ֵ
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
					e2.value = value; // ��ֵ�ظ�ֱ�Ӹ���
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
		map.put("LS", new Wife("����"));
		map.put("WW", new Wife("С��"));
		map.put("WW", new Wife("С��2"));

		Wife w = (Wife) map.get("WW");
		System.out.println(w.name);
		System.out.println(map.size);

	}
}

/**
 * HashCode �� Equals ���equalsΪtrue����HashCode ��ȡ� ��֮��Ȼ
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
