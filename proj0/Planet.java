

public class Planet {

    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public static final double G = 6.67e-11;


    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return G * this.mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * dx / r;
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double netForceX = 0.0;
        for (Planet p : planets){
            if (this != p){
                netForceX += this.calcForceExertedByX(p);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double netForceY = 0.0;
        for (Planet p : planets){
            if (this != p){
                netForceY += this.calcForceExertedByY(p);
            }
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;

        this.xxVel = this.xxVel + ax * dt;
        this.yyVel = this.yyVel + ay * dt;

        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }







}