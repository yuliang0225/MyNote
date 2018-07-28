/*
You’ll start by creating a Planet class.
--------
Begin by creating a basic version of the Planet class with the following 6 instance variables:
--------
Planet class should NOT have a main method, because we’ll never run the Planet class directly

*/

public class Planet {
	/* Set parameters */
	/* Position parameters */
	public double xxPos;
	public double yyPos;
	/* Velocity paramters */
	public double xxVel;
	public double yyVel;
	/* Mass */
	public double mass;
	/* The name of the file that corresponds to the image that depicts the planet (for example, jupiter.gif) */
	public String imgFileName;
	public static double g = 6.67e-11;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass  = m;
		this.imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass  = p.mass;
		this.imgFileName = p.imgFileName;		
	}

	/* Calculates the distance between two Planets. */
	public double calcDistance(Planet p1){
		double dx = this.xxPos - p1.xxPos;
		double dy = this.yyPos - p1.yyPos;
		return Math.sqrt(dx*dx+dy*dy);
	}

	/* The calcForceExertedBy method takes in a planet, 
	   and returns a double describing the force exerted on this planet by the given planet. */
	public double calcForceExertedBy(Planet p1){
		double r = this.calcDistance(p1);
		return g*this.mass*p1.mass/(r*r);
	}


	/* These two methods describe the force exerted in the X and Y directions, respectively.  */
	public double calcForceExertedByX(Planet p1){
		return -1*this.calcForceExertedBy(p1)*(this.xxPos-p1.xxPos)/this.calcDistance(p1);
	}

	public double calcForceExertedByY(Planet p1){
		return -1*this.calcForceExertedBy(p1)*(this.yyPos-p1.yyPos)/this.calcDistance(p1);
	}

	/* Write methods calcNetForceExertedByX and calcNetForceExertedByY that each take in an array of Planets 
	   and calculate the net X and net Y force exerted by all planets in that array upon the current Planet. */
	public double calcNetForceExertedByX(Planet[] planets){
		double f_sum = 0;
		for (Planet p: planets){
			if (this == p){
				continue;
			}
			else{
				f_sum = f_sum+this.calcForceExertedByX(p);
			}
		}
		return f_sum;
	}
	public double calcNetForceExertedByY(Planet[] planets){
		double f_sum = 0;
		for (Planet p: planets){
			if (this == p){
				continue;
			}
			else{
				f_sum = f_sum+this.calcForceExertedByY(p);
			}
		}
		return f_sum;
	}
	/* Determines how much the forces exerted on the planet will cause that planet to accelerate, 
	   and the resulting change in the planet’s velocity and position in a small period of time dt.*/
	public void update(double time, double xF, double yF){

		double ax = xF/this.mass;
		double ay = yF/this.mass;

		this.xxVel = this.xxVel + ax*time;
		this.yyVel = this.yyVel + ay*time;

		this.xxPos = this.xxPos + this.xxVel*time;
		this.yyPos = this.yyPos + this.yyVel*time;
	}
	/* Draw a planet */
	public void draw (){
		String imgPath = "./images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, imgPath);
	}


}
