import java.util.*;

public class Game
{
	int X, Y;
	boolean board[][];

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
//				board[x][y]=random.nextBoolean();
				board[x][y]=false;
			}
		}
	}

	public void run()
	{
		boolean[][] new_board= new boolean[X][Y];
		int cell_count=0;

		for(int comp_x=0;comp_x<X;comp_x++)
		{
			for(int comp_y=0;comp_y<Y;comp_y++)
			{
				//on compte les cellules autour
//					cell_count=this.cellCount(comp_x, comp_y);
				cell_count=this.cellCountBoucle(comp_x, comp_y);

				//on decide de la vie ou de la mort de la cellule du millieu
				//si elle est entouré de 2 à 3 cellules elle reste en vie.
				if(board[comp_x][comp_y])//déjà vivante
				{
						if (cell_count==2 || cell_count==3)//normal et variante high life
//					if (cell_count>2 && cell_count!=5)//variante day & night
//						if (cell_count==3 || cell_count==4)//variante life 3-4
					{
						new_board[comp_x][comp_y]=true;//vie
					}
				}
				//si elle est entouré de 3 cellules, naissance
				else//morte
				{
						if (cell_count==3)//normal
//						if (cell_count==3 || cell_count==6)//Variante high life
//					if (cell_count>2 && cell_count!=4 && cell_count!=5)//variante day & night
//						if (cell_count==3 || cell_count==4)//variante life 3-4
					{
						new_board[comp_x][comp_y]=true;//vie
					}
				}
			}
		}
		board=new_board;
	}

	public void mouseUpdatePos(int x, int y)
	{
		board[x][y]= !board[x][y];
	}

	public boolean [][] getBoard()
	{
		return board;
	}

	int cellCount(int comp_x, int comp_y)
	{
		int cell_count;
		cell_count=0;

		//on compte les cellules autour
		if (comp_x-1>=0)
		{
			if (comp_y-1>=0)
			{
				if(board[comp_x-1][comp_y-1])
				{
					cell_count++;
				}
			}
				if(board[comp_x-1][comp_y])
				{
					cell_count++;
				}
			if (comp_y+1<Y)
			{
				if(board[comp_x-1][comp_y+1])
				{
					cell_count++;
				}
			}
		}

		if (comp_y-1>=0)
		{
			if(board[comp_x][comp_y-1])
			{
				cell_count++;
			}
		}
		if (comp_y+1<Y)
		{
			if(board[comp_x][comp_y+1])
			{
				cell_count++;
			}
		}

		if (comp_x+1<X)
		{
			if (comp_y-1>=0)
			{
				if(board[comp_x+1][comp_y-1])
				{
					cell_count++;
				}
			}
				if(board[comp_x+1][comp_y])
				{
					cell_count++;
				}
			if (comp_y+1<Y)
			{
				if(board[comp_x+1][comp_y+1])
				{
					cell_count++;
				}
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
		if (comp_x-1==-1){comp_x2=X-1;}else{comp_x2=comp_x-1;}

		if (comp_y-1==-1){comp_y2=Y-1;}else{comp_y2=comp_y-1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count++;
			}
			if(board[comp_x2][comp_y])
			{
				cell_count++;
			}
		if (comp_y+1==Y){comp_y2=0;}else{comp_y2=comp_y+1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count++;
			}
		comp_x2=comp_x;




		if (comp_y-1==-1){comp_y2=Y-1;}else{comp_y2=comp_y-1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count++;
			}
		if (comp_y+1==Y){comp_y2=0;}else{comp_y2=comp_y+1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count++;
			}





		if (comp_x+1==X){comp_x2=0;}else{comp_x2=comp_x+1;}

		if (comp_y-1==-1){comp_y2=Y-1;}else{comp_y2=comp_y-1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count++;
			}
			if(board[comp_x2][comp_y])
			{
				cell_count++;
			}
		if (comp_y+1==Y){comp_y2=0;}else{comp_y2=comp_y+1;}
			if(board[comp_x2][comp_y2])
			{
				cell_count++;
			}
		return cell_count;
	}
}
