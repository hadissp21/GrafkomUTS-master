import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
public class coba {
    private Window window =
            new Window(800, 800, "Project");

    public void run() {
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    Projection projection = new Projection(window.getWidth(), window.getHeight());
    Camera camera = new Camera();
    ArrayList<Sphere2> pY = new ArrayList<>();
    ArrayList<Sphere2> pZ = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();
        // code dst jangan ditaruh diatas code diatas
        camera.setPosition(0, 0.0f, 3f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));


        //ISI CODINGAN
        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f, 0.3f, 0.15f,
                30, 15, 1
        ));
        pY.get(0).translateObject(0.0f, 0.18f, 0.0f);
    }

    public void input() {
        List<ShaderProgram.ShaderModuleData> shader = Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData(
                        "resources/scene.frag", GL_FRAGMENT_SHADER)
        );

        //ISI COMMENT MAU APA AJA
        if(window.isKeyPressed(GLFW_KEY_G)){
            Vector3f cek = pY.get(0).getModel().transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            if(cek.y <= 0.15f && cek.y >= -0.1f){
                pY.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -0.5f);
            }
            else{
                pY.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 0.5f);
            }

        }
        if(window.isKeyPressed(GLFW_KEY_H)){
            camera.moveBackwards(0.002f);
        }
    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(0.152f, 0.96f, 0.235f, 1.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();
//            for (Sphere2 object : TTSRY) {
//                object.draw(camera, projection);
//            }
            for(Sphere2 obj : pY){
                obj.draw(camera, projection);
            }
            for(Sphere2 obj : pZ){
                obj.drawLine(camera, projection);
            }
            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new coba().run();
    }
}
