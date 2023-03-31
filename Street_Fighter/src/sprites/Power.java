package sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Power {
	private int x;
	private int y;
	private int w;
	//private int h;
	private String playerName;
	final int FIX_WIDTH;
	public Power(int x, String playerName) {
		this.x = x;
		this.playerName = playerName;
		y = 20;
		w = 300;
		FIX_WIDTH = w;
	}
	
	
	
	public int getW() {
		return w;
	}



	public void setW(int w) {
		this.w = w;
	}



	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, 20,FIX_WIDTH,20);
		g.setColor(Color.GREEN);
		g.fillRect(x, 20,w,20);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times",Font.BOLD,15));
		g.drawString(playerName, x, y+40);
	}

}
