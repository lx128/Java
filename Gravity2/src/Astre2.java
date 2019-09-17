import java.awt.Color;

public class Astre2 {
	int x,y,vitessex, vitessey,masse,rayon;
	String name;
	Color color;

	Astre2(String nam, Color col, int ix, int iy, int imasse, int ivx, int ivy) {
		color=col;
		name= nam;
		x = ix;
		y = iy;
		masse = imasse;
		vitessex = ivx;
		vitessey = ivy;
		rayon=10;
	}

	public void Calcul(Astre2 astre2) {
		int ax, by, c, d, e;
		double g;
		// distance
		ax = (astre2.x - x);
		by = (astre2.y - y);
		// Théorème de Pythagore
		c = (int) Math.hypot(ax, by);

		// Lois de Newton
		g = (double)astre2.masse / (double)Math.pow(c,2);

		// Répartition de gravité
		g = (double)astre2.masse / ((double)masse + (double)astre2.masse) * g;
//		g = (double) astre2.masse / (double)Math.pow(c, 2);

		// Répartition de mouvement entre X et Y
		d = (int) ((double)ax/ (Math.abs((double) ax) + Math.abs((double) by)) * g);
		vitessex += d;

		e = (int) ((double)by/ (Math.abs((double) ax) + Math.abs((double) by)) * g);
		vitessey += e;

		System.out.println(name+" "+ax+" "+by+" "+c);
		System.out.println(d+" "+e+" "+g);
	}

	public void Appliquer() {
		x += vitessex;
		y += vitessey;
	}
}
