package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class FireShotgunAction extends Action {

	private String direction;
	private String hotkey;

	public FireShotgunAction(String direction, String hotkey) {
		this.direction = direction;
		this.hotkey = hotkey;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		Location actorLocation = map.locationOf(actor);
		int actorX = actorLocation.x();
		int actorY = actorLocation.y();
		ArrayList<Location> shotLocations = new ArrayList<Location>();
		if (hotkey == "1") {
			for (int i = 0; i == 3; i++) {
				for (int j = 0; j == 3; j++) {
					if (i==0&&j==0) {
						continue;
					}
					else shotLocations.add(new Location(map, actorX-i, actorY-j));
				}
			}
		} else if (hotkey == "2") {

		} else if (hotkey == "3") {

		} else if (hotkey == "4") {

		} else if (hotkey == "6") {

		} else if (hotkey == "7") {

		} else if (hotkey == "8") {

		} else if (hotkey == "9") {

		}

		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return (actor + " fires the Shotgun " + direction);
	}

	@Override
	public String hotkey() {
		return this.hotkey;
	}

}
