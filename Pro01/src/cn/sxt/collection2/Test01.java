package cn.sxt.collection2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/***
 * // 一个对象对应一条记录
 * 用List封装数据
 * @author Administrator
 *
 */

public class Test01 {
	public static void main(String[] args) throws ParseException {
//			Employee e = new Employee();
//			e.setId(0301);
//			e.setName("Smile");
//			e.setDepartment("Project Department");
//			e.setSalary(3000);
//			String strDate = "2007-10";
//			DateFormat format = new SimpleDateFormat("yyyy-MM");
//			e.setHireDate(format.parse(strDate));

		// 一个对象对应一条记录
		Employee e = new Employee(0301, "Smil", 3000, "Project Group", "2007-10");
		Employee e2 = new Employee(0302, "Smil2", 3500, "Project Group2", "2017-10");
		Employee e3 = new Employee(0303, "Smil3", 3530, "Project Group3", "2017-12");

		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		list.add(e3);

		printEmpName(list);
	}

	public static void printEmpName(List<Employee> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
	}
}
