package PixelPrinter;
public interface Shader{
    //takes coord and resolution
    Vec3 shade(Vec2 coord,Vec2 res,double time);
}