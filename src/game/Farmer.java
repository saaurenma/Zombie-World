package game;

public class Farmer extends Human {
	
	private Behaviour[] behaviours = {
			new SowBehaviour(),
			new FertilizeBehaviour(),
			new WanderBehaviour()
	};
	
	protected Farmer(int hitPoints) {
		super("farmer", 'F', hitPoints);
		// TODO Auto-generated constructor stub
	}


	

}
