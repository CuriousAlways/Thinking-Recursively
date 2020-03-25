/***************************************************************************** 
   Recursive program to solve maze
   maze -> 2D char array to represent a maze
   notations : 
   #    -> wall
   ' '  -> corridor/path
   +    -> traversed path
   S    -> start position (alway assumed [0,0])
   F    -> Final position
*****************************************************************************/

// import java.util.Scanner;

public class MazeSolver
{
	public static void main(String[] args)
	{				    // 0   1   2   3   4   5
		char[][] maze = {{'S','#','#','#',' ','F'},//0
					     {' ','#',' ','#',' ',' '},//1
					     {' ',' ',' ',' ',' ',' '},//2
					     {'#','#',' ','#',' ','#'},//3
					     {'#',' ','#','#',' ',' '},//4
					     {'#',' ',' ','#',' ',' '},//5
					     {'#',' ',' ',' ',' ','#'},//6
					    };
		System.out.println("-------------- Maze ----------------\n");
		printMaze(maze);


		boolean solved = solveMaze(maze);
		if(solved) //solved maze successfully
		{
			System.out.println("\n------------------- Maze Solved ---------------------");
			printMaze(maze);
		}
		else
		{
			System.out.println("\n------------------- Reached Dead End -----------------");
			printMaze(maze);//overloaded function to provide cleaner interface to client
		}

	    
	}

	public static boolean solveMaze(char[][] maze)
	{
		return solveMaze(maze,0,0); 
	}

	private static boolean solveMaze(char[][] maze,int currentRow,int currentColumn)
	{
		if(maze[currentRow][currentColumn]=='#' || maze[currentRow][currentColumn]=='+')//a deadend or loop
			return false;
		if(maze[currentRow][currentColumn]=='F')//reached destination
			return true;

		else
		{
			maze[currentRow][currentColumn] = '+';

			//moves each direction
			if((currentRow+1 >= 0) && (currentRow+1<maze.length) && solveMaze(maze,currentRow+1,currentColumn))//move right
			{
				return true;
			}
			//right move invalid then move down
			if((currentColumn+1 >= 0) && (currentColumn+1<maze[currentRow].length) && solveMaze(maze,currentRow,currentColumn+1))
			{
				return true;
			}
			//right and down move invalid then move left
			if((currentRow-1 >= 0) && (currentRow-1<maze.length) && solveMaze(maze,currentRow-1,currentColumn))
			{
				return true;
			}
			//rigth,down and left are invalid move then move up
			if((currentColumn-1 >= 0) && (currentColumn-1<maze[currentRow].length) && solveMaze(maze,currentRow,currentColumn-1))
			{
				return true;
			}

			//if moves in all four direction are invalid then backtrack by restoring current cell value and return to previous cell(automatically taken care by recursion) 
			maze[currentRow][currentColumn] = ' ';

		}
		return false;
	}


	public static void printMaze(char[][] maze) //prints maze
	{
		for(int row=0;row<maze.length;row++)
		{
			for(int column=0;column<maze[row].length;column++)
				System.out.print("|"+maze[row][column]);
			System.out.println("|");
		}
	}
}