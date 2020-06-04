package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * 
 * @author Paul McIntosh
 *
 *         A class that represents Walls. Impassible.
 */
public class Wall extends Ground {

	/**
	 * Constructor class for Wall object.
	 */
	public Wall() {
		super('X');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
