import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame {

	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

	double x = 100;// С��ĺ�����
	double y = 100;// С���������

	double degree = 3.14 / 3; // ���ȡ��˴���60��

	// �����ڵķ���
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ��");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int) x, (int) y, null);

		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);

		//�������±߽�
		if (y > 500 - 40 - 40 || y < 0 + 40 + 40) {
			//500�Ǵ��ڸ߶ȣ�40�����ӱ߿�30��С���ֱ����0������ԭ������
			degree = -degree;
		}

		//�������ұ߽�
		if (x < 0 + 40 || x > 856 - 40 - 30) {
			degree = 3.14 - degree;
		}
	}

	// �������
	void lanuchFrame() {
		setSize(856, 500);
		setLocation(50, 50);
		setVisible(true);

		// �ػ�����,ÿ�뻭25��
		while (true) {
			repaint();
			try {
				Thread.sleep(40);// 40ms
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// main�����ǳ���ִ�е����
	public static void main(String[] args) {
		System.out.println("Hello Game");
		BallGame2 game = new BallGame2();
		game.lanuchFrame();
	}

}
