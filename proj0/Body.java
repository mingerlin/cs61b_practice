public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	};

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	};

	/** calculates the distance between two Bodys*/
	public double calcDistance(Body inputBody){
		double xDiff = this.xxPos - inputBody.xxPos;
		double yDiff = this.yyPos - inputBody.yyPos;
		return Math.sqrt(Math.pow(xDiff,2)+Math.pow(yDiff,2));
	};

	/** Calculates the force*/
	public double calcForceExertedBy(Body inputBody){
		if (this.equals(inputBody)) {
			return 0;
		}
		// double g = 6.67*(Math.pow(10,-11));
		double g = 6.67e-11;
		return (g*this.mass*inputBody.mass)/Math.pow(this.calcDistance(inputBody),2);
	};

	/** Calculates the force exerted by x*/
	public double calcForceExertedByX(Body inputBody){
		if (this.equals(inputBody)) {
			return 0;
		}
		double xDiff = inputBody.xxPos - this.xxPos;
		// if (xDiff < 0) {
		// 	xDiff=-xDiff;
		// }
		return this.calcForceExertedBy(inputBody)*xDiff/this.calcDistance(inputBody);
	};

	/** Calculates the force exerted by y*/
	public double calcForceExertedByY(Body inputBody){
		if (this.equals(inputBody)) {
			return 0;
		}
		double yDiff = inputBody.yyPos - this.yyPos;
		// if (yDiff < 0) {
		// 	yDiff=-yDiff;
		// }
		return this.calcForceExertedBy(inputBody)*yDiff/this.calcDistance(inputBody);
	};

	/** Take in an array of Bodys and calculates the net X */
	public double calcNetForceExertedByX(Body[] bodyArr){
		double toReturn=0;
		for (Body b : bodyArr) {
			toReturn+=this.calcForceExertedByX(b);
		}
		return toReturn;
	};

	/** Take in an array of Bodys and calculates the net Y */
	public double calcNetForceExertedByY(Body[] bodyArr){
		double toReturn=0;
		for (Body b : bodyArr) {
			toReturn+=this.calcForceExertedByY(b);
		}
		return toReturn;
	};

	/** Update the body's position and velocity instance variables */
	public void update(double dt, double fX, double fY){
		double aX = fX/this.mass;
		double aY = fY/this.mass;
		this.xxVel += dt*aX;
		this.yyVel += dt*aY;
		this.xxPos += dt*this.xxVel;
		this.yyPos += dt*this.yyVel;
	};

	/** Draw the Body’s image at the Body’s position*/
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	};
}




