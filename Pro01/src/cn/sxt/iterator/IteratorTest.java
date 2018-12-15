package cn.sxt.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/***
 * Set 不能通过索引直接遍历, 但是能通过Iterator迭代器进行遍历
 * 而List能够通过索引遍历，也能通过Iterator迭代器进行遍历
 * Iterator是用过游标cursor进行循环
 * @author Administrator
 *
 */
public class IteratorTest {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("Gao1");
		list.add("Gao2");
		list.add("Gao3");

		//通过索引遍历List
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//通过迭代器Iterator遍历List
		for(Iterator iter2=list.iterator();iter2.hasNext();) {
			System.out.println(iter2.next());
		}

		Set set = new HashSet();
		set.add("高1");
		set.add("高2");
		set.add("高3");

		// Set 不能通过索引直接遍历, 但是能通过Iterator迭代器遍历Set

//		Iterator iter = set.iterator();
//		while (iter.hasNext()) {
		for(Iterator iter=set.iterator();iter.hasNext();) {  //用for循环代替while循环遍历
			String str = (String) iter.next();
			System.out.println(str);
			;
		}

	}

}
