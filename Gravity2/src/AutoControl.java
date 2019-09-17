
public class AutoControl {
	int mesure;
	private int gmax,max_correction,mesure_old,correction;

	AutoControl(int g){
		gmax=g;
		mesure=0;
	}

	void run(int consigneH, int consigneG){
		//test si la consigne G n'est pas trop brutale
		if(consigneG>gmax){
			consigneG=gmax;
		}

		//test si la précédente correction n'est pas trop brutale
		if(Math.abs(mesure-mesure_old)>=gmax){
			max_correction=max_correction*((mesure-mesure_old)/gmax);
		}

		//test si besoin de correction
		correction=consigneH-mesure;

		if(correction<0){
			
		}
		else if(correction>0){
			
		}

		//Application
		mesure_old=mesure;
		mesure+=correction*2;
	}

	void perturbation(int p){
		mesure+=p;
	}
}
