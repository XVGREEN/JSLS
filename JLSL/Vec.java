package JLSL;
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

    public static Vec2 normal(Vec2 v){
        double l= length(v);
        return new Vec2(v.x/l,v.y/l);
    }

    public static Vec3 normal(Vec3 v){
        double l= length(v);
        return new Vec3(v.x/l,v.y/l,v.z/l);
    }
    public static Vec3 scale(Vec3 a,double s){
        return new Vec3(a.x*s,a.y*s,a.z*s);
    }
    
    public static double length(Vec2 v){
        return Math.sqrt(v.x*v.x+v.y*v.y);
    }
    public static double length(Vec3 v){    
        return Math.sqrt(v.x*v.x+v.y*v.y+v.z*v.z);
    }
    public static Vec3 add(Vec3 a, Vec3 b ) {
        return new Vec3(a.x+b.x,a.y+b.y,a.z+b.z);
    }
    public static Vec3 sub(Vec3 a, Vec3 b) {
       
        return new Vec3(a.x-b.x,a.y-b.y,a.z-b.z);
    }
    public static double dot(Vec3 n, Vec3 l) {
        return (n.x*l.x+n.y*l.y+n.z*l.z);
    }
}
