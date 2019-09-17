
public class Molecule {

	int x, y, vitessex, vitessey, forcerep;
	public int limx=100, limy=100;

	Molecule(int ix, int iy, int iforcerep, int ivx, int ivy)
	{
		x = ix;
		y = iy;
		forcerep = iforcerep;
		vitessex = ivx;
		vitessey = ivy;
	}
	public void Calcul(Molecule m2) {
		double ax, by, c, d, e;
		double angle, g;
		// distance
		ax = (m2.x - x);
		by = (m2.y - y);
		// Théorème de Pythagore
		c = Math.hypot(ax, by);

		// Lois de Newton simplifié
		g = (double) (forcerep) / (double)Math.pow(c,2);

//		System.out.println(name+" "+g);
		// Répartition de gravité
//		g = (double) m2.masse / ((double) masse + (double) m2.masse) * g;

/*		// angle
		try {
			angle = Math.atan((double) by / (double) ax);
		} catch (Exception e) {
			angle = Math.PI;
			System.out.println("Div 0 Exception");
		}
		if (ax > 0 && by > 0) {
			angle += (Math.PI * 1.5);
		}
		if (ax < 0 && by > 0) {
			angle += Math.PI / 2;
		}
		if (ax < 0 && by < 0) {
			angle += Math.PI * 0.5;
		}
		if (ax > 0 && by < 0) {
			angle += Math.PI * 1.5;
		}
*/
		// Répartition de mouvement entre X et Y
		d = (
				(double) ax
				/ (Math.abs((double) ax) + Math.abs((double) by)) * g);
		vitessex += d;

		e = (
				(double) by
				/ (Math.abs((double) ax) + Math.abs((double) by)) * g);
		vitessey += e;

		System.out.println(ax+" "+by+" "+c);
		System.out.println(d+" "+e+" "+g);
	}
	public void Appliquer() {
		
//		if (x>0 & x<limx){x += vitessex;}
//		if (y>0 & y<limy){y += vitessey;}
x += vitessex;
y += vitessey;
	}
}
