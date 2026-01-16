//THIS IS A DEMO ON HOW TO USE JLSL
import JLSL.*;
public class Main {
    private static final double MAX_DIST = 50.;
    private static final double MIN_DIST = 0.05;
    private static final int MAX_STEPS = 60;

   static double jump(double t){
        return -4.*t*t+4.*t;
    }
    //scene
    static Vec2 scene (Vec3 p, double time){
        double dist = p.y; 
        double mat = 1.;
        Vec3 spherePos= new Vec3( 0,0.5+jump(Vec.fract(time)),0);
        double d= Vec.length(Vec.sub(p,spherePos))-.5;
        if(d<dist){
            dist=d;
            mat=2.;
        }
        return new Vec2(dist, mat);
     }
    //raymarching
    static Vec2 march(Vec3 rd,Vec3 ro, double time){ 
            Vec2 dist = new Vec2(0, 1);
        for(int i=0;i<MAX_STEPS;i++){
            Vec3 p= Vec.add(ro,Vec.scale(rd,dist.x));
            Vec2 d = scene(p, time);
            dist.x+=d.x;
            dist.y= d.y;
            if(Math.abs(d.x)<MIN_DIST) break;
            if(dist.x>MAX_DIST) break;
        }
        return dist;
    }

    //getting surface normals
    static Vec3 calcNormal(Vec3 p,double time){
        final double h=0.005;
        double x= scene(Vec.add(p,new Vec3(h,0,0)),time).x-scene(Vec.add(p,new Vec3(-h,0,0)),time).x;
        double y= scene(Vec.add(p,new Vec3(0,h,0)),time).x-scene(Vec.add(p,new Vec3(0,-h,0)),time).x;
        double z= scene(Vec.add(p,new Vec3(0,0,h)),time).x-scene(Vec.add(p,new Vec3(0,0,-h)),time).x;
        return Vec.normal( new Vec3(x,y,z)); 
    }
    static float softShadow(Vec3 ro, Vec3 rd, float mint, float maxt, float k,double time){
        float res=1.0f;
        float t=mint;
        for(int i=0;i<32;i++){
            float h=(float)scene(Vec.add(ro,Vec.scale(rd,t)),time).x;
            if(h<0.001){
                return 0.0f;
            }
            res=Math.min(res,k*h/t);
            t+=h;
            if(t>maxt) break;
        }
        return res;
    }
    static Vec3 calcLight (Vec3 n, Vec3 l, Vec3 lc){
        float dif= Math.max(0f, (float)Vec.dot(n,l));
        return Vec.scale(lc,dif);
    }     
    public static void main(String[] args) throws Exception {
            final Vec2 resolution = new Vec2(1368.,720.);
            VideoPrinter printer = new VideoPrinter("demo");
            Shader shader = (coord,r,time)->{
                var uv= Vec.scale(Vec.sub(Vec.scale(coord, 2.0),r),1.0/r.x);
                uv.y=-uv.y;
                Vec3 ro = new Vec3 (0,1,-3);
                Vec3 rd= Vec.normal(new Vec3(uv.x,uv.y,1));
                Vec2 dist= march(rd,ro,time);
                Vec3 p= Vec.add(ro,Vec.scale(rd, dist.x));
                Vec3 col=new Vec3(.3);
                Vec3 lc= Vec.normal(new Vec3(1,1,0));
                if(dist.x<MAX_DIST){
                    var ld = Vec.normal(new Vec3(.3,.3,-.6)); 
                    ld= Vec.RotY(ld, .5);
                    var normal=calcNormal(p,time);
                    Vec3 light= calcLight(normal,ld,lc);
                    col= Vec.add(getMat(p,dist.y),light);
                    double sh= softShadow(Vec.add(p,Vec.scale(normal,0.05)),ld,0.05f,10f,32f,time );
                    col= Vec.scale(col,sh*.3+.4f);
                }
            return  col;  
          };
     
          printer.printVideo(shader,resolution, 3f);
       
    }
    private static Vec3 getMat(Vec3 p, double y) {
         Vec3 color= new Vec3(0.9,0.9,0.9);
         if(y>.5){
            color= new Vec3(0.2,0.2,0.8);
         }
         if (y>1.5) {
           color= new Vec3(0.4,0.2,0.2);   
         }
         return color;
    }

    
}

