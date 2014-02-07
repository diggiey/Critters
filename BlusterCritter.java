import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter {
	
	public BlusterCritter(int c) {

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

	    for (int r = loc.getRow() - 2; r<=2; r++) {
	    	for (int c = loc.getCol() - 2; c <= 2; c++) {
	    		if (!(a instanceof Critter)) {
	    		    
	    		} else {
	    			amountOfCritters++;
	    		}
	    	}
	    }

	    // for ( Location l : getGrid().getValidAdjacentLocations(loc)) {
	    	
	    // }

		int emptyLocations = getGrid().getEmptyAdjacentLocations(getLocation()).size();
		int c = getActors().size();

		if (emptyLocations > c) {

			Color color = getColor();

			int red = (int) (color.getRed() + (1));
			if (red >= 255) {
				red = 255;
			}

			int green = (int) (color.getGreen() + (1));
			if (green >= 255) {
				green = 255;
			}

			int blue = (int) (color.getBlue() + (1));
			if (blue >= 255) {
				blue = 255;
			}

			setColor(new Color(red, green, blue));
			return;
		} else {

			Color color = getColor();

			int red = (int) (color.getRed() - (1));
			if (red <= 0) {
				red = 0;
			}

			int green = (int) (color.getGreen() - (1));
			if (green <= 0) {
				green = 0;
			}

			int blue = (int) (color.getBlue() - (1));
			if (blue <= 0) {
				blue = 0;
			}

			setColor(new Color(red, green, blue));
			return;
		}
	}

}