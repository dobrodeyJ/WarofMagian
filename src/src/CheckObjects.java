package src;

import java.util.ArrayList;

import Portals.Portal;

import objects.Bot;
import objects.Player;
import objects.Teleports;
import src.Teleport;

public class CheckObjects {
	private  Player player;
	private  Map world;
	private  Collision collision;
	private  Teleport teleport;
	private  WaweAlgorithm waweAlgorithm;
	private Portal portal;
	
	public CheckObjects(Map map, Player player, Portal portal, WaweAlgorithm waweA) {
		this.player = player;
		this.portal = portal;
		this.world = map;
		collision = new Collision();
		teleport = new Teleport(world, player);
		waweAlgorithm = waweA;
	}
	
	public void checkObject() {
			checkPlayer();
			checkBots();
			checkAtack();	
	}
	
	private  void  checkPlayer() {
		if(player.isLive()) {
			int posX = player.getPositionX();
			int posY = player.getPositionY();		
			if(player.isRight())
				posX += player.getStep();
			else if(player.isLeft())
				posX -= player.getStep();
			else if(player.isUp())
				posY -= player.getStep();
			else if(player.isDown())
				posY += player.getStep();
			if(checkCollisionPlayers(posX, posY))
				player.move();
			waweAlgorithm.startWay();
			player.animate();
	}
	}
	private void checkAtack() {
		if(player.getAtack().isAtack()) {
			int posX = player.getAtack().getPositionX();
			int posY = player.getAtack().getPositionY();
			switch(player.getAtack().getDirection()) {
				case RIGHT: {posX +=player.getAtack().getStep(); break;}
				case LEFT:  {posX -=player.getAtack().getStep(); break;}
				case UP:    {posY -=player.getAtack().getStep(); break;}
				case DOWN:  {posY +=player.getAtack().getStep(); break;}	  
			}
			if(checkCollisionAtack(posX, posY)) 
				player.getAtack().move();
			else
				player.getAtack().setAtack(false);
			player.getAtack().animate();
		}
	}
	
	private void  checkBots(){
		ArrayList<Bot> bots = portal.getBots();
		for(Bot bot: bots){
			if(bot.isLive())
				checkBot(bot);
		}
	}
	
	private void checkBot(Bot bot) {
		MyRectangle rectBot = new MyRectangle(bot.getPositionX(), bot.getPositionY(), bot.getWidth(), bot.getHeight());
		if(checkBotAtack(rectBot)) {
			return;	
		}
		else {
			if(bot.getCountMove() == 0)  
				waweAlgorithm.next(bot);
			bot.move();
		}
	}
	
	private boolean checkCollisionPlayers(int posX, int posY) {
			Teleports portal;
			MyRectangle rectPlayer = new MyRectangle(posX,posY,player.getWidth(),player.getHeight());	
			int size = world.getSize();
			  for(int col = 0; col < world.getHeight(); col++)
			        for(int row = 0; row < world.getWidth(); row++) {
			            MyRectangle rectBlock = new MyRectangle(row * size, col * size, size, size);
			                switch(world.getValues(col, row)) {
			                        case 100: {
			                                if(collision.collision(rectPlayer,rectBlock))
			                                        return false; break;}
			                        case 200: {
			                        		if(collision.collision(rectPlayer,rectBlock))
			                                       return false; break;}
			                         case 300: {
			                        	 		if(collision.collision(rectPlayer,rectBlock)) {
			                        	 			portal = Teleports.OUT;	
			                        	 			teleport.teleportation(portal);
			                        	 		}
			                                break;
			                                }
			                        case 400: {
			                                if(collision.collision(rectPlayer, rectBlock)){
			                                		portal = Teleports.IN;
			                                        teleport.teleportation(portal);
			                                }
			                                break;}
			                                
			                        case 700: {
			                        		if(collision.collision(rectPlayer,rectBlock))
			                                        return false; break;}
			                        case 800: {
			                        		if(collision.collision(rectPlayer,rectBlock))
			                                        return false; break;}
			                }
			        }
		return true;
	}
	
	private boolean checkCollisionAtack(int posX, int posY) {
		MyRectangle rectAtack = new MyRectangle(posX, posY, player.getAtack().getWidth(), player.getAtack().getHeight());
		if(checkAtackBots(rectAtack))
			return false;
		else {
		int size = world.getSize();
		for(int row = 0; row < world.getHeight(); row++)
		        for(int col = 0; col < world.getWidth(); col++) {
		        	MyRectangle rectBlock = new MyRectangle(col * size, row * size, size, size);	   
		            switch(world.getValues(row, col)) {
		                        case 100:{
		                                if(collision.collision(rectAtack, rectBlock)){
		                                        world.setValues(row, col, 700);
		                                        return false;}break;}
		                        case 200:{
		                                 if(collision.collision(rectAtack, rectBlock))
		                                       return false;break;}
		                        case 700:{if(collision.collision(rectAtack, rectBlock)){
		                                        world.setValues(row, col, 800);
		                                        return false;}break;}
		                        case 800:{if(collision.collision(rectAtack, rectBlock)) {
		                                        world.setValues(row, col, 0);
		                                        return false;}break;}
		                }
		        }
		
		return true;
		}
	}
	
	private boolean checkBotAtack(MyRectangle rectBot) {
		MyRectangle rectPlayer = new MyRectangle(player.getPositionX(), player.getPositionY(), player.getWidth(), player.getHeight());
		if(collision.collision(rectBot, rectPlayer)) {
			player.damage();
			return true;
		}
		return false;
	}
	
	private boolean checkAtackBots(MyRectangle rectAtack) {	
		ArrayList<Bot> bots = portal.getBots();
		for(Bot bot: bots) {
			if(bot.isLive()) {
				MyRectangle rectBot = new MyRectangle(bot.getPositionX(), bot.getPositionY(), bot.getWidth(), bot.getHeight());
				if(collision.collision(rectAtack, rectBot)) {
					bot.damage();
					return true;
				}
			}
		}
		return false;
	}
}
