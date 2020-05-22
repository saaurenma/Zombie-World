package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class SowBehaviour implements Behaviour {
	Random rand = new Random();


	
	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		int randomNum = Math.abs(rand.nextInt() % 3) + 1;
		
		for (Exit e: exits) {
			Ground currentGround = e.getDestination().getGround();
			if (!(currentGround instanceof Dirt))
				continue;
			else if (randomNum == 1) {
				return new SowAction(e.getDestination());
			}
		}
		return null;
	}
		
	
	
	


}
