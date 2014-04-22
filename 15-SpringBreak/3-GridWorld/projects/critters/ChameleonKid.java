//Exercise #2

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter{

    //instance variables
    Location front,back;
    private static final double DARKENING_FACTOR = 0.05;

    //ChameleonKid processActors() method
    public void processActors(ArrayList<Actor> actors){
	try{

	//get locations of front and back spaces
	front = getLocation().getAdjacentLocation(getDirection());
	back = getLocation().getAdjacentLocation(getDirection() + 180) ;

	//if no actors front and back, darken
	if( (getGrid().get(front) == null)&&(getGrid().get(back) == null)){
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR)); 
	    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	    
	    setColor(new Color(red, green, blue));
            return;
	}

	//otherwise, randomly choose actor in front or behind and copy color
	int n = 0;
	ArrayList<Actor> adj = new ArrayList<Actor>();

	for(int x = 0 ; x < actors.size() ; x++){
	    if(actors.get(x).getLocation().compareTo(front)==0){	
		n++;
		adj.add(actors.get(x));
	    }else if(actors.get(x).getLocation().compareTo(back)==0){	
		n++;
		adj.add(actors.get(x));
	    }
	}

        int r = (int) (Math.random() * n);
	Actor other = adj.get(r);
	setColor(other.getColor());

	}
	catch(Exception e){
	    return; //for when Location goes out of grid bounds	
	}
    }
}
