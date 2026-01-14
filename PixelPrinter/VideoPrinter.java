package PixelPrinter;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;;

public class VideoPrinter {
    String filename;
    public VideoPrinter(String filename){
        this.filename=filename;
    }
    public void printVideo(Shader shader,Vec2 resolution,float seconds) throws IOException{
        int frames = (int)seconds*60;
        int count=0;
        double time=0;
        double fps= 1.0/60;
        while(count<frames){
            PixelPrinter printer= new PixelPrinter("output\\"+count+".ppm");
            printer.print(shader, resolution,time);
            time+=fps;
            count++;
        }
        var bulider= new ProcessBuilder(
            "ffmpeg",
            "-framerate","60",
            "-start_number","0",
            "-i","%d.ppm"
            ,"out.mp4"          
        );
        bulider.directory( new File("output"));
        bulider.start();
        for(int i=0;i<frames;i++){
             Files.delete(Path.of("output/"+i+".ppm"));
        }
       
      

    }
    
}
