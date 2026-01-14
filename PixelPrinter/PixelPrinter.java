package PixelPrinter;
import java.io.FileOutputStream;
import java.io.IOException;

public class PixelPrinter {
     final FileOutputStream stream; 
     public PixelPrinter(String file) throws IOException{
        stream=  new FileOutputStream(file);
     }

    public void print(Shader shader,Vec2 resolution) throws IOException{
         byte buffer[]= new byte[(int)(resolution.x*resolution.y*3f)];
         stream.write("P6\n100 50\n255\n".getBytes()); 
        for(float y=0;y<resolution.y;y++){
            for(float x=0;x<resolution.x;x++){
               Vec3 color= runShader(shader,new Vec2( x, y),resolution);
               int pos = (int)(y*resolution.x+x);
               pos*=3; 
               putColor(buffer,color, pos);

            }
        }
        stream.write(buffer);
        stream.close();
    }

    Vec3 runShader(Shader shader,Vec2 p,Vec2 r){
       return shader.shade(p,r);
    }

    void putColor(byte[] buffer,Vec3 color, int pos){
        buffer[pos]=(byte)(color.x*254f);
        buffer[pos+1]=(byte)(color.y*254f);
        buffer[pos+2]=(byte)(color.z*254f);
    }

}
