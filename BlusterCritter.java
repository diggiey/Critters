import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter {

	private int c;
	
	public BlusterCritter(int c) {
		this.c = c;
	}

	public ArrayList<Actor> getActors()
	{
	    return getGrid().getNeighbors(getLocation());
	}

	public void processActors(ArrayList<Actor> actors)
	{
		int amountOfCritters = 0;

	    Location loc = getLocation();

	    getGrid().getValidAdjacentLocations(loc);

	    for (int r = loc.getRow() - 2; r<= loc.getRow()+2; r++) {
	    	for (int z = loc.getCol() - 2; z <= loc.getCol()+2; z++) {
	    		Location a = new Location(r, z);

	    		if (getGrid().isValid(a)) {
	    			if ((getGrid().get(a)) instanceof Critter) {
	    				amountOfCritters++;
	    			}
	    		}
	    	}
	    }

	    System.out.println(amountOfCritters);

		if (amountOfCritters - 1 < this.c) {

			Color color = getColor();

			int red = (int) (color.getRed() + (10));
			if (red >= 255) {
				red = 255;
			}

			int green = (int) (color.getGreen() + (10));
			if (green >= 255) {
				green = 255;
			}

			int blue = (int) (color.getBlue() + (10));
			if (blue >= 255) {
				blue = 255;
			}

			setColor(new Color(red, green, blue));
			return;
		} else {

			Color color = getColor();

			int red = (int) (color.getRed() - (10));
			if (red <= 0) {
				red = 0;
			}

			int green = (int) (color.getGreen() - (10));
			if (green <= 0) {
				green = 0;
			}

			int blue = (int) (color.getBlue() - (10));
			if (blue <= 0) {
				blue = 0;
			}

			setColor(new Color(red, green, blue));
			return;
		}
	}

}