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
 * �ɻ���Ϸ��������
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
	public void paint(Graphics g) { // �Զ���ϵͳ���ã�g�൱��һ֧��
		// TODO Auto-generated method stub
		// super.paint(g);

		g.drawImage(bg, 0, 0, null);
//		g.drawImage(plane, planeX, planeY, null);
//		planeX++;

		plane.drawSeft(g); // ���ɻ�
		// plane2.drawSeft(g);

		shell.draw(g);  //���ӵ�
		
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
//		g.setFont(new Font("����", Font.BOLD, 50));
//		g.drawString("����Smile", 200, 200);
//
//		g.drawImage(ball, 250, 250, null);
//		
//		g.setColor(c);
//		g.setFont(f);
	}

	// �������Ƿ������ػ�����
	class PaintThred extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			// super.run();
			while (true) {
				repaint();
				// System.out.println("���ڻ�һ�Σ�");
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
	 * Key Monitor ������̼������ڲ���
	 */
	class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("���£� "+e.getKeyCode());
			plane.addDirection(e);

		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("̧�� "+e.getKeyCode());
			plane.minusDirection(e);
		}
	}

	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("������ѧ�ã�SmileС��Ϸ");
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

		new PaintThred().start(); // �����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor()); // ��������Ӽ��̵ļ���
	}

	/**
	 * ���˫���弼��
	 * 
	 * @param args
	 */
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(500, 500);// ������Ϸ���ڵĿ�Ⱥ͸߶�

		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	// main���������������
	public static void main(String[] args) {
		MyGameFrame frame = new MyGameFrame();
		frame.launchFrame();
	}

}
