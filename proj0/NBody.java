import java.util.List;
import java.util.ArrayList;

public class NBody {
	public static double readRadius(String path) {
		In in = new In(path);
		in.readInt();
		return in.readDouble();
	}

	public static Planet[] readPlanets(String path) {
		In in = new In(path);
		int planetNum = in.readInt();
		in.readDouble();
		List<Planet> planetList = new ArrayList();
		int i = 0;
		while (i < planetNum) {
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			Planet planet = new Planet(xPos, yPos, xVel, yVel, mass, img);
			planetList.add(planet);
			i++;

		}
		Planet[] planets = new Planet[planetList.size()];
		return planetList.toArray(planets);
	}

	public static void main(String[] args) {
		// collecting all needed input
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		// drawing the background and drawing all of the planets
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for (Planet planet : planets) {
			planet.draw();
		}

		// creating an animation
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while (time <= T) {
			double[] xForces = new double[planets.length], yForces = new double[planets.length];
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (Planet planet : planets) {
				planet.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}

		StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
	}
}