import java.util.*;

public class Sim
{
	private Vector<Astre> collection;
	private int X, Y, ZOOM;
	private boolean readable;
	private int ignores=1, REFRECH_RATE=10;
	private int POSX=500000, POSY=500000;
	private int MASSET=20, VITESSET=50, POST=2000;

	public Sim(int iX, int iY, int izoom)
	{
		X=iX;
		Y=iY;
		ZOOM=izoom;
		readable=true;
		collection = new Vector<Astre>();

		collection.addElement(new Astre("Soleil",0xffff00,POSX, POSY, (int)(MASSET*333000), 0, 0));
		collection.addElement(new Astre("Mercure",0x888888,POSX+(int)(POST*0.46), POSY, (int)(MASSET*0.055), 0, (int)(VITESSET*1.58)));//0,46UA 0,055MT 1,58vT
		collection.addElement(new Astre("Venus",0x00f0ff,POSX+(int)(POST*0.72), POSY, (int)(MASSET*0.815), 0, (int)(VITESSET*1.18)));//0,72UA 0,815MT 1,18vT
		collection.addElement(new Astre("Terre",0x0000ff,POSX+POST, POSY, MASSET, 0, VITESSET));//rapport masse terre lune 83
		collection.addElement(new Astre("Mars",0xff0000,POSX+(int)(POST*1.52), POSY, (int)(MASSET*0.11), 0, (int)(VITESSET*0.8)));//1,52UA 0,11MT 0,8vT
		collection.addElement(new Astre("Jupiter",0xff8800,POSX+(int)(POST*5.2), POSY, (int)(MASSET*317.8), 0, (int)(VITESSET*0.44)));//5,2UA 317,8MT 0,44vT
		collection.addElement(new Astre("Saturn",0x888800,POSX+(int)(POST*9.54), POSY, (int)(MASSET*95.15), 0, (int)(VITESSET*0.32)));//9,54UA 95,15MT 0,32vT
		collection.addElement(new Astre("Uranus",0x00f0ff,POSX+(int)(POST*19.22), POSY, (int)(MASSET*14.54), 0, (int)(VITESSET*0.23)));//19,22UA 14,54MT 0,23vT
		collection.addElement(new Astre("Neptune",0x0000ff,POSX+(int)(POST*30.1), POSY, (int)(MASSET*17.15), 0, (int)(VITESSET*0.18)));//30,1UA 17,15MT 0,18vT
		collection.addElement(new Astre("Pluton",0x666666,POSX+(int)(POST*39.44), POSY, (int)(MASSET*0.0022), 0, (int)(VITESSET*0.16)));//39,44UA 0,0022MT 0,16vT


/*		collection.addElement(new Astre("Terre",Color.blue,POSX, POSY, 10000, 0, 0));
		collection.addElement(new Astre("Autre",Color.red,POSX-2000, POSY, 10000, 0, 150));//1/83 de la masse terrestre
		collection.addElement(new Astre("Lune",Color.gray,POSX-1000, POSY, 10000, 0, 200));//1/83 de la masse terrestre
		//collection.addElement(new Astre("S3",Color.cyan,POSX-3500, POSY, 333000, 0, 45));
*/	}

	public void run()
	{
		readable=false;
		for (Astre objet1 : collection)
		{
			//Calcul avec influence de tous les autres astres
			/*for(Astre objet2 : collection){
				if(objet1!=objet2){
					objet1.Calcul(objet2);
				}
			}*/

			//Calcul avec l'influence du soleil seulement
			if(objet1!=collection.get(0))
			{
				objet1.Calcul(collection.get(0));
			}
		}
		for(Astre objet1 : collection)
		{
			objet1.Appliquer();
		}
		readable=true;
	}

	public int [] getScreen()
	{
		int screen[] = new int[X*Y];

		while(!readable)
		{
			try{Thread.sleep(10);} catch(Exception e){};
		}

		for(Astre objet1 : collection)
		{
			screen	[Math.abs((int)objet1.x / ZOOM % X)
					+
					(Math.abs((int)objet1.y / ZOOM % Y)*X)]
					= objet1.color;
		}
		return screen;
	}
}
