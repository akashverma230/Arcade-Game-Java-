package main;

import java.io.IOException;

import javax.swing.JFrame;

import utils.GameConstants;

public class GameFrame extends JFrame implements GameConstants {
   public GameFrame() throws Exception{
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("Game Basics");
		
		Brd brd = new Brd();
		add(brd);
		setVisible(true);
   }
  
public static void main(String[] args) {
		try {
			GameFrame obj = new GameFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
