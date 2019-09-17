import java.util.*;

public class Game
{
	private int X, Y;
	private boolean board[][];

	private int cellCount(int comp_x, int comp_y)
	{
		int cell_count;
		cell_count=0;

		//on compte les cellules autour
			if (comp_x-1>=0)
			{
				if(board[comp_x-1][comp_y-1])
				{
					cell_count+=4;
				}
			}
				if(board[comp_x][comp_y-1])
				{
					cell_count+=2;
				}
			if (comp_x+1<X)
			{
				if(board[comp_x+1][comp_y-1])
				{
					cell_count+=1;
				}
			}
		return cell_count;
	}
	int cellCountBoucle(int comp_x, int comp_y)
	{
		int cell_count, comp_x2, comp_y2;
		cell_count=0;

		//on compte les cellules autour
		//univers boucle
		if (comp_y-1==-1){comp_y2=Y-1;}else{comp_y2=comp_y-1;}

		if (comp_x-1==-1){comp_x2=X-1;}else{comp_x2=comp_x-1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count+=4;
			}
			if(board[comp_x][comp_y2])
			{
				cell_count+=2;
			}
		if (comp_x+1==X){comp_x2=0;}else{comp_x2=comp_x+1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count+=1;
			}

		return cell_count;
	}

	public Game(int iX, int iY)
	{
		Random random = new Random();
		board= new boolean[iX][iY];

		X=iX;
		Y=iY;

		for(int x=0;x<X;x++)
		{
			for(int y=0;y<Y;y++)
   			{
    			board[x][y]=true;
    			if (x==(X/2) && y==0)
    			{
					board[x][y]=false;
				}
			}
		}
	}

	public boolean[][] run(int regle)
	{
		for(int comp_y=1;comp_y<Y;comp_y++)
		{
			for(int comp_x=0;comp_x<X;comp_x++)
			{
				//on compte les 3 cellules du dessus.
				//et on decide de la vie ou de la mort de la cellule
				board[comp_x][comp_y]=regle(this.cellCountBoucle(comp_x, comp_y),regle);
			}
		}
		return board;
	}

	private boolean regle(int cell_count, int nb_regle)
	{
		int res;

		res = nb_regle & (1 <<cell_count);

		if(res==0)
		{return true;}
		else
		{return false;}
	}
}
