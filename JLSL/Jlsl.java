package JLSL;
public class Jlsl{
    //1D math
   public static double step(double a, double b){
        return (a>b)?1.0:0.0    ;
    }
    public static double fract ( double x){
        return x-Math.floor(x);
    }
    public  static  double mod  (double x, double y){
        return x - y * Math.floor(x / y);
    }
    public static double clamp(double x, double a, double b){
        return Math.max(a, Math.min(b, x));
    }
    public static double smoothstep(double a, double b, double t){
        return clamp(0.0, 1.0, (t - a) / (b - a));
    }

    public static double mix(double a, double b, double t){
        return a+(b-a)*t;
    }

    //2D math
   public static Vec2 cos (Vec2 v){
        return new Vec2(Math.cos(v.x),Math.cos(v.y));
    }
    public static Vec2 sin (Vec2 v){
        return new Vec2(Math.sin(v.x),Math.sin(v.y));
    }   
   
    public static Vec2 fract(Vec2 uv) {
        return new      Vec2(fract(uv.x), fract(uv.y));
    }
     public  static Vec2 mix(Vec2 a, Vec2 b,float t){
        return new Vec2(mix(a.x,b.x,t),mix(a.y,b.y,t));
    }


    //3D
    public Vec3  fract(Vec3 v){
        return new Vec3(v.x-Math.floor(v.x),v.x-Math.floor(v.x),v.z-Math.floor(v.z));
    }
    public  static Vec3 mix(Vec3 a, Vec3 b,float t){
        return new Vec3(mix(a.x,b.x,t),mix(a.y,b.y,t),mix(a.z,b.z,t));

    }
    //3D

}