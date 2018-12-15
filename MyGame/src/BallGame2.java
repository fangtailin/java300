import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame {

	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

	double x = 100;// 小球的横坐标
	double y = 100;// 小球的纵坐标

	double degree = 3.14 / 3; // 幅度。此处是60度

	// 画窗口的方法
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int) x, (int) y, null);

		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);

		//碰到上下边界
		if (y > 500 - 40 - 40 || y < 0 + 40 + 40) {
			//500是窗口高度，40是桌子边框，30是小球的直径，0是左上原点坐标
			degree = -degree;
		}

		//碰到左右边界
		if (x < 0 + 40 || x > 856 - 40 - 30) {
			degree = 3.14 - degree;
		}
	}

	// 窗体加载
	void lanuchFrame() {
		setSize(856, 500);
		setLocation(50, 50);
		setVisible(true);

		// 重画窗口,每秒画25次
		while (true) {
			repaint();
			try {
				Thread.sleep(40);// 40ms
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// main方法是程序执行的入口
	public static void main(String[] args) {
		System.out.println("Hello Game");
		BallGame2 game = new BallGame2();
		game.lanuchFrame();
	}

}
