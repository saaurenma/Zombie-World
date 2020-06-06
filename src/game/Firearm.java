package game;

import edu.monash.fit2099.engine.Item;

public class Firearm extends Item {

	public Firearm(String name, char displayChar) {
		super(name, displayChar, true);
		allowableActions.add(new ReadyFirearmAction());
	}
	
	public void readyWeapon() {
	}
	
//	public void checkAmmo() {
//	}

	public void shoot() {
	}
}
