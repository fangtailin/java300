package cn.stx.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/***
 * 飞机游戏的主窗口
 * 
 * @author Administrator
 *
 */
public class MyGameFrame extends JFrame {

	// Image ball = GameUtil.getImage("images/ball.png");

	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/background.png");

	// int planeX=250,planeY=250;
	Plane plane = new Plane(planeImg, 250, 250);
	// Plane plane2=new Plane(planeImg,350,250);
	
	Shell shell=new Shell();
	
	@Override
	public void paint(Graphics g) { // 自动被系统调用，g相当于一支笔
		// TODO Auto-generated method stub
		// super.paint(g);

		g.drawImage(bg, 0, 0, null);
//		g.drawImage(plane, planeX, planeY, null);
//		planeX++;

		plane.drawSeft(g); // 画飞机
		// plane2.drawSeft(g);

		shell.draw(g);  //画子弹
		
//		Color c = g.getColor();
//		Font f = g.getFont();
//
//		g.setColor(Color.BLUE);
//
//		g.drawLine(100, 100, 300, 300);
//		g.drawRect(100, 100, 300, 300);
//		g.setColor(Color.red);
//		g.drawOval(100, 100, 300, 300);
//
//		g.setFont(new Font("宋体", Font.BOLD, 50));
//		g.drawString("我是Smile", 200, 200);
//
//		g.drawImage(ball, 250, 250, null);
//		
//		g.setColor(c);
//		g.setFont(f);
	}

	// 帮助我们反复的重画窗口
	class PaintThred extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			// super.run();
			while (true) {
				repaint();
				// System.out.println("窗口画一次！");
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 40ms
			}
		}
	}

	/**
	 * Key Monitor 定义键盘监听的内部类
	 */
	class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("按下： "+e.getKeyCode());
			plane.addDirection(e);

		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("抬起： "+e.getKeyCode());
			plane.minusDirection(e);
		}
	}

	/**
	 * 初始化窗口
	 */
	public void launchFrame() {
		this.setTitle("网易尚学堂：Smile小游戏");
		this.setVisible(true);
//		this.setSize(500, 500);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHLT);
		this.setLocation(300, 300);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// super.windowClosing(e);
				System.exit(0);
			}
		});

		new PaintThred().start(); // 启动重画窗口的线程
		addKeyListener(new KeyMonitor()); // 给窗口添加键盘的监听
	}

	/**
	 * 添加双缓冲技术
	 * 
	 * @param args
	 */
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(500, 500);// 这是游戏窗口的宽度和高度

		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	// main函数，程序主入口
	public static void main(String[] args) {
		MyGameFrame frame = new MyGameFrame();
		frame.launchFrame();
	}

}
