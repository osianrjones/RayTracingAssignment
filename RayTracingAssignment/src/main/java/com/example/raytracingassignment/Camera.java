package com.example.raytracingassignment;

public class Camera {

    private static double x,y,z;
    static Vector origin = new Vector(x,y,z);
    static Vector LookAt = new Vector(0,0,0);
    static Vector VPN;
    static Vector VRV;
    static Vector VUV = new Vector(0,1,0);



    public Camera (int x1, int y1, int z1) {
        x = x1;
        y = y1;
       z = z1;

        VPN = LookAt.sub(origin);
        VPN.normalise();


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

    public static void updateX(double x1) {
        x = x1;
    }
    public static void updateY(double y1) {
        y = y1;
    }
    public static void updateZ(double z1) {
        z = z1;
    }

    public boolean intersect(Sphere sphere, Vector direction, int height, int width) {
        if ((sphere.cs.x > -width && sphere.cs.x < width) && (sphere.cs.y > -height && sphere.cs.y < height)
                && (sphere.cs.z > Camera.z)) {
            return true;
        }
        return false;
    }

    public static Vector getOrigin() {

        return origin;
    }
}
