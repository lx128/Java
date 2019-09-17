import java.util.*;

public class Main
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static boolean pause=false;

	static int game_X=256, game_Y=192, SPEED=1;
	static int screen_X=1024, screen_Y=768;
	static Game game;
	static Graphic graphic;
	static TimerTask tic;
	static Timer timer;

	public static void main(String[] args)
	{
		graphic = new Graphic(screen_X, screen_Y,"Fourmi de Langton", "Reset", "Pause");
		game = new Game(game_X,game_Y);

		tic = new TimerTask()
		{
			@Override
			public void run()
			{
				graphic.setScreenFromBitmap(game.getBoard(), game_X, game_Y);
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(tic, 20, 20);

		while (true)
		{
			if(pause)
			{
				try{Thread.sleep(1000);} catch(Exception e){};
			}
			else
			{
				game.run();
				try{Thread.sleep(SPEED);} catch(Exception e){};
			}

			switch (graphic.getButton())
			{
				case 1:
					Reset();
				break;
				case 2:
					Pause();
				break;
			}
		}
	}

	static public void Reset()
	{
		game = new Game(game_X, game_Y);
	}

	static public void Pause()
	{
		pause=!pause;
	}
}
