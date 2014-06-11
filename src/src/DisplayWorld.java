package src;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

import Portals.Portal;

import objects.Bot;
import objects.Player;


public class DisplayWorld extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int HEIGHT = 635;
	private final int WIDTH  = 1065;
	private final int POSX = 150;
	private final int POSY = 50;
	private Graphics canvas;
	private JFrame frame;
	private Map worldMap;
	private Player player;
	private WaweAlgorithm wawe;
	private Portal portal;
	
	public DisplayWorld(Map map, Player player, WaweAlgorithm wawe, Portal portal) {
		this.player = player;
		this.worldMap = map;
		this.portal = portal;
		this.wawe = wawe;
		initComponents();
	}
	private void initComponents() {
		initFrame();
	}
	
	private void initFrame() {
		frame = new JFrame("RPG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(POSX, POSY);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(this);
		frame.setVisible(true);
	}
		
	private void drawWorld() {
		drawMap();
		drawPortal();
		drawPlayer();
		drawBots();
		drawAtack();
		for(int i = 0; i < worldMap.getHeight(); i++)
			for(int j = 0; j < worldMap.getWidth(); j++)
				canvas.drawString(Integer.toString(wawe.getCopyValues(i, j)), j* 50 + 10, i * 50 + 10);
	}
	
	private void drawPortal() {
		try{
			canvas.drawImage(portal.getImg(), portal.getPositionX(), 
							 portal.getPositionY(), null);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ошибка прорисовки ХП");
		}
	}
	
	
	
	
	public void paint(Graphics canvas) {
		this.canvas = canvas;
		drawWorld();

	}
	private void drawPlayer() {
		if(player.isLive()) {
			try{
				canvas.drawImage(player.getImage(), player.getPositionX(), player.getPositionY(), null);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Ошибка прорисовки персонажа");
			}
		}
		drawHealthHero();
	}
	
	private void drawHealthPortal() {
		try{
			canvas.drawImage(portal.getHealth().getImage(), portal.getHealth().getPositionX(), 
					portal.getHealth().getPositionY(), null);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ошибка прорисовки ХП");
		}
			
	}

	private void drawHealthHero() {
		try{
			canvas.drawImage(player.getHealth().getImage(), player.getHealth().getPositionX(), 
							 player.getHealth().getPositionY(), null);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ошибка прорисовки ХП");
		}
	}
	
	private void drawHealthBots(Bot bot) {
		if(bot.isLive()) {
			try{
				canvas.drawImage(bot.getHealth().getImage(), bot.getHealth().getPositionX(), 
						bot.getHealth().getPositionY(), null);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Ошибка прорисовки ХП");
			}
		}
	}
	
	private void drawAtack() {
		if(player.getAtack().isAtack()) {
			try{
				canvas.drawImage(player.getAtack().getImg(), player.getAtack().getPositionX(), player.getAtack().getPositionY(), null);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Ошибка прорисовки атаки персонажа");
			}
		}
	}
	
	public JFrame getWindows() {
		return frame;
	}
	
	
	private void drawBots() {
		ArrayList<Bot> bots = portal.getBots();
		for(Bot bot :bots) {
			if(bot.isLive())
				drawBot(bot);
			    drawHealthBots(bot);
		}
	}
	
	private void drawBot(Bot bot) {
		try{
			canvas.drawImage(bot.getImage(), bot.getPositionX(), bot.getPositionY(), null);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Ошибка прорисовки Бота");
		}
	}
	
	private void drawMap() {
		for(int row = 0; row < worldMap.getHeight(); row++)
			for(int col = 0; col < worldMap.getWidth(); col++) {
					switch(worldMap.getValues(row, col)) {
						case 0   : {canvas.drawImage(new ImageIcon("resource//texture//box2.jpg").getImage(), col * 50, row * 50, null); break;}
						case 500 : {canvas.drawImage(new ImageIcon("resource//texture//Plitka2.jpg").getImage(), col * 50, row * 50, null); break;}
						case 100 : {canvas.drawImage(new ImageIcon("resource//texture//woodBox.jpg").getImage(), col * 50, row * 50, null); break;}
						case 200 : {canvas.drawImage(new ImageIcon("resource//texture//box.jpg").getImage(), col * 50, row * 50, null); break;}
						case 300 : {canvas.drawImage(new ImageIcon("resource//texture//Portal_In.jpg").getImage(), col * 50, row * 50, null); break;}
						case 400 : {canvas.drawImage(new ImageIcon("resource//texture//Portal_Out.jpg").getImage(), col * 50, row * 50, null); break;}
						case 700 : {canvas.drawImage(new ImageIcon("resource//texture//woodBoxDestroyOne.jpg").getImage(), col * 50, row * 50, null); break;}
						case 800 : {canvas.drawImage(new ImageIcon("resource//texture//woodBoxDestroyTwo.jpg").getImage(), col * 50, row * 50, null); break;}
						case 900 : {canvas.drawImage(new ImageIcon("resource//texture//grass2.jpg").getImage(), col * 50, row * 50, null); break;}
					}
			}
		}
	}
