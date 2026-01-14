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
    
}
