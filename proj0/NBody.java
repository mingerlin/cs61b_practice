public class NBody{

	/** Return a double corresponding to the radius of the universe in that file*/
	public static double readRadius(String filename){
		In in = new In(filename);
		in.readInt();
		return in.readDouble();
	};

	/** Return an array of Bodys corresponding to the bodies in the file*/
	public static Body[] readBodies(String filename){
		In in = new In(filename);
		int numPlanets = in.readInt();
		double radius = in.readDouble();
		Body[] bodyArr = new Body[numPlanets];
		for (int i=0; i<numPlanets; i++) {
			Body tempBody = new Body(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
			bodyArr[i] = tempBody;
		}
		return bodyArr;
	};

	/** Drawing the Initial Universe State*/
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Body[] bodyArr = readBodies(filename);
		double radius = readRadius(filename);

		StdDraw.setScale(-radius, radius); // set scale of the universe
		// StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg"); // draw the image starfield.jpg as the background
		for (Body b: bodyArr) {
			b.draw();
		}

		StdDraw.enableDoubleBuffering();
		// StdDraw.show();

		int time = 0;
		while (time <= T){
			double[] xForces = new double[bodyArr.length];
			double[] yForces = new double[bodyArr.length];
			for (int i = 0; i < bodyArr.length; i++) {
				xForces[i] = bodyArr[i].calcNetForceExertedByX(bodyArr);
				yForces[i] = bodyArr[i].calcNetForceExertedByY(bodyArr);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for (int i = 0; i < bodyArr.length; i++) {
				bodyArr[i].update(dt, xForces[i], yForces[i]);
				bodyArr[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time+=dt;
		}
		/** Print out the final state*/
		StdOut.printf("%d\n", bodyArr.length);
		StdOut.printf("%.2e\n", readRadius(filename));
		for (int i = 0; i < bodyArr.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  bodyArr[i].xxPos, bodyArr[i].yyPos, bodyArr[i].xxVel,
		                  bodyArr[i].yyVel, bodyArr[i].mass, bodyArr[i].imgFileName);   
			}
		}
	
}


