import java.io.IOException;
import PixelPrinter.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
            PixelPrinter pixelPrinter= new PixelPrinter("foto.ppm");
            Shader shader = (coord,r)->{
            var uv= Vec.scale(Vec.sub(Vec.scale(coord, 2.0),r),1.0/r.x);
           // Vec3 col = new Vec3(uv.y,uv.x,1);
            return new Vec3(1,1,0);         
          };
          pixelPrinter.print(shader,new Vec2(1000f,1000f));
    }
    
}

