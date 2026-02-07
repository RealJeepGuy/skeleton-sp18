

public class NBody {

    public static double readRadius(String filename){
        In in = new In (filename);
        int numOfPlanets = in.readInt();
        double radius =in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int numOfPlanets = in.readInt();
        double radius =in.readDouble();

        Planet[] planets = new Planet[numOfPlanets];
        for (int i = 0; i < numOfPlanets; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();

        double time = 0.0;
        while (time < T){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for (int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Planet p : planets){
                StdDraw.picture(p.xxPos, p.yyPos, "images/" + p.imgFileName);
            }

            StdDraw.show();
            StdDraw.pause(10);

            time += dt;
        }

    }

}