import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame = new JFrame();

	private static final int RESX = 800, RESY = 600, ZOOM = 1;
	private static final int nb_objets=10, ignores=0, rafraichissement=500;
	static Molecule[] objets = new Molecule[nb_objets];
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
		b.setLocation(200, 0);
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

		g.setColor(Color.black);
		for(comp=0;comp<nb_objets;comp++){
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
		objets[0] = new Molecule(00, 00, 1000, 10, 0);
		objets[1] = new Molecule(10, 10, 1000, 50, 0);
		objets[2] = new Molecule(10, 20, 1000, 100, 0);
		objets[3] = new Molecule(10, 30, 1000, 0, 10);
		objets[4] = new Molecule(10, 40, 1000, 0, 20);
		objets[5] = new Molecule(10, 50, 1000, 0, 50);
		objets[6] = new Molecule(20, 10, 1000, 0, 100);
		objets[7] = new Molecule(20, 20, 1000, 0, 70);
		objets[8] = new Molecule(20, 30, 1000, 70, 0);
		objets[9] = new Molecule(20, 40, 1000, 50, 50);

/*		objets[0] = new Astre("S1",Color.yellow,POSX, POSY, 333000, 0, -2);
		objets[1] = new Astre("S2",Color.blue,POSX-2000, POSY, 333000, 0, 6);
		objets[2] = new Astre("S3",Color.cyan,POSX-3500, POSY, 333000, 0, 1);
*/
//		objets[0] = new Astre("S1",Color.yellow,POSX, POSY, 333000, 0, 0);
//		objets[1] = new Astre("S2",Color.blue,POSX-40000, POSY, 333000, 0, 500);
//		objets[2] = new Astre("S3",Color.cyan,POSX-6000, POSY, 333000, 0, 10);
	}}
