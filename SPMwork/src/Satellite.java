import javafx.scene.text.Text;


public class Satellite {
	String name = "";
	double a = 0;//Semiminor
	double b = 0;//Semimajor
	double c = 0;//True—anomaly
	Satellite(String name,double a,double b,double c){
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public boolean checkForCollison(Satellite other){
		double ab = a*other.b*other.b;
		double ba = other.a*b*b;
		double result = (ab-ba)/(ba*other.forE()-ab*forE());
		double fiveDays = 5*24*60*60;
		if(result>1 ||result<-1){
			return false;
		}else{
			double angle = Math.acos(result);
			for(int i = 0;i<=(int)(fiveDays/forT());i++){
				for(int l = 0;l<=(int)((fiveDays/other.forT()));l++){
					if(when_t_issame(angle,i)==other.when_t_issame(angle, l)){
						return true;
					}
				}
			}
		}
		return false;
	}
	public double when_t_issame(double angle,int i){
		return (angle+2*i*Math.PI-c)*Math.sqrt(a*a*a);
	}
	public double forT(){
		double a = this.a;
		return 2*3.14*Math.sqrt(a*a*a/(3.98*100000));
	}
	public double forE(){
		return  Math.sqrt(1-(this.b/this.a)*(this.b/this.a));
		//return this.a*(1-e*e)/(1+e*Math.cos(this.c*Math.PI/180));
	}
}
