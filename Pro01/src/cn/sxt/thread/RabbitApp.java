package cn.sxt.thread;

public class RabbitApp {
	public static void main(String[] args) {
		// 创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();

		//调用start方法启动线程，  而不是条用run方法， 直接调用run方法的话就相当于普通调用
		rab.start();
		tor.start();

		for (int i = 0; i < 1000; i++) {
			System.out.println("main-->" + i);
		}
	}
}
