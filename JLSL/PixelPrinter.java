package JLSL;
import java.io.FileOutputStream;
import java.io.IOException;

public class PixelPrinter {
     final FileOutputStream stream; 
     public PixelPrinter(String file) throws IOException{
        stream=  new FileOutputStream(file);
     }

    public void print(Shader shader,Vec2 resolution,double time) throws IOException{
         byte buffer[]= new byte[(int)(resolution.x*resolution.y*3f)];
         int rx= (int)resolution.x;
         int ry= (int)resolution.y;
         
         String header = "P6\n"+rx +" "+ry+"\n255\n";
         stream.write(header.getBytes()); 
        for(float y=0;y<resolution.y;y++){
            for(float x=0;x<resolution.x;x++){
               Vec3 color= runShader(shader,new Vec2( x, y),resolution,time);
               int pos = (int)(y*resolution.x+x);
               pos*=3; 
               putColor(buffer,color, pos);

            }
        }
        stream.write(buffer);
        stream.close();
    }

    Vec3 runShader(Shader shader,Vec2 p,Vec2 r,double time){
       return shader.shade(p,r,time);
    }

    void putColor(byte[] buffer,Vec3 color, int pos){
        color.x= Jlsl.clamp(color.x, -1., 1.);
        color.y= Jlsl.clamp(color.y, -1., 1.);
        color.z= Jlsl.clamp(color.x, -1., 1.);
        buffer[pos]=(byte)(color.x*254f);
        buffer[pos+1]=(byte)(color.y*254f);
        buffer[pos+2]=(byte)(color.z*254f);
    }

}
