//Exercise #6

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter
{
    //Constructor
    public KingCrab()
    {
        setColor(Color.GREEN);
    }

    //KingCrab pushes the actors it sees back a space, otherwise removes them from grid

    public void processActors(ArrayList<Actor> actors){
	for(int x = 0 ; x < actors.size() ; x++){
	    int dir = actors.get(x).getLocation().getDirectionToward(this.getLocation());
	    if(dir < 180){
		dir += 180;
	    }else{
		dir -= 180;
	    }
	    if( getGrid().isValid(actors.get(x).getLocation().getAdjacentLocation(dir)) ){
		actors.get(x).moveTo(actors.get(x).getLocation().getAdjacentLocation(dir));
	    }else{
		actors.get(x).removeSelfFromGrid();
	    }	
	}	
    }
}
