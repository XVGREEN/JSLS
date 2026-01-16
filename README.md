# JLSL — Java‑Like Shader Language

JLSL is a lightweight library that brings **GLSL‑style programming** into pure Java. It gives you vector types, shader‑style math functions, and a functional rendering model — all without requiring OpenGL, Vulkan, or GPU shaders. If you’ve ever wanted to write shader code but stay entirely inside Java, JLSL is designed for you.


## 🌟 Why JLSL?

Traditional shader development requires:

- A GPU context  
- GLSL/HLSL compilation  
- Graphics APIs  
- Driver quirks  
- Boilerplate  

JLSL removes all of that. You write Java code that *feels* like a fragment shader, and JLSL evaluates it on the CPU. This makes it ideal for:

- Procedural animation  
- Generative art  
- Offline rendering  
- Teaching shader concepts  
- Experimenting with vector math  
- Building custom render pipelines  

It’s a tiny, expressive environment for shader‑style thinking.

---

## 🧩 Core Concepts

### **GLSL‑Inspired Types**
JLSL includes familiar types:

- `Vec2`, `Vec3`, `Vec4`
- Matrix types
- Utility functions like `dot`, `length`, `normalize`, `fract`, `mix`, `clamp`, etc.

This lets you write compact, expressive math code without reinventing vector operations.

---

### **Shader Interface**
A JLSL shader is simply a function:

```java
(coord, resolution, time) -> Vec3
```

It receives:

- Pixel coordinates  
- Screen resolution  
- Time (for animation)  

And returns a color.

This mirrors the structure of a fragment shader, but in Java.

---

### **Pixel‑Level Rendering**
JLSL includes a `PixelPrinter` class that evaluates your shader for every pixel and writes out an image. You can use this to generate:

- Frames  
- Procedural textures  
- Still images  
- Animation sequences  

---

### **Video Output**
The `VideoPrinter` class automates:

1. Rendering each frame  
2. Saving them as `.ppm` images  
3. Calling FFmpeg to assemble them into a video  
4. Cleaning up temporary files  

This gives you a complete offline rendering pipeline in just a few lines of code.

---

##  Example: Minimal Shader

```java
Shader shader = (coord, resolution, time) -> {
    var uv = Vec.div(Vec.sub(coord, Vec.scale(resolution, 0.5)), resolution.x);
    uv.y = -uv.y;

    double r = 0.5 + 0.5 * Math.sin(time + uv.x * 3.0);
    double g = 0.5 + 0.5 * Math.sin(time + uv.y * 3.0);
    double b = 0.5 + 0.5 * Math.sin(time);

    return new Vec3(r, g, b);
};
```

This is pure Java, but it reads like a fragment shader.

---

## 📦 Project Structure

| Component | Purpose |
|----------|---------|
| `Vec2`, `Vec3`, `Vec4` | Vector math utilities |
| `Shader` | Functional interface for per‑pixel evaluation |
| `PixelPrinter` | Renders a single frame |
| `VideoPrinter` | Renders an entire video |
| Math utilities | GLSL‑style functions for smooth, expressive code |

---

## ▶️ Running JLSL Projects

1. Add JLSL to your classpath.
2. Write a shader function.
3. Use `PixelPrinter` or `VideoPrinter` to render output.

Example:

```java
VideoPrinter printer = new VideoPrinter("demo");
printer.printVideo(shader, new Vec2(1280, 720), 3f);
```

This produces a 3‑second video at 60 FPS.

---

## 🌱 What You Can Build With JLSL

- Procedural animations  
- Generative art  
- Mathematical visualizations  
- Shader prototypes  
- Educational demos  
- Offline renderers  
- Custom shading pipelines  

If you know GLSL, you’ll feel at home.  
If you don’t, JLSL is a great way to learn.

