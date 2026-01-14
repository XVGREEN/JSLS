package JLSL;
class Util{
    static double step(double a, double b){
        return (a>b)?1.0:0.0    ;
    }
  static  double mod  (double x, double y){
        return x - y * Math.floor(x / y);
    }
   static Vec2 cos (Vec2 v){
        return new Vec2(Math.cos(v.x),Math.cos(v.y));
    }
    static Vec2 sin (Vec2 v){
        return new Vec2(Math.sin(v.x),Math.sin(v.y));
    }   
    static double clamp(double x, double a, double b){
        return Math.max(a, Math.min(b, x));
    }
    static double smoothstep(double a, double b, double t){
        return clamp(0.0, 1.0, (t - a) / (b - a));
    }

}