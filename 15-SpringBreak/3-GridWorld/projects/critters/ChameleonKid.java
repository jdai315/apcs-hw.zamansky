//Exercise #2

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.ChameleonCritter.java;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter{
    //instance variables
    Location front,back;
    private static final double DARKENING_FACTOR;

    //front and back only
    public void processActors(ArrayList<Actor> actors){
	front = getAdjacentLocation(getDirection());
	back = front + HALF_CIRCLE ;
	if( (getGrid().get(front) == null)&&(getGrid().get(back) == null)){
	    Color c = getColor();
	    int red = (int) (c.getRed() 

}