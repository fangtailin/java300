package cn.sxt.collection;

import java.util.HashMap;
import java.util.Map;

/***
 * ����Map�Ļ����÷�
 * HashMap: Ч�ʸߣ��̲߳���ȫ
 * HashTable: Ч�ʵͣ��̰߳�ȫ
 * @author Administrator
 *
 */
public class TestMap {

	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("ZS", new Wife("������"));
		map.put("GQ", new Wife("����"));
		
		Wife w=(Wife) map.get("ZS");
		map.remove("ZS");
		System.out.println(w.name);
		
	}

}

class Wife {
	String name;

	public Wife(String name) {
		this.name = name;
	}
}
