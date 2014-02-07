import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class ChameleonKid extends Critter
{

    private static final double DARKENING_FACTOR = 0.05;

    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            setColor(new Color(red, green, blue));
            return;
        }
        int r = (int) (Math.random() * n);

        Actor other = actors.get(r);
        setColor(other.getColor());
    }

    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }

    public ArrayList<Actor> getActors() {
       ArrayList<Actor> neighbors = super.getActors();
       ArrayList<Actor> actors = new ArrayList<Actor>();

       ArrayList<Location> locs = new ArrayList<Location>();
       locs.add(getLocation().getAdjacentLocation(getDirection()));
       locs.add(getLocation().getAdjacentLocation(getDirection() + 180));

       for (Actor n : neighbors) {
           for (Location loc : locs) {
               if (n.getLocation().equals(loc)) {
                   actors.add(n);
                   continue;
               }
           }
       }

       return actors;
    }
}
