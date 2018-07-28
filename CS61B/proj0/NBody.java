import java.util.Arrays;
public class NBody{
	/* Given a file name, it should return a double corresponding to the radius of the universe in that file*/
	public static String IMAGE_BG = "./images/starfield.jpg";

	public static double readRadius(String title){
		In in = new In(title);
		in.readDouble();
		return in.readDouble();
	}

	public static Planet[] readPlanets(String title){
		In in = new In(title);
		int n = in.readInt();
		double radius = in.readDouble();
		Planet[] planet = new Planet[n];
		int i = 0;

		while(i!=n){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planet[i] = new Planet (xPos,yPos,xVel,yVel,m,img);
			i++;
		}
		return planet;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double tTime = 0;

		/*Get r and planets data */
		double r = readRadius(filename);
		Planet[] planet = readPlanets(filename);

		/* Draw a background */
		StdDraw.setScale(-r, r);
		StdDraw.clear();
		StdDraw.picture(0, 0, IMAGE_BG);

		/*StdAudio.play("./audio/2001.mid");*/

		/* Draw planets */
		for (Planet p: planet){
			p.draw();
		}
		/* Enable double buffering. This is a graphics technique to prevent flickering in the animation. */
		StdDraw.enableDoubleBuffering();

		StdOut.printf("%d\n", planet.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planet.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planet[i].xxPos, planet[i].yyPos, planet[i].xxVel,
            planet[i].yyVel, planet[i].mass, planet[i].imgFileName);   
		}
		while(tTime<T){
			double[] xForces = new double[planet.length];
			double[] yForces = new double[planet.length];
			int i = 0;
			for (Planet p: planet){
				xForces[i] = p.calcNetForceExertedByX(planet);
				yForces[i] = p.calcNetForceExertedByY(planet);
				i+=1;
			}
			i=0;
			for (Planet p: planet){
				p.update(dt,xForces[i],yForces[i]);
				i+=1;
			}

			StdDraw.picture(0, 0, IMAGE_BG);
			for (Planet p: planet){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			tTime += dt;
		}

		/* Test */
		/*System.out.println(T);
		System.out.println(dt);
		System.out.println(filename);
		System.out.println(planet[2].xxPos);
		System.out.println(Arrays.toString(planet));*/

	}

}