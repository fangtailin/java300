package cn.sxt.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * this is a cat and that is a mice and where is the food ͳ��ÿ�����ʳ��ֵĴ���
 * ͳ��ÿ�����ʳ��ֵĴ���
 * 
 * �洢��Map�� key��String --��ΪInteger��final���������ģ�������String value�� �Զ�������
 * 
 * "�ּ�"˼·�� 
 * ˼·1��Ϊ���е�key�������� 
 * 		֮�������д�Ŷ�Ӧ��value 
 * ˼·2����һ�δ��������������ֵvalue 
 * 		�ڶ���֮��ֱ��ʹ���������ֵ
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

	public static void test22() { //test2 �Ż�����
		String str = "this is a cat and that is a mice and where is the food";
		// �ַ��ָ�
		String[] strArray = str.split(" ");
		// �洢��Map��
		Map<String, Letter> letters = new HashMap<String, Letter>();

		Letter col = null;
		for (String temp : strArray) {
			// 1��Ϊ���е�key��������
			if ((col=letters.get(temp)) ==null) {
				// letters.put(temp, new Letter());
				col = new Letter();
				col.setCount(1);
				letters.put(temp, col);
			} else {
				// 2. ֮�������д�Ŷ�Ӧ��value
				//col = letters.get(temp); // ֱ��ʹ������
				col.setCount(col.getCount() + 1);
			}
		}

		// ���Map��ֵ
		Set<String> keys = letters.keySet();
		for (String temp : keys) {
			Letter col2 = letters.get(temp);
			System.out.println("��ĸ" + temp + "����" + col2.getCount());
		}
	}
	public static void test2() {
		String str = "this is a cat and that is a mice and where is the food";
		// �ַ��ָ�
		String[] strArray = str.split(" ");
		// �洢��Map��
		Map<String, Letter> letters = new HashMap<String, Letter>();

		for (String temp : strArray) {
			// 1��Ϊ���е�key��������
			if (!letters.containsKey(temp)) {
				// letters.put(temp, new Letter());
				Letter col = new Letter();
				col.setCount(1);
				letters.put(temp, col);
			} else {
				// 2. ֮�������д�Ŷ�Ӧ��value
				Letter col = letters.get(temp); // ֱ��ʹ������
				col.setCount(col.getCount() + 1);
			}
		}

		// ���Map��ֵ
		Set<String> keys = letters.keySet();
		for (String temp : keys) {
			Letter col = letters.get(temp);
			System.out.println("��ĸ" + temp + "����" + col.getCount());
		}
	}

	public static void test1() {
		String str = "this is a cat and that is a mice and where is the food";
		// �ַ��ָ�
		String[] strArray = str.split(" ");
		// �洢��Map��
		Map<String, Letter> letters = new HashMap<String, Letter>();

		/*
		 * // 1��Ϊ���е�key�������� // ֮�������д�Ŷ�Ӧ��value // for (String temp : strArray) { if
		 * (!letters.containsKey(temp)) { letters.put(temp, new Letter()); } }
		 * 
		 * for (String temp : strArray) { // // �����д�Ŷ�Ӧ��value // Letter col =
		 * letters.get(temp); // ֱ��ʹ������ col.setCount(col.getCount() + 1); }
		 */

		// �ϲ�
		for (String temp : strArray) {
			// 1��Ϊ���е�key��������
			if (!letters.containsKey(temp)) {
				letters.put(temp, new Letter());
			}
			// 2. ֮�������д�Ŷ�Ӧ��value
			Letter col = letters.get(temp); // ֱ��ʹ������
			col.setCount(col.getCount() + 1);
		}

		// ���Map��ֵ
		Set<String> keys = letters.keySet();
		for (String temp : keys) {
			Letter col = letters.get(temp);
			System.out.println("��ĸ" + temp + "����" + col.getCount());
		}

	}
}
