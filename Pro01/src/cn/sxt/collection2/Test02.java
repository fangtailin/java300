package cn.sxt.collection2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 用Map封装数据
 * 一个Map对象对应一行记录。 不需要单独也一个类。不需要javabean
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//一个Map对象对应一行记录
		Map map = new HashMap();
		map.put("id", 0301);
		map.put("name", "Smile");
		map.put("salaray", 3000);
		map.put("department", "Project dep");
		map.put("hireDate", "2006-10");

		Map map2 = new HashMap();
		map2.put("id", 0302);
		map2.put("name", "Smile2");
		map2.put("salaray", 3100);
		map2.put("department", "Project dep2");
		map2.put("hireDate", "2016-10");

		Map map3 = new HashMap();
		map3.put("id", 0303);
		map3.put("name", "Smile3");
		map3.put("salaray", 3200);
		map3.put("department", "Project dep3");
		map3.put("hireDate", "2003-10");

		List<Map> list = new ArrayList<Map>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		
		printEmpName(list);
	}
	
	public static void printEmpName(List<Map> list) {
		for (int i = 0; i < list.size(); i++) {	
			//Map tempMap=list.get(i);
			System.out.println(list.get(i).get("name")+"--"+list.get(i).get("salaray"));
		}
	}
	
}
