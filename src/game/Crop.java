package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Crop extends Item{
	private int age;
	private int ripenTime;

	public Crop(CropRipeUnripe isRipe) {
		super("crop", 'C', false);
		this.addCapability(isRipe);
		this.age = 0;
		this.ripenTime = 20;
	}
	
	public void fertilize() {
		
		if (ripenTime > 0) {
			ripenTime -= 10;
		}
		
		else {
			this.removeCapability(CropRipeUnripe.UNRIPE);
			this.addCapability(CropRipeUnripe.RIPE);
		}
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		this.age++;
		this.ripenTime--;
	}

}
