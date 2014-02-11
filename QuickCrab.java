import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter{
	public QuickCrab() {

	}

	public ArrayList<Location> getMoveLocations()
	{
	    ArrayList<Location> locs = new ArrayList<Location>();
	    int[] dirs =
	        { Location.LEFT, Location.RIGHT };
	    for (Location loc : getLocationsInDirections(dirs)) {

	    	int direction = getDirection();

	    	int r = loc.getRow();
	    	int c = loc.getCol();
	    	
	    	if (direction == 0 || direction == 180) {
	    		if (c > getLocation().getCol()) {
	    			c++;
	    		} else {
	    			c--;
	    		}
	    	} else {
	    		if (r > getLocation().getCol()) {
	    			r++;
	    		} else {
	    			r--;
	    		}
	    	}

	    	ArrayList<Location> locs2 = new ArrayList<Location>();
	    	

	        if (getGrid().get(loc2) == null) {
	            locs.add(loc2);
	        }
	    }

	    return locs;
	}
}