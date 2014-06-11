package Portals;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import objects.Bot;
import objects.Zombies;


public class PortalZombies extends Portal {
	private Timer timer;
	private final int  maxCountZombies = 15;
	private int countZombies = 0;
	public PortalZombies() {
		setPosition(1000, 500);
		setNameImage("resource//Portals//portal.png");
		anymate();
		bots = new ArrayList<Bot>();
		timer = new Timer();
		start();
	}

	@Override
	public void start() {
		timer.schedule(taskBots, 1, 3 * 1000);
	}
	
	TimerTask taskBots = new TimerTask() {
		@Override
		public void run() {
			if(isLives())
				if(countZombies < maxCountZombies){
					bots.add(new Zombies(getPositionX() - 45, getPositionY() + 5));
					countZombies++;
				}
			checkCountZombies();
		}
		private void checkCountZombies() {
			for(int i = 0; i < bots.size(); i++)
				if(!bots.get(i).isLive()){
					bots.remove(i);
					countZombies--;
				}
		}
	};
	
}
