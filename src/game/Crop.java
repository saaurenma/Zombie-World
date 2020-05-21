package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class Crop extends Ground{
	private int age = 0;

	public Crop(CropRipeUnripe isRipe) {
		super('C');
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(Location location) {
		
		super.tick(location);
		age++;
		
	}

}
