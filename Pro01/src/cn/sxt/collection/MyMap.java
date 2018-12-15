package cn.sxt.collection;

/***
 * �Զ���ʵ��Map�Ĺ���
 * 
 * Map����ż�ֵ�ԣ����ݼ������Ҷ�Ӧ��ֵ���󡣼������ظ�
 * 
 * @author Administrator
 *
 */
public class MyMap {

	MyEntry[] arr = new MyEntry[999];
	int size;

	public void put(Object key, Object value) {
		MyEntry e = new MyEntry(key, value);
		
		//�ж��Ƿ���Key �ظ��� �����ֵ�ظ��Ĵ�������ļ�ֱ�Ӹ���
		for (int i = 0; i < size; i++) {
			if (arr[i].key.equals(key)) {
				arr[i].value=value;
				return;
			}
		}
		
		arr[size++] = e;
	}

	public Object get(Object key) {
		for (int i = 0; i < size; i++) {
			if (arr[i].key.equals(key)) {
				return arr[i].value;
			}
		}
		return null;
	}

	public boolean containsKey(Object key) {
		// range check
		for (int i = 0; i < size; i++) {
			if (arr[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsValue(Object value) {
		
		for (int i = 0; i < size; i++) {
			if (arr[i].value.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MyMap map = new MyMap();
		map.put("LS", new Wife("����"));
		map.put("WW", new Wife("С��"));
		map.put("WW", new Wife("С��2"));

		Wife w = (Wife) map.get("WW");
		System.out.println(w.name);
		System.out.println(map.size);
		System.out.println(map.containsKey("WW"));
		System.out.println(map.containsKey("www"));
		System.out.println(map.containsValue(w));

	}
}

class MyEntry {
	Object key;
	Object value;

	public MyEntry() {

	}

	public MyEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

}
