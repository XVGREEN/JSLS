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
         int rx= (int)resolution.x;
         int ry= (int)resolution.y;
         
         String header = "P6\n"+rx +" "+ry+"\n255\n";
         stream.write(header.getBytes()); 
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
        color.x= Math.min(color.x, 1f);
        color.y= Math.min(color.y, 1f);
        color.z= Math.min(color.z, 1f);
        buffer[pos]=(byte)(color.x*254f);
        buffer[pos+1]=(byte)(color.y*254f);
        buffer[pos+2]=(byte)(color.z*254f);
    }
    void printVideo(Shader shader,Vec2 r, float  seconds){
        
    }

}
