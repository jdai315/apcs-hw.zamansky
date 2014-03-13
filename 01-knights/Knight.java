import java.io.*;
import java.util.*;

class Knight {
    private int[][] board;
    private int steps = 0;
    private int me = 1;
    private boolean solved = false;

    public Knight(int side)
    {
	board = new int[side][side];
	steps = (side*side);
    }

    public String toString(){
	String ans = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] <10){
		    ans = ans + board[row][col] + "  ";
		}
		else{
		    ans = ans + board[row][col] + " ";
		}
	    } 
	    ans = ans + "\n";
	}
	return ans;
    }

    public void solve(int x, int y) {	
	if(!solved){
		try {
			if (board[x][y] == 0) {
				    board[x][y]= me++;
				    if(board[x][y] == steps){
					solved = true ;
					System.out.println("---HA I WIN---");
					System.out.println(this);
					System.out.println("HI WOOT CHESS IS DUMB\n");
					return;
				    }
				    solve(x+1, y+2);
				    if(!solved)
					solve(x-1, y+2);
				    if(!solved)
					solve(x+2, y-1);
				    if(!solved)
					solve(x+2, y+1);
			  	    if(!solved)
					solve(x-1, y-2);
				    if(!solved)
					solve(x+1, y-2);
				    if(!solved)
					solve(x-2, y+1);
				    if(!solved)
					solve(x-2, y-1);
			 	    board[x][y] = 0 ;
				    me--;
			}
		}
		catch (Exception a) {
		}
	}
    }

    public static void main(String[] args){
	Knight k = new Knight(5);
	k.solve(0,0);
	Knight p = new Knight(5);
	p.solve(1,3);
	Knight w = new Knight(6);
	w.solve(4,2);
	Knight r = new Knight(7);
	r.solve(3,6);
    }
}

