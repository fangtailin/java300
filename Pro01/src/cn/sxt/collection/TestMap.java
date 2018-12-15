package cn.sxt.collection;

import java.util.HashMap;
import java.util.Map;

/***
 * 测试Map的基本用法
 * HashMap: 效率高，线程不安全
 * HashTable: 效率低，线程安全
 * @author Administrator
 *
 */
public class TestMap {

	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("ZS", new Wife("张曼玉"));
		map.put("GQ", new Wife("杨幂"));
		
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
