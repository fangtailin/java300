package cn.sxt.thread;

/***
 * 多线程模拟龟兔赛跑
 * 1.创建多线程 继承Thread + 重写run方法
 * @author Administrator
 *
 */
public class Rabbit extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("兔子跑了"+i+"步");
		}
	}
	
	
}

class Tortoise extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("乌龟跑了"+i+"步");
		}
	}
	
	
}
