package cn.sxt.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/***
 * Set ����ͨ������ֱ�ӱ���, ������ͨ��Iterator���������б���
 * ��List�ܹ�ͨ������������Ҳ��ͨ��Iterator���������б���
 * Iterator���ù��α�cursor����ѭ��
 * @author Administrator
 *
 */
public class IteratorTest {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("Gao1");
		list.add("Gao2");
		list.add("Gao3");

		//ͨ����������List
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//ͨ��������Iterator����List
		for(Iterator iter2=list.iterator();iter2.hasNext();) {
			System.out.println(iter2.next());
		}

		Set set = new HashSet();
		set.add("��1");
		set.add("��2");
		set.add("��3");

		// Set ����ͨ������ֱ�ӱ���, ������ͨ��Iterator����������Set

//		Iterator iter = set.iterator();
//		while (iter.hasNext()) {
		for(Iterator iter=set.iterator();iter.hasNext();) {  //��forѭ������whileѭ������
			String str = (String) iter.next();
			System.out.println(str);
			;
		}

	}

}
