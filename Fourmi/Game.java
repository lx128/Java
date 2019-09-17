import java.util.*;

public class Game
{
	private int X, Y;
	private boolean board[][];
	private int pos_x, pos_y, orientation;

	public Game(int iX, int iY)
	{
		X=iX;
		Y=iY;
		orientation=3;
		pos_x=X/2;
		pos_y=Y/2;
		board= new boolean[X][Y];

		for(int x=0;x<X;x++)
		{
			for(int y=0;y<Y;y++)
   			{
    			board[x][y]=false;
			}
		}
	}

	public void run()
	{
		if (board[pos_x][pos_y])//case noire donc 90 à gauche
		{
			board[pos_x][pos_y]=!board[pos_x][pos_y];//changement de couleur de la case
			if(orientation==0)
			{
				orientation=3;
			}
			else
			{
				orientation-=1;//+90 degré
			}
		}
		else//case blanche donc 90 à droite
		{
			board[pos_x][pos_y]=!board[pos_x][pos_y];//changement de couleur de la case
			orientation+=1;//+90 degré
			orientation=orientation%4;
		}
		avance();
	}

	public boolean[][] getBoard()
	{
		return board;
	}

	private void avance()
	{
		switch (orientation)
		{
			case 0:
				if(pos_y==0)
				{
					pos_y=Y-1;
				}
				else
				{
					pos_y-=1;
				}
			break;
			case 1:
				if(pos_x+1==X)
				{
					pos_x=0;
				}
				else
				{
					pos_x+=1;
				}
			break;
			case 2:
				if(pos_y+1==Y)
				{
					pos_y=0;
				}
				else
				{
					pos_y+=1;
				}
			break;
			case 3:
				if(pos_x==0)
				{
					pos_x=X-1;
				}
				else
				{
					pos_x-=1;
				}
			break;
		}
	}
}
