import java.util.*;

public class Main
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int sim_X=256, sim_Y=192, SPEED=20, ZOOM=100;
	static int screen_X=1024, screen_Y=768;

	static Sim sim;
	static Graphic graphic;
	static TimerTask tic;
	static Timer timer;

	static boolean pause=false;

	public static void main(String[] args)
	{
		graphic = new Graphic(screen_X,screen_Y,"Simulateur système solaire", "Reset", "Pause");
		Reset();

		TimerTask tic = new TimerTask()
		{
			@Override
			public void run()
			{
				graphic.setScreen(sim.getScreen(), sim_X, sim_Y);
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(tic, 20, 20);

		while (true)
		{
			if(pause)
			{
				try{Thread.sleep(1000);} catch(Exception e){};
			}
			else
			{
				sim.run();
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
		sim = new Sim(sim_X,sim_Y,ZOOM);
	}

	static public void Pause()
	{
		pause=!pause;
	}
}
