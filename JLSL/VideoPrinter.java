package JLSL;
import java.io.File;
import java.nio.file.*;;

public class VideoPrinter {
    String filename;
    public VideoPrinter(String filename){
        this.filename=filename;
    }
    public void printVideo(Shader shader,Vec2 resolution,float seconds) throws Exception{
        int frames = (int)seconds*60;
        int count=0;
        double time=0;
        double fps= 1.0/60;
        while(count<frames){
          PixelPrinter printer = new PixelPrinter(
        String.format("output/%04d.ppm", count)
);

            printer.print(shader, resolution,time);
            time+=fps;
            count++;
        }
        var builder= new ProcessBuilder(
            "ffmpeg",
            "-framerate","60",
            "-start_number","0",
            "-i", "%04d.ppm"
            ,"out.mp4"          
        );
        builder.directory( new File("output"));
        builder.inheritIO();        
        Process process = builder.start();
        int exitcode= process.waitFor();
        if(exitcode==0){
           for(int i=0;i<frames;i++){
                 Files.deleteIfExists(Path.of(  String.format("output/%04d.ppm", i)));
           }
        }else{
            System.out.println("error");
        }
    }
    
}
