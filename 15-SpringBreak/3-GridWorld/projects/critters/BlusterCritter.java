//Exercise #4

import info.gridworld.actor.Actor;
import java.awt.Color;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class BlusterCritter extends Critter
{	
    //instance variables
    private int c ;

    //Constructor
    public BlusterCritter(){
	setColor(new Color(128, 0, 0));
	//courage level set at 2 critters
	c = 2 ;
    } 

    //BlusterCritter changes brightness based on surrounding critters
    public void processActors(ArrayList<Actor> actors)
    {
	//make list of all critters in 24 surrounding blocks
	ArrayList<Location> all = new ArrayList<Location>();

	ArrayList<Location> around = getGrid().getValidAdjacentLocations(getLocation());
	for(int x = 0 ; x < around.size() ; x++){
	    ArrayList<Location> temp = getGrid().getValidAdjacentLocations(around.get(x));
	    for(int y = 0 ; y < temp.size() ; y++){
		if( !(getGrid().get(temp.get(y))==null) ){
		    if(    (getGrid().get(temp.get(y)) instanceof Critter) 
			&& (!(temp.get(y).compareTo(this.getLocation())==0)) 
			){
			if(all.indexOf(temp.get(y))== -1){
			    all.add(temp.get(y));
			}
		    }
		}
	    }
	}
	
	int courage = all.size();
		
	//change brightness
	int red = (int) (255 * 0.5 * (c / (1+courage) ) ) ;
	    
	setColor(new Color(red, 0, 0));

    }
}
