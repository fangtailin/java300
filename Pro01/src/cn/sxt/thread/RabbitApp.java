package cn.sxt.thread;

public class RabbitApp {
	public static void main(String[] args) {
		// �����������
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();

		//����start���������̣߳�  ����������run������ ֱ�ӵ���run�����Ļ����൱����ͨ����
		rab.start();
		tor.start();

		for (int i = 0; i < 1000; i++) {
			System.out.println("main-->" + i);
		}
	}
}
