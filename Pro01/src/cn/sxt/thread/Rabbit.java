package cn.sxt.thread;

/***
 * ���߳�ģ���������
 * 1.�������߳� �̳�Thread + ��дrun����
 * @author Administrator
 *
 */
public class Rabbit extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("��������"+i+"��");
		}
	}
	
	
}

class Tortoise extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("�ڹ�����"+i+"��");
		}
	}
	
	
}
