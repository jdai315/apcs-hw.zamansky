import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import java.awt.Color;

public class Jumper extends Actor {
	
	public Jumper(){
		setColor(Color.RED);
	}	
	
	public Jumper(Color bugColor){
		setColor(bugColor);
	}

	public void act(){
		if (canJump()){
			jump();
		}else{
			turn();
		}
	}

	public void turn(){
		setDirection(getDirection() + 90);
	}
	
	public void jump(){
		Grid<Actor> gr = getGrid();
		if (gr == null)
		    	return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location jump = next.getAdjacentLocation(getDirection());
		if (gr.isValid(jump))
		    	moveTo(jump);
		else
		    	removeSelfFromGrid();
	}

	public boolean canJump(){
		Grid<Actor> gr = getGrid();
		if (gr == null)
		    	return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		if (! ( (neighbor==null) 
			|| (neighbor instanceof Flower) 
			|| (neighbor instanceof Rock)
		      ) 
		    )
			return false;

		Location jump = next.getAdjacentLocation(getDirection());
		if (!gr.isValid(jump))
		    	return false;
		neighbor = gr.get(jump);
		return (neighbor == null) || (neighbor instanceof Flower);
    }

}
