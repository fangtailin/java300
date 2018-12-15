package cn.sxt.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/***
 * List容器
 * 
 * @author Administrator
 *
 */
public class TestCollection {

	public static void main(String[] args) {
		// Collection c;

		List list = new ArrayList();
		// ArrayList: 底层实现是数组，线程不安全，效率高，所以查询速度快， 插入和删除效率低
		// LindedList： 底层实现是链表，线程不安全，效率低，所以查询速度慢，插入和删除效率高
		// Voctor： （矢量，向量）底层实现也是基于数组，线程安全，效率低

	}
}

