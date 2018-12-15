package cn.sxt.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * this is a cat and that is a mice and where is the food 统计每个单词出现的次数
 * 统计每个单词出现的次数
 * 
 * 存储到Map中 key：String --因为Integer是final不方法更改，所以用String value： 自定义类型
 * 
 * "分拣"思路： 
 * 思路1：为所有的key创建容器 
 * 		之后容器中存放对应的value 
 * 思路2：第一次创建容器，并存放值value 
 * 		第二次之后，直接使用容器存放值
 * 
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		// test1();
		//test2();
		test22();
	}

	public static void test22() { //test2 优化升级
		String str = "this is a cat and that is a mice and where is the food";
		// 字符分割
		String[] strArray = str.split(" ");
		// 存储到Map中
		Map<String, Letter> letters = new HashMap<String, Letter>();

		Letter col = null;
		for (String temp : strArray) {
			// 1：为所有的key创建容器
			if ((col=letters.get(temp)) ==null) {
				// letters.put(temp, new Letter());
				col = new Letter();
				col.setCount(1);
				letters.put(temp, col);
			} else {
				// 2. 之后容器中存放对应的value
				//col = letters.get(temp); // 直接使用容器
				col.setCount(col.getCount() + 1);
			}
		}

		// 输出Map的值
		Set<String> keys = letters.keySet();
		for (String temp : keys) {
			Letter col2 = letters.get(temp);
			System.out.println("字母" + temp + "次数" + col2.getCount());
		}
	}
	public static void test2() {
		String str = "this is a cat and that is a mice and where is the food";
		// 字符分割
		String[] strArray = str.split(" ");
		// 存储到Map中
		Map<String, Letter> letters = new HashMap<String, Letter>();

		for (String temp : strArray) {
			// 1：为所有的key创建容器
			if (!letters.containsKey(temp)) {
				// letters.put(temp, new Letter());
				Letter col = new Letter();
				col.setCount(1);
				letters.put(temp, col);
			} else {
				// 2. 之后容器中存放对应的value
				Letter col = letters.get(temp); // 直接使用容器
				col.setCount(col.getCount() + 1);
			}
		}

		// 输出Map的值
		Set<String> keys = letters.keySet();
		for (String temp : keys) {
			Letter col = letters.get(temp);
			System.out.println("字母" + temp + "次数" + col.getCount());
		}
	}

	public static void test1() {
		String str = "this is a cat and that is a mice and where is the food";
		// 字符分割
		String[] strArray = str.split(" ");
		// 存储到Map中
		Map<String, Letter> letters = new HashMap<String, Letter>();

		/*
		 * // 1：为所有的key创建容器 // 之后容器中存放对应的value // for (String temp : strArray) { if
		 * (!letters.containsKey(temp)) { letters.put(temp, new Letter()); } }
		 * 
		 * for (String temp : strArray) { // // 容器中存放对应的value // Letter col =
		 * letters.get(temp); // 直接使用容器 col.setCount(col.getCount() + 1); }
		 */

		// 合并
		for (String temp : strArray) {
			// 1：为所有的key创建容器
			if (!letters.containsKey(temp)) {
				letters.put(temp, new Letter());
			}
			// 2. 之后容器中存放对应的value
			Letter col = letters.get(temp); // 直接使用容器
			col.setCount(col.getCount() + 1);
		}

		// 输出Map的值
		Set<String> keys = letters.keySet();
		for (String temp : keys) {
			Letter col = letters.get(temp);
			System.out.println("字母" + temp + "次数" + col.getCount());
		}

	}
}
