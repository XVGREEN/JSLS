import java.io.IOException;

import JLSL.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
            final Vec2 resolution = new Vec2(1368.,720.);
            VideoPrinter printer = new VideoPrinter("demo");

            Shader shader = (coord,r,time)->{
            var uv= Vec.scale(Vec.sub(Vec.scale(coord, 2.0),r),1.0/r.x);
            uv.y=-uv.y;
            float d = (Math.sin(uv.x*10.+time)*.5>uv.y)?1f:0;
            Vec3 col = new Vec3(d);
            return col;       
          };
          printer.printVideo(shader,resolution, 2f);
    }
    
}

