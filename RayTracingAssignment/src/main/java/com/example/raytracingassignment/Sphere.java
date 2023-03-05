package com.example.raytracingassignment;

public class Sphere {
    Vector cs;
    double radius;
    double r;
    double g;
    double b;
    double col;
    int x;
    int y;
    int z;
    private final String sphereName;
    public  double lowestShade = 999;
    public boolean canSeeSpheres = false;

    public Sphere(int x, int y, int z, double r, double g, double b, double radius, String sphereName) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
        cs = new Vector(x, y, z);
        if ((r <= 1) && (g <= 1) && (b <= 1)) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
        this.sphereName = sphereName;
    }

    public Vector centreOfSphere() {
        return cs;
    }

    public double getRadius() {
        return radius;
    }

    public void intersect(Vector origin, Vector Light, Vector direction, int height, int width, int j, int i) {

        double t; //The intersect point with the ray
        double t1;
        double t2;
        double a; //direction of ray ^ 2
        double b; //2vd
        double c; //v^2-r^2
        Vector p = new Vector(0, 0, 0); //p is a 3D point on the sphere
        Vector v; //A line from the centre of the sphere to the origin

        origin.x = i - Camera.getX(); //x value of the origin
        origin.y = j - Camera.getY(); //y value of the origin
        origin.z = Camera.getZ();//z value of the origin

        v = origin.sub(cs); //Calculate the vector of the origin to the centre of the sphere
        a = direction.dot(direction); //Calculate a
        b = v.dot(direction) * 2;  //Calculate b
        c = ((v.dot(v) - (this.radius * this.radius))); //Calculate c
        double disc = (b * b) - (4 * a * c); //Calculate discriminant
        if (disc < 0) this.col = 0.0;
            else {
                this.col = 1.0;
            }
            t1 = (-b+Math.sqrt(disc) / 2 * a);
            t2 = (-b-Math.sqrt(disc) / 2 * a);
            t = Math.min(t1, t2);
            p = origin.add(direction.mul(t));
            Vector LightVector = Light.sub(p);
            LightVector.normalise();
            Vector n = p.sub(this.cs);
            n.normalise();
            double shade = LightVector.dot(n);

            if (shade < 0) {
                this.col = 0;
            }
             else {
                 this.col = shade;
            }
             if (this.col < 0.4) {
                 this.col = 0.4;

             }
        if (this.col < lowestShade) {
            lowestShade = this.col;
        }

        }

    public double getCol() {
        return this.col;
    }

    public String getSphereName() {
        return this.sphereName;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void updateR(double r) {
        this.r = r;
    }
    public void updateG(double g) {
        this.g = g;
    }
    public void updateB(double b) {
        this.b = b;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setZ(int z) {
        this.z = z;
    }


}
