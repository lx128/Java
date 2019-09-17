public class AstreDouble {
	double x, y, vitessex, vitessey, masse;
	String name;
	int color;

	AstreDouble(String nam, int colori, double ix, double iy, double imasse, double ivx, double ivy) {
		// angle=Math.PI;
		color=colori;
		name= nam;
		x = ix;
		y = iy;
		masse = imasse;
		vitessex = ivx;
		vitessey = ivy;
	}

	public void Calcul(Astre astre2) {
		double ax, by, distance, d, e;
		double angle, g;


		// distance
		ax = astre2.x - x;
		by = astre2.y - y;
		// Théorème de Pythagore
		distance = Math.hypot(ax, by);

		// Lois de Newton simplifié
		//g subit par cet astre
		g = (astre2.masse) / Math.pow(distance,2);


		// Repartition de gravité ou part de g pour cet astre
		g = astre2.masse / (masse + astre2.masse) * g;
//		System.out.println(name+" "+g);

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
		// Repartition de mouvement entre X et Y
		d = (
				ax
				/ (Math.abs(ax) + Math.abs(by)) * g);
		vitessex += d;
		//System.out.println("vitesse x"+vitessex);
		//System.out.println("d x"+d);

		e = (
				 by
				/ (Math.abs(ax) + Math.abs(by)) * g);
		vitessey += e;

//		System.out.println(name+" "+ax+" "+by+" "+c);
//		System.out.println(d+" "+e+" "+g);
	}

	public void Appliquer() {
		x += vitessex;
		y += vitessey;
	}
}
