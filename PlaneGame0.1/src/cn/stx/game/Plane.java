package cn.stx.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {

	int speed = 3;
	boolean left, up, right, down;

	@Override
	public void drawSeft(Graphics g) {
		// TODO Auto-generated method stub
		// super.drawSeft(g);
		g.drawImage(img, (int) x, (int) y, null);
		// x++; //���ݷ����ж�

		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}

	}

	Plane(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}

	/**
	 * ���ӷ���, ����ĳ������������Ӧ�ķ���
	 */
	public void addDirection(KeyEvent e) {
		System.out.println("####" + e.getKeyCode());
		switch (e.getKeyCode()) {
		// case 37:
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case 38:
			up = true;
			break;
		case 39:
			right = true;
			break;
		case 40:
			down = true;
			break;
		}
	}

	/**
	 * ����ĳ������ȡ����Ӧ�ķ���
	 */
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		// case 37:
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
}
