import info.gridworld.actor.Bug;

public class CircleBug extends Bug
{
    private int steps;
    private int sideLength;

    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}
