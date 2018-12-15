package cn.sxt.collection2;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * 简化版的迭代器 hasNext next remove--加入方法，实现接口
 * 
 * @author Administrator
 *
 */
public class MyIterator implements java.lang.Iterable<String> {

	private String[] elem = { "a", "b", "c", "d", "e" };

	private int size = elem.length;

	// 加入迭代器
	private class MyIt implements Iterator<String> {
		private int cursor = -1;

		/*
		 * 判断是否有next
		 */
		public boolean hasNext() {
			if (cursor > size - 1) {
				return false;
			}
			return cursor + 1 < size;
		}

		/**
		 * 获取next
		 * 
		 * @return
		 */
		public String next() {
			cursor++;// 游标移动一次
			return elem[cursor];
		}

		/*
		 * remove
		 */
		public void remove() {
			// 从数组中移除，copy两次就行
		}
	}

	public Iterator<String> iterator() {
		return new MyIt(); // 只用了一次，我们可以换成匿名内部类
	}

	/**
	 * 匿名内部类做法
	 * 
	 * @param args
	 */
	public Iterator<String> iterator2() {
		return new Iterator<String>() {
			private int cursor = -1;

			/*
			 * 判断是否有next
			 */
			public boolean hasNext() {
				if (cursor > size - 1) {
					return false;
				}
				return cursor + 1 < size;
			}

			/**
			 * 获取next
			 * 
			 * @return
			 */
			public String next() {
				cursor++;// 游标移动一次
				return elem[cursor];
			}

			/*
			 * remove
			 */
			public void remove() {
				// 从数组中移除，copy两次就行
			}
		};
	}

	public static void main(String[] args) {
//		MyIterator list = new MyIterator();
//		while (list.hasNext()) {
//			System.out.println(list.next());
//		}

		MyIterator list = new MyIterator();
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			;
		}

		System.out.println("##########");

		Iterator<String> it2 = list.iterator2();
		while (it2.hasNext()) {
			System.out.println(it2.next());
			// it2.remove();// 这里没有实现
			;
		}

		System.out.println("增强for，必须实现java.lang.Iterable接口，重写Iterator方法");
		for (String temp : list) {
			// Can only iterate over an array or an instance of java.lang.Iterable
			// 将MyIterator实现Iterable接口解决
			System.out.println(temp);
		}
	}

}
