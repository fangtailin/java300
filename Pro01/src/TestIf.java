
public class TestIf {
	public static void main(String[] args) {
		double d = Math.random();// 返回【0，1】之间的随机数
		System.out.println(d);

		int h = (int) (6 * Math.random() + 1);
		System.out.println(h);

		if (h < 3) {
			System.out.println("小小小");
		} else
			System.out.println("大大大");
	}

	double d = Math.PI;//按住ctrl+PI 查看源码
}
