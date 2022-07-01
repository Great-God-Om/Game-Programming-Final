package finalgame.lib.GraphicsEngine;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

import finalgame.lib.Input.KeyHandler;
import finalgame.lib.Input.MouseHandler;

public class Renderer {
    public static int w_units = 15;
    public static int h_units = 0;
    public static GLWindow window = null;
    public static GLProfile glp;
    public static void init() {
        // Initialize OpenGL and GLWindow
        GLProfile.initSingleton();
        glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        window = GLWindow.create(caps);

        // Add event Handling
        window.addGLEventListener(new EventListener());
        window.addKeyListener(new KeyHandler());
        window.addMouseListener(new MouseHandler());

        // Window Configuration
        window.setSize(360, 420);
        window.setTitle("TITLE");
        window.setFullscreen(true);
        window.setVisible(true);
        window.requestFocus();
    }

    public static void render(){
        if(window == null){
            return;
        }
        window.display();
    }
}