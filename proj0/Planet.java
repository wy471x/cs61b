public class Planet {

    
    private static final double G = 6.67e-11;
    private static final String FILE_PREFIX = "images/";
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		return Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
	}

	public double calcForceExertedBy(Planet p) {
		double distance = calcDistance(p);
		return G * this.mass *  p.mass / (distance * distance);
	}

	public double calcForceExertedByX(Planet p) {
		double force = calcForceExertedBy(p);
		double distance = calcDistance(p);
		return force * (p.xxPos - this.xxPos) / distance; 
	}

	public double calcForceExertedByY(Planet p) {
		double force = calcForceExertedBy(p);
		double distance = calcDistance(p);
		return force * (p.yyPos - this.yyPos) / distance; 
		
	}

	public double calcNetForceExertedByX(Planet[] planets) {
		double sum = 0;
		for (Planet p : planets) {
			if (p != this) {
				sum += calcForceExertedByX(p);
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(Planet[] planets) {
		double sum = 0;
		for (Planet p : planets) {
			if (p != this) {
				sum += calcForceExertedByY(p);
			}
		}
		return sum;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / mass, aY = fY / mass;
		this.xxVel = this.xxVel + aX * dt;
		this.yyVel = this.yyVel + aY * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, FILE_PREFIX + imgFileName);
	}
}