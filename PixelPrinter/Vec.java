package PixelPrinter;
public class Vec {
    public static Vec2 add (Vec2 a,  Vec2 b){
        return new Vec2(a.x+b.x, a.y+b.y);
    }
    public static Vec2 sub (Vec2 a,  Vec2 b){
        return new Vec2(a.x-b.x, a.y-b.y);
    }
    public static double dot (Vec2 a,  Vec2 b){
        return (a.x*b.x+ a.y*b.y);
    }
    public static Vec2 scale(Vec2 a,double s){
        return new Vec2(a.x*s,a.y*s);
    }
    public static Vec3 scale(Vec3 a,double s){
        return new Vec3(a.x*s,a.y*s,a.z*s);
    }
    public static Vec2 fract(Vec2 v){
        return new Vec2(v.x-Math.floor(v.x),v.x-Math.floor(v.x));
    }
    public Vec3  fract(Vec3 v){
        return new Vec3(v.x-Math.floor(v.x),v.x-Math.floor(v.x),v.z-Math.floor(v.z));
    }
    public static double lerp(double a, double b, double t){
        return (a+b-a)*t;
    }
    public  static Vec2 mix(Vec2 a, Vec2 b,float t){
        return new Vec2(lerp(a.x,b.x,t),lerp(a.y,b.y,t));
    }
    
    public  static Vec3 mix(Vec3 a, Vec3 b,float t){
        return new Vec3(lerp(a.x,b.x,t),lerp(a.y,b.y,t),lerp(a.z,b.z,t));
    }
    
}
