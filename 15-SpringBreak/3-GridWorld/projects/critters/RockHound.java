//Exercise #3

import info.gridworld.actor.Actor;
import java.awt.Color;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class RockHound extends Critter
{
    //RockHound removes adjacent rocks from grid
    public void processActors(ArrayList<Actor> actors)
    {
	super.processActors(actors);
        for(int x = 0 ; x < actors.size() ; x++){
	    if(actors.get(x) instanceof Rock){
		actors.get(x).removeSelfFromGrid();
	    }
	}
    }
}
