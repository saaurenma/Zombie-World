package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

/**
 * The main class for the zombie apocalypse game.
 *
 */
public class Application {
	

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Fence(), new Tree(), new Concrete(), new Wall(), new Door());
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"....................................##########..................................",
		"..........................###########........#####..............................",
		"............++...........##......................########.......................",
		"..............++++.......#..............................##......................",
		".............+++...+++...#...............................#......................",
		".........................##..............................##.....................",
		"..........................#...............................#.....................",
		".........................##...............................##....................",
		".........................#...............................##.....................",
		".........................###..............................##....................",
		"...........................####......................######.....................",
		"..............................#########.........####............................",
		"............+++.......................#.........#...............................",
		".............+++++....................#.........#...............................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);
		
		List<String> map2 = Arrays.asList(
		",,,X,,,,,,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,",
		",,,XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX,,,,,,,,,,,,,,,,,,,,XXXXXXXXXXXXX=XXXXXXXXXXXX,",
		",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,X,X,,,,,,,,,,X,",
		",,,,,,,,,,,,,,,,,,,XXXXXXXXXXXXXX,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,X,X,,,,,,,,,,X,",
		",,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,=,=,,,,,,,,,,X,",
		",,,,,,,,,,,,,,,,,,,=,,,,,,,,,,,,=,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,X,X,,,,,,,,,,X,",
		",,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,XXXXXXXXXXXXX,XXXXXXXXXXXX,",
		",,,,,,,,,,,,,,,,,,,XXXXXXXXXXXXXX,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,X,X,,,,,,,,,,X,",
		",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,X,X,,,,,,,,,,X,",
		",,,,,,,,XXX=XXXXXXXXXXXXXXXXXXXXX,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,=,=,,,,,,,,,,X,",
		",,,,,,,,X,,,,,,,,X,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,X,X,,,,,,,,,,X,",
		",,,,,,,,X,,,,,,,,X,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,XXXXXXXXXXXXX=XXXXXXXXXXXX,",
		",,,,,,,,X,,,,,,,,X,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,,X,",
		",,,,,,,,XXXXXXX=XX,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,,X,",
		",,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,=,,,,,,,,,,,,,,,,,,,,,,,,X,",
		",,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,=,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,,X,",
		",,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,,X,",
		",,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,XXXXXXXXXXXXXXXXXXXXXXX=XX,",
		",,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,",
		",,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,XXXXXXXXXXXX=XXXXXXXXXXXX,,",
		",,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,",
		",,,,,,,,XXXXXXXXXXXXXXXXXXXXXXXXX,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,",
		",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,=,,,,,,,,,,,,,,,,,,,,,,,X,,",
		"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,",
		",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,X,,,,,,,,,,,,,,,,,,,,,,,X,,");
		GameMap gameMap2 = new GameMap(groundFactory, map2);
		world.addGameMap(gameMap2);
		
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(42, 15));
		
	    // Place some random humans
		String[] humans = {"Carlton", "May", "Vicente", "Andrea", "Wendy",
				"Elina", "Winter", "Clem", "Jacob", "Jaquelyn"};
		int x, y;
		for (String name : humans) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			} 
			while (gameMap.at(x, y).containsAnActor());
			gameMap.at(x,  y).addActor(new Human(name));	
		}
		
		//place random farmers
		for (int i = 0; i < 3; i++) {
			do {
				x = (int) Math.floor(Math.random() * 20.0 + 30.0);
				y = (int) Math.floor(Math.random() * 7.0 + 5.0);
			} 
			while (gameMap.at(x, y).containsAnActor());
			gameMap.at(x,  y).addActor(new Farmer());
		}
		
		
		// place a simple weapon
		gameMap.at(74, 20).addItem(new Plank());
		
		// Adding Zombies to both maps
		gameMap.at(30, 20).addActor(new Zombie("Groan"));
		gameMap.at(30,  18).addActor(new Zombie("Boo"));
		gameMap.at(10,  4).addActor(new Zombie("Uuuurgh"));
		gameMap.at(50, 18).addActor(new Zombie("Mortalis"));
		gameMap.at(1, 10).addActor(new Zombie("Gaaaah"));
		gameMap.at(62, 12).addActor(new Zombie("Aaargh"));	
		
		gameMap2.at(20, 16).addActor(new Zombie("Shambler"));
		gameMap2.at(38, 10).addActor(new Zombie("Graurgh"));
		gameMap2.at(43, 4).addActor(new Zombie("Zombo"));
		gameMap2.at(46, 12).addActor(new Zombie("Romero"));
		gameMap2.at(59, 9).addActor(new Zombie("Blargh"));
		gameMap2.at(70, 14).addActor(new Zombie("Hurgh"));	
		
		//adding a Car to each map
		gameMap.at(42, 24).addItem(new Car(gameMap2.at(42, 24)));
		gameMap2.at(42, 24).addItem(new Car(gameMap.at(42, 24)));
		
		//adding firearms to the City map
		gameMap2.at(12, 11).addItem(new Shotgun());
		gameMap2.at(73, 3).addItem(new SniperRifle());
		
		//adding ammo to the City map
		gameMap2.at(13, 12).addItem(new ShotgunAmmo());
		gameMap2.at(9, 4).addItem(new ShotgunAmmo());
		gameMap2.at(38, 17).addItem(new ShotgunAmmo());
		gameMap2.at(63, 15).addItem(new ShotgunAmmo());
		gameMap2.at(62, 8).addItem(new ShotgunAmmo());
		gameMap2.at(47, 9).addItem(new ShotgunAmmo());
		gameMap2.at(28, 13).addItem(new ShotgunAmmo());
		gameMap2.at(75, 22).addItem(new ShotgunAmmo());
		gameMap2.at(14, 20).addItem(new ShotgunAmmo());
		gameMap2.at(39, 19).addItem(new ShotgunAmmo());
		
		gameMap2.at(74, 2).addItem(new RifleAmmo());
		gameMap2.at(1, 1).addItem(new RifleAmmo());
		gameMap2.at(58, 21).addItem(new RifleAmmo());
		gameMap2.at(18, 12).addItem(new RifleAmmo());
		gameMap2.at(57, 4).addItem(new RifleAmmo());
		
		world.run();
	}
}
