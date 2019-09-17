import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.IOException;
import java.net.URI;
import java.util.*;

public class Main extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame();

	private static final int RESX = 800, RESY = 600, ZOOM = 100;
	private static final int nb_objets=10, ignores=0, rafraichissement=2;
	private static final int POSX=500000, POSY=500000;
	private static final int MASSET=20, VITESSET=49, POST=2000;
	static Astre[] objets = new Astre[nb_objets];
	static java.awt.Button b= new java.awt.Button("Reset");

	public static void main(String[] args) {

		InitObj();

		b.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Reset();
				}
			}
		);
		b.setVisible(true);
		b.setLocation(0, 0);
		b.setSize(50, 30);
		frame.add(b);

		frame.setTitle("GravitySim");
		frame.getContentPane().add(new Main());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(RESX+20, RESY+20);
		frame.setVisible(true);

		TimerTask tic = new TimerTask() {
			@Override
			public void run() {
				int comp,comp2;

				for(comp=ignores;comp<nb_objets;comp++){
					for(comp2=0;comp2<nb_objets;comp2++){
						if(comp!=comp2){
							objets[comp].Calcul(objets[comp2]);
						}
					}
				}
				for(comp=ignores;comp<nb_objets;comp++){
					objets[comp].Appliquer();
				}

			frame.repaint();
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(tic, 0, rafraichissement);
	}

	public void paint(Graphics g) {
		int comp;

		for(comp=0;comp<nb_objets;comp++){
			g.setColor(objets[comp].color);
			g.fillOval(Math.abs((int)objets[comp].x / ZOOM % RESX),
					Math.abs((int)objets[comp].y / ZOOM % RESY), 10, 10);
		}
	}

	static public void Reset(){
		int comp;
		//marque les anciens objets à recycler
		for(comp=0;comp<nb_objets;comp++){
			objets[comp]=null;
		}
		InitObj();
	}

	public static void InitObj(){
		objets[0] = new Astre("Soleil",Color.yellow,POSX, POSY, (int)(MASSET*333000), 0, 0);//rapport masse terre lune 81
		objets[1] = new Astre("Terre",Color.blue,POSX+POST, POSY, MASSET, 0, VITESSET);//rapport masse terre soleil 333000
//		objets[2] = new Astre("Venus",Color.cyan,POSX+(int)(POST*0.72), POSY, (int)(MASSET*0.72), 0, (int)(VITESSET*1.18));//0,72UA 0,815MT 1,18vT
		objets[2] = new Astre("venus",Color.cyan,POSX+(int)(POST*0.72), POSY, (int)(MASSET*317.8), 0, (int)(VITESSET*1.18));//5,2UA 317,8MT 0,44vT
		objets[3] = new Astre("Mercure",Color.gray,POSX+(int)(POST*0.46), POSY, (int)(MASSET*0.055), 0, (int)(VITESSET*1.58));//0,46UA 0,055MT 1,58vT
		objets[4] = new Astre("Mars",Color.red,POSX+(int)(POST*1.52), POSY, (int)(MASSET*0.11), 0, (int)(VITESSET*0.8));//1,52UA 0,11MT 0,8vT
		objets[5] = new Astre("Jupiter",Color.orange,POSX+(int)(POST*5.2), POSY, (int)(MASSET*317.8), 0, (int)(VITESSET*0.44));//5,2UA 317,8MT 0,44vT
		objets[6] = new Astre("Saturn",Color.yellow,POSX+(int)(POST*9.54), POSY, (int)(MASSET*95.15), 0, (int)(VITESSET*0.32));//9,54UA 95,15MT 0,32vT
		objets[7] = new Astre("Uranus",Color.blue,POSX+(int)(POST*19.22), POSY, (int)(MASSET*14.54), 0, (int)(VITESSET*0.23));//19,22UA 14,54MT 0,23vT
		objets[8] = new Astre("Neptune",Color.cyan,POSX+(int)(POST*30.1), POSY, (int)(MASSET*17.15), 0, (int)(VITESSET*0.18));//30,1UA 17,15MT 0,18vT
		objets[9] = new Astre("Pluton",Color.gray,POSX+(int)(POST*39.44), POSY, (int)(MASSET*0.0022), 0, (int)(VITESSET*0.16));//39,44UA 0,0022MT 0,16vT

/*		objets[0] = new Astre("S1",Color.yellow,POSX, POSY, 333000, 0, -2);
		objets[1] = new Astre("S2",Color.blue,POSX-2000, POSY, 333000, 0, 6);
		objets[2] = new Astre("S3",Color.cyan,POSX-3500, POSY, 333000, 0, 1);
*/
//		objets[0] = new Astre("S1",Color.yellow,POSX, POSY, 333000, 0, 0);
//		objets[1] = new Astre("S2",Color.blue,POSX-40000, POSY, 333000, 0, 500);
//		objets[2] = new Astre("S3",Color.cyan,POSX-6000, POSY, 333000, 0, 10);
	}
}
