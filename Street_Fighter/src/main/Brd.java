package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import sprites.Power;
import sprites.kenPlayer;
import sprites.ryuPlayer;
import utils.GameConstants;

public class Brd extends JPanel implements GameConstants,ActionListener,KeyListener{
	BufferedImage background;
	Timer timer;
	ryuPlayer ryu;
	kenPlayer ken;
	Power player1Power;
	Power player2Power;
	boolean isGameOver ;
public Brd() throws Exception {
	loadBackground();
	ryu=new ryuPlayer();
	ken=new kenPlayer();
	gameLoop();
	bindEvents();
	setFocusable(true);
	player1Power = new Power(10,"Ryu");
	player2Power = new Power(BOARD_WIDTH/2+170,"Ken");
}
public void loadBackground() throws Exception  {
	background=ImageIO.read(Brd.class.getResource("backgr.jpg"));
}
void bindEvents() {
	this.addKeyListener(this);
}
void gameLoop() {
	timer = new Timer(DELAY,this);
	timer.start();
}
@Override
protected void paintComponent(Graphics g) {
	// TODO Auto-generated method stub
	super.paintComponent(g);
	g.drawImage(background,0,0,BOARD_WIDTH, BOARD_HEIGHT, null);
	ryu.draw(g);
	ken.draw(g);
	drawPower(g);
	playerAttackHit();
	displayMessage(g);
}
public void drawPower(Graphics g) {
	player1Power.draw(g);
	player2Power.draw(g);
}
 @Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	 ryu.fall();
	 ken.fall();
	repaint();
}
 public void displayMessage(Graphics pen) {
		if(isGameOver) {
			pen.setFont(new Font("times", Font.BOLD, 50));
			pen.setColor(Color.RED);
			pen.drawString("Game Over", BOARD_HEIGHT/2, BOARD_WIDTH/2);
			
			timer.stop();
		}
 }
 public boolean playerAttackHit() {
		if(isCollide()) {
		if(ryu.isAttacking()) {
			ken.setAction(HIT);
			ken.setPower(ken.getPower()-10);
			player2Power.setW(player2Power.getW()-10);
			
		}
		else if(ken.isAttacking()) {
			ryu.setAction(HIT);
			ryu.setPower(ryu.getPower()-10);
			player1Power.setW(player1Power.getW()-10);
			
		}
		else if (ryu.isAttacking() && ken.isAttacking()) {
			ryu.setAction(HIT);
			ken.setAction(HIT);
			ken.setPower(ken.getPower()-10);
			player2Power.setW(player2Power.getW()-10);
			ryu.setPower(ryu.getPower()-10);
			player1Power.setW(player1Power.getW()-10);
		}
		if(ryu.getPower()<=0 || ken.getPower()<=0) {
			isGameOver = true;
		}
		return true;
		}
		return false;
	}
	
	public boolean isCollide() {
		
		int xDistance = Math.abs(ryu.getX() - ken.getX());
		int yDistance = Math.abs(ryu.getY() - ken.getY());
		int maxH = Math.max(ryu.getH(), ken.getH());
		int maxW = Math.max(ryu.getW(), ken.getW());
		return xDistance<=maxW-50 && yDistance<=maxH;
	}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_K) {
		ryu.setAction(KICK);
		ryu.setAttacking(true);
	}
	else if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
		ryu.setSpeed(SPEED);
		ryu.move();
	}
	else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		ryu.setSpeed(SPEED * -1);
		ryu.move();
	}
	else if(e.getKeyCode()==KeyEvent.VK_A) {
		ken.setSpeed(SPEED*-2);
		ken.move();
	}
	else if(e.getKeyCode()==KeyEvent.VK_D){
		ken.setSpeed(SPEED*2);
		ken.move();
	}
	else if(e.getKeyCode()==KeyEvent.VK_L) {
		ken.setAction(KICK);
		ken.setAttacking(true);
	}
	else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
		ryu.jump();
	}
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
