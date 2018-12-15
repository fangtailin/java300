package cn.sxt.collection;

/***
 * 自定义实现Map的功能
 * 
 * Map：存放键值对，根据键对象找对应的值对象。键不能重复
 * 
 * @author Administrator
 *
 */
public class MyMap {

	MyEntry[] arr = new MyEntry[999];
	int size;

	public void put(Object key, Object value) {
		MyEntry e = new MyEntry(key, value);
		
		//判断是否有Key 重复， 解决键值重复的处理，后面的键直接覆盖
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
		map.put("LS", new Wife("杨幂"));
		map.put("WW", new Wife("小骨"));
		map.put("WW", new Wife("小骨2"));

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
