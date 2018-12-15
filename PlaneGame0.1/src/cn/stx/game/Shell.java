package cn.stx.game;

import java.awt.Color;
import java.awt.Graphics;

/***
 * 炮弹类
 * 
 * @author Administrator
 *
 */
public class Shell extends GameObject {

	double degree; // 弧度

	public Shell() {
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		speed = 3;
		degree = Math.random() * Math.PI * 2; // 生成0到2PI的随机数
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int) x, (int) y, width, height);

		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		if (x < 0 || x > Constant.GAME_WIDTH-width) {
			degree = Math.PI - degree;
		}

		if (y < 0 || y > Constant.GAME_HEIGHLT-height) {
			degree = -degree;
		}

		g.setColor(c);

	}
}
