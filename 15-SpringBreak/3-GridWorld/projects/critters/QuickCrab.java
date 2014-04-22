//Exercise #5

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
    public QuickCrab()
    {
        setColor(Color.BLUE);
    }

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }

        return actors;
    }

    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
            if(getGrid().get(loc) == null){
                locs.add(loc);
	    }
        return locs;
    }

    /**
     * If the crab critter doesn't move, it randomly turns left or right.
     */
    public void makeMove(Location loc)
    {
        if (loc.equals(getLocation()))
        {
            double r = Math.random();
            int angle;
            if (r < 0.5)
                angle = Location.LEFT;
            else
                angle = Location.RIGHT;
            setDirection(getDirection() + angle);
        }
        else
            super.makeMove(loc);
    }
    
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if ( gr.isValid(neighborLoc)){
		if(gr.get(neighborLoc)==null){
		    Location neighborLocTwo = neighborLoc.getAdjacentLocation(getDirection() + d) ;
		    if (gr.isValid(neighborLocTwo)){
			if(gr.get(neighborLoc)==null){
                    	    locs.add(neighborLocTwo);
			}else{
			    locs.add(neighborLoc);
			}
		    }
		}
	    }
        }
        return locs;
    }    
}
