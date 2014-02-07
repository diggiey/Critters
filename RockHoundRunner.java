import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class RockHoundRunner
{
    public static void main(String[] args)
    {
    	ActorWorld world = new ActorWorld();
    	world.add(new Location(2, 8), new Rock(Color.BLUE));
        world.add(new Location(5, 8), new RockHound());
        world.show();
    }
}