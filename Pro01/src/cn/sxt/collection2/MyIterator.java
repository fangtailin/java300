package cn.sxt.collection2;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * �򻯰�ĵ����� hasNext next remove--���뷽����ʵ�ֽӿ�
 * 
 * @author Administrator
 *
 */
public class MyIterator implements java.lang.Iterable<String> {

	private String[] elem = { "a", "b", "c", "d", "e" };

	private int size = elem.length;

	// ���������
	private class MyIt implements Iterator<String> {
		private int cursor = -1;

		/*
		 * �ж��Ƿ���next
		 */
		public boolean hasNext() {
			if (cursor > size - 1) {
				return false;
			}
			return cursor + 1 < size;
		}

		/**
		 * ��ȡnext
		 * 
		 * @return
		 */
		public String next() {
			cursor++;// �α��ƶ�һ��
			return elem[cursor];
		}

		/*
		 * remove
		 */
		public void remove() {
			// ���������Ƴ���copy���ξ���
		}
	}

	public Iterator<String> iterator() {
		return new MyIt(); // ֻ����һ�Σ����ǿ��Ի��������ڲ���
	}

	/**
	 * �����ڲ�������
	 * 
	 * @param args
	 */
	public Iterator<String> iterator2() {
		return new Iterator<String>() {
			private int cursor = -1;

			/*
			 * �ж��Ƿ���next
			 */
			public boolean hasNext() {
				if (cursor > size - 1) {
					return false;
				}
				return cursor + 1 < size;
			}

			/**
			 * ��ȡnext
			 * 
			 * @return
			 */
			public String next() {
				cursor++;// �α��ƶ�һ��
				return elem[cursor];
			}

			/*
			 * remove
			 */
			public void remove() {
				// ���������Ƴ���copy���ξ���
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
			// it2.remove();// ����û��ʵ��
			;
		}

		System.out.println("��ǿfor������ʵ��java.lang.Iterable�ӿڣ���дIterator����");
		for (String temp : list) {
			// Can only iterate over an array or an instance of java.lang.Iterable
			// ��MyIteratorʵ��Iterable�ӿڽ��
			System.out.println(temp);
		}
	}

}
