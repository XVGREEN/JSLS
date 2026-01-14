import java.io.IOException;
import PixelPrinter.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
            PixelPrinter pixelPrinter= new PixelPrinter("foto.ppm");
            Shader shader = (coord,r)->{
            var uv= Vec.scale(Vec.sub(Vec.scale(coord, 2.0),r),1.0/r.x);
            uv.y=-uv.y;
            float d = (Math.sin(uv.x)>uv.y)?1f:0;
            Vec3 col = new Vec3(d);
            return col;       
          };
          pixelPrinter.print(shader,new Vec2(1000f,1000f));
    }
    
}

