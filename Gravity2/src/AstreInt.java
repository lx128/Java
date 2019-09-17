import java.awt.Color;

public class AstreInt {
	int x, y, vitessex, vitessey, masse;
	String name;
	Color color;

	AstreInt(String nam, Color col, int ix, int iy, int imasse, int ivx, int ivy) {
		// angle=Math.PI;
		color=col;
		name= nam;
		x = ix;
		y = iy;
		masse = imasse;
		vitessex = ivx;
		vitessey = ivy;
	}

	public void Calcul(AstreInt astre2) {
		int ax, by, c, d, e;
		double angle, g;
		// distance
		ax = (astre2.x - x);
		by = (astre2.y - y);
		// Théorème de Pythagore
		c = (int) Math.hypot(ax, by);

		// Lois de Newton
		g = (double) astre2.masse / (double)Math.pow(c,2);

		// Répartition de gravité
		g = (double) astre2.masse / ((double) masse + (double) astre2.masse) * g;

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
		d = (int) (
				(double) ax
				/ (Math.abs((double) ax) + Math.abs((double) by)) * g);
		vitessex += d;

		e = (int) (
				(double) by
				/ (Math.abs((double) ax) + Math.abs((double) by)) * g);
		vitessey += e;

//		System.out.println(ax+" "+by+" "+c);
//		System.out.println(name+" "+d+" "+e+" "+g);
	}

	public void Appliquer() {
		x += vitessex;
		y += vitessey;
	}
}
