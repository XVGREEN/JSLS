//THIS IS A DEMO ON HOW TO USE JLSL
import JLSL.*;
public class Main {
    private static final double MAX_DIST = 50.;
    private static final double MIN_DIST = 0.01;
    private static final int MAX_STEPS = 40;

    //scene
    static double scene (Vec3 p){
        return Vec.length(p)-.5;
    }
    //raymarching
    static double march(Vec3 rd,Vec3 ro){
       
        float t=0;
        for(int i=0;i<MAX_STEPS;i++){
            Vec3 p= Vec.add(ro,Vec.scale(rd,t));
            double d = scene(p);
            t+=d;
            if(d<MIN_DIST) break;
            if(t>MAX_DIST) break;
        }
        return t;
    }

    //getting surface normals
    static Vec3 getNormal(Vec3 p){
        double h=0.01;
        double x= scene(Vec.add(p,new Vec3(h,0,0)))-scene(Vec.sub(p,new Vec3(-h,0,0)));
        double y= scene(Vec.add(p,new Vec3(0,h,0)))-scene(Vec.sub(p,new Vec3(0,-h,0)));
        double z= scene(Vec.add(p,new Vec3(0,0,h)))-scene(Vec.sub(p,new Vec3(0,0,-h)));
        return Vec.normal( new Vec3(x,y,z)); //normalize later
    }
    static Vec3 light (Vec3 n, Vec3 l){
        return new Vec3(Vec.dot(n, l));
    } 
    
    
    public static void main(String[] args) throws Exception {
            final Vec2 resolution = new Vec2(1368.,720.);
            VideoPrinter printer = new VideoPrinter("demo");
            PixelPrinter img_pr= new PixelPrinter("raydemo.ppm");
            Shader shader = (coord,r,time)->{
                var uv= Vec.scale(Vec.sub(Vec.scale(coord, 2.0),r),1.0/r.x);
                uv.y=-uv.y;
                Vec3 ro = new Vec3 (0,1,-3);
                Vec3 rd= Vec.normal(new Vec3(uv.x,uv.y,1));
                double dist= march(rd,ro);
                Vec3 p= Vec.add(ro,Vec.scale(rd, dist));
                Vec3 col=new Vec3(.3);
                if(dist<MAX_DIST){
                    var n=getNormal(p);
                    Vec3 l= light(n,Vec.normal(new Vec3(.3,.3,.1)));
                    col=  n;
                }
            return col;       
          };
          //printer.printVideo(shader,resolution, 5f);
          img_pr.print(shader, resolution, 0);
    }
    
}

