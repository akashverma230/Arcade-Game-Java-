package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import utils.GameConstants;

public abstract class Sprites implements GameConstants{
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int speed;
	protected int action;
	protected int power;
	protected boolean isJumping ;
	final int TOTAL_MOVES = 6;
	protected BufferedImage fullImage;
	BufferedImage defaultMove [] = new BufferedImage[TOTAL_MOVES];
	BufferedImage kick [] = new BufferedImage[TOTAL_MOVES];
	BufferedImage currentMoves [] = new BufferedImage[TOTAL_MOVES];
	protected int currentForce;
	BufferedImage hitMove [] = new BufferedImage[TOTAL_MOVES];
	protected boolean isAttacking ;
	Sprites(String imageName) throws Exception {
		isJumping = false;
		//x = 50;
		power=MAX_POWER;
		h = w = 150;
		y = FLOOR - h;
		speed = SPEED;
		action = DEFAULT_MOVE;
		fullImage = ImageIO.read(Sprites.class.getResource(imageName));
		defaultAction();
		kickAction();
		hit();
	
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	protected abstract void defaultAction();
	protected abstract void kickAction();
	protected abstract void hit();
	
	public void fall() {
		if(y>=FLOOR-h) {
			isJumping =false;
			return ;
		}
		currentForce = currentForce + GRAVITY;
		y = y + currentForce;
	}
	
	public void jump() {
		if(!isJumping) {
		currentForce = FORCE;
		y = y + FORCE;
		isJumping = true;
		}
	}
	
	
	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public void move() {
		x = x + speed;
	}
	public boolean isAttacking() {
		return isAttacking;
	}
	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}
	
	public void setAction(int action) {
		
		this.action = action;
	}
	
		int index = 0;
	
	protected void printCurrentMove(Graphics g) {
		if(index>5) {
			index = 0;
			action = DEFAULT_MOVE;
		}
		g.drawImage(currentMoves[index],x,y,w,h,null);
		index++;
	}
	
	
	
	public void draw(Graphics g) {
		if(action == DEFAULT_MOVE) {
			currentMoves = defaultMove;
		}
		else if (action == KICK) {
			currentMoves = kick;
		}
		else if (action ==HIT) {
			currentMoves = hitMove;
		}
		printCurrentMove(g);
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
