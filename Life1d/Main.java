public class Main
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int game_X=1024, game_Y=768, SPEED=20;
	static int screen_X=1024, screen_Y=768;
	static Game game;
	static Graphic graphic;
	static int regle=126;

	public static void main(String[] args)
	{
		graphic = new Graphic(screen_X,screen_Y,"Autmatate 1d", "-", "+");
		Reset();

		while (true)
		{
			try{Thread.sleep(SPEED);} catch(Exception e){};
			switch (graphic.getButton())
			{
				case 1:
					regle-=1;
					if(regle<0)regle=255;
					Reset();
				break;
				case 2:
					regle+=1;
					if(regle>255)regle=0;
					Reset();
				break;
			}
		}
	}

	static void Reset()
	{
		game = new Game(game_X,game_Y);
		graphic.setScreenFromBitmap(game.run(regle), game_X, game_Y);
		System.out.println("Regle numero "+regle);
	}
}
