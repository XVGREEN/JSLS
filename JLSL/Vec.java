package JLSL;
public class Vec {

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
        return new  Vec2(fract(uv.x), fract(uv.y));
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

    Vec2 mul (Mat2 m, Vec2 v){
        return new Vec2(m.x*v.x + m.y*v.y,
                        m.z*v.x + m.w*v.y);
    }
    public static Vec2 mul(Vec2 gv, Vec2 gv2) {
        return new Vec2(gv.x*gv2.x, gv.y*gv2.y);
    }
    public static Vec3 mix(Vec3 a, Vec3 b, double d) {
        return new Vec3(mix(a.x,b.x,d),mix(a.y,b.y,d),mix(a.z,b.z,d));
    }
    public static Vec3 mul(Vec3 color, double d) {
        return new Vec3(color.x*d, color.y*d, color.z*d);
    }
    public static Vec3 mul(Vec3 gv, Vec3 gv2) {
        return new Vec3(gv.x*gv2.x, gv.y*gv2.y, gv.z*gv2.z);
    }
    public static Vec2 Rot2D(Vec2 a,double angle){
        double c=Math.cos(angle);
        double s=Math.sin(angle);
        return new Vec2( a.x * c - a.y * s,
                         a.x * s + a.y * c);
    }
    public static Vec3 RotX(Vec3 v, double angle){
        double c=Math.cos(angle);
        double s=Math.sin(angle);
        return new Vec3(v.x,
                        v.y * c - v.z * s,
                        v.y * s + v.z * c);
    }
    public static Vec3 RotY(Vec3 v, double angle){
        double c=Math.cos(angle);
        double s=Math.sin(angle);
        return new Vec3( v.x * c + v.z * s,
                         v.y,
                        -v.x * s + v.z * c);
    }
    public static Vec3 RotZ(Vec3 v, double angle){
        double c=Math.cos(angle);
        double s=Math.sin(angle);
        return new Vec3( v.x * c - v.y * s,
                         v.x * s + v.y * c,
                         v.z);
    }
    public static Vec3 sub(Vec3 col, double sh) {
        return new Vec3(col.x - sh, col.y - sh, col.z - sh);
    }
    public static Vec2 add(Vec3 v, double t) {
        return new Vec2(v.x + t, v.y + t);
    }
}
