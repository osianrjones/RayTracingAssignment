package com.example.raytracingassignment;

public class Camera {

    static int x,y,z;
    static Vector origin = new Vector(x,y,z);

    public Camera (int x, int y, int z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }

    public static double getZ() {
        return z;
    }

    public boolean intersect(Sphere sphere, Vector direction, int height, int width, int j, int i) {

        double t; //The intersect point with the ray
        double t1;
        double t2;
        double a; //direction of ray ^ 2
        double b; //2vd
        double c; //v^2-r^2
        Vector p = new Vector(0, 0, 0); //p is a 3D point on the sphere
        Vector v; //A line from the centre of the sphere to the origin
        double col = 0.0;
        this.x = i - (width / 2); //x value of the origin
        this.y = j - (height / 2); //y value of the origin
        v = origin.sub(sphere.cs); //Calculate the vector of the origin to the centre of the sphere
        a = direction.dot(direction); //Calculate a
        b = 2 * v.dot(direction);  //Calculate b
        c = v.dot(v) - (sphere.radius * sphere.radius); //Calculate c
        double disc = (b * b) - (4 * a * c); //Calculate discriminant
        if (disc < 0) return false;
        return true;
    }

    public static Vector getOrigin() {

        return origin;
    }
}
