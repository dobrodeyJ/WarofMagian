package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import Portals.Portal;
import Portals.PortalZombies;

import objects.Magian;
import objects.Player;

public class Controller implements KeyListener, ActionListener  {
	private DisplayWorld world;
	private Player player;
	private Map map;
	private Timer mainTimer;
	private CheckObjects check;
	private WaweAlgorithm wawe;
	private Portal portal;
	
	public Controller() {
		initObjects();
	}
	
	private void initObjects() {
		initMap();
		initPortal();
		initPlayer();
		initWaweAlgorithm();
		initCheck();
		initDisplay();
		initTimer();
	}
	private void initPortal() {
		portal = new PortalZombies();
	}
	private void initDisplay() {
		world = new DisplayWorld(map , player, wawe, portal);
		world.getWindows().addKeyListener(this);
	}
	
	private void initTimer(){
		mainTimer = new Timer(40, this);
		mainTimer.start();
	}
	
	private void  initWaweAlgorithm() {
		wawe = new WaweAlgorithm(player, map);
		wawe.startWay();	
	}
	
	private void initMap() {
		map = new Map();
	}
	
	private void  initCheck() {
		check = new CheckObjects(map, player, portal, wawe);
	}
	
	private void initPlayer() {
		player = new Magian(55, 105);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		switch(key.getKeyCode()) {
			case KeyEvent.VK_RIGHT : {player.toRight(); break;}
			case KeyEvent.VK_LEFT  : {player.toLeft();  break;}
			case KeyEvent.VK_UP    : {player.toUp();    break;}
			case KeyEvent.VK_DOWN  : {player.toDown();  break;}
			case KeyEvent.VK_SPACE : {if(player.isLive()) {
									 	if(!player.getAtack().isAtack())
									 		player.isAtack();
									  }
									  break;}
		}
	} 

	@Override
	public void keyReleased(KeyEvent key) {
		switch(key.getKeyCode()) {
			case KeyEvent.VK_RIGHT : {player.setRight(false); break;}
			case KeyEvent.VK_LEFT  : {player.setLeft(false);  break;}
			case KeyEvent.VK_UP    : {player.setUp(false);    break;}
			case KeyEvent.VK_DOWN  : {player.setDown(false);  break;}
		}
	}

	@Override
	public void keyTyped(KeyEvent key) {

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		check.checkObject();
		world.repaint();
	}
}
