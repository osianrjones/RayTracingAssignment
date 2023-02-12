package com.example.raytracingassignment;

public class Sphere {
    Vector cs;
    double radius;
    double r;
    double g;
    double b;
    double col;
    public Sphere(int x, int y, int z, double r, double g, double b, double radius) {
        this.radius = radius;
        cs = new Vector(x, y , z);
        if ((r <= 1) && (g <= 1) && (b <= 1)) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
    public Vector centreOfSphere() {
        return cs;
    }
    public double getRadius() {
        return radius;
    }
    public double intersect(Vector origin, Vector Light, Vector direction, int height, int width, int j, int i) {
        double t; //The intersect point with the ray
        double a; //direction of ray ^ 2
        double b; //2vd
        double c; //v^2-r^2
        Vector p = new Vector(0,0,0); //p is a 3D point on the sphere
        Vector v; //A line from the centre of the sphere to the origin
        double col = 0.0;
        origin.x = i-(width/2); //x value of the origin
        origin.y = j-(height/2); //y value of the origin
        origin.z = -500; //z value of the origin
        v = origin.sub(cs); //Calculate the vector of the origin to the centre of the sphere
        a = direction.dot(direction); //Calculate a
        b = 2*v.dot(direction);  //Calculate b
        c = v.dot(v) - this.radius*this.radius; //Calculate c
        double disc = b * b - 4*a*c; //Calculate discriminant
        if (disc > 0) {
            t = (-b-Math.sqrt(disc))/2 * a; //Intersect point as double value\
        } else {
            t = 0;
        }
        //r = l −2(n·l)n
        p = origin.add(direction.mul(t)); //Vector at point t
        Vector Lv = Light.sub(p); //Light vector from origin to intersect
        Lv.normalise(); //Normalise within range
        Vector n = p.sub(cs); //Surface normal vector perpendicular to the surface tangent at any time, used when moving sphere
        n.normalise();
        double dp = Lv.dot(n);
        if (dp < 0) col = 0;
        else col = dp;
        if (dp > 1) col = 1;
        this.col = col;
        return col;
        /**
        double lightSphereIntersect = Lv.dot(n); //Calculate where the light hits the sphere
        if (lightSphereIntersect<0) return 0; //If negative, background hit
        else col = lightSphereIntersect; //else colour is the dp
        if (col>1) col=1; //Keep within range of 0-1.
        return col;
        */
    }
    public double getCol() {
        return this.col;
    }
}
