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

public class MainPlanet {
    private Window window =
            new Window(800, 800, "Rumah");


    public void run() {
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init() {
        window.init();
        GL.createCapabilities();
        // code dst jangan ditaruh diatas code diatas
        camera.setPosition(0, 0, 1.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(1.0f));

        //Matahari
        TTSRY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.5f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)), 0.2f, 0.2f, 0.2f, 15, // Stack -->
                30 // Sector --> Titik
        ));
        TTSRY.get(0).scaleObject(0.8f,0.8f,0.8f);
        TTSRY.get(0).translateObject(0.0f,0.0f,0.0f);

        //Merkurius
        TTSRY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30 // Sector --> Titik
        ));
        TTSRY.get(1).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(1).translateObject(0.3f,0.0f,0.0f);

        //Venus
        TTSRY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.913f, 0.313f, 0.0549f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30 // Sector --> Titik
        ));
        TTSRY.get(2).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(2).translateObject(0.5f,0.0f,0.0f);
        //Bumi
        TTSRY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30 // Sector --> Titik
        ));
        TTSRY.get(3).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(3).translateObject(0.7f,0.0f,0.0f);
        //Mars
        TTSRY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.8f, 0.0f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30 // Sector --> Titik
        ));
        TTSRY.get(4).scaleObject(0.35f,0.35f,0.35f);
        TTSRY.get(4).translateObject(0.9f,0.0f,0.0f);
        //Bulan
        TTSRY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.5f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30 // Sector --> Titik
        ));
        TTSRY.get(5).scaleObject(0.175f,0.175f,0.175f);
        TTSRY.get(5).translateObject(0.7f,0.15f,0.0f);

//        TTSRY.add(new Sphere2(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                ),
//                new Vector4f(1.0f, 1f, 0.0f, 1.0f),
//                0.00,
//                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
//                0.125f,
//                0.125f,
//                0.125f,
//                15, // Stack -->
//                30 // Sector --> Titik))
//        ));
////        TTSRY.get(6).translateObject(0.5f, 0.5f, 0.5f);
//
//        TTSRY.get(0).getChildObject().add(new Sphere2(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                ),
//                new Vector4f(0.0f, 1f, 0.0f, 1.0f),
//                0.00,
//                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
//                0.125f,
//                0.125f,
//                0.125f,
//                15, // Stack -->
//                30 // Sector --> Titik))
//        ));
//        TTSRY.get(0).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.5f);
//        TTSRY.get(0).getChildObject().get(0).translateObject(0.225f, 0.0f, 0.0f);
//
//
//        TTSRY.get(0).getChildObject().add(new Sphere2(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                ),
//                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
//                0.00,
//                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
//                0.125f,
//                0.125f,
//                0.125f,
//                15, // Stack -->
//                30 // Sector --> Titik))
//        ));
//        TTSRY.get(0).getChildObject().get(1).scaleObject(0.7f, 0.7f, 0.7f);
//        TTSRY.get(0).getChildObject().get(1).translateObject(0.5f, 0.0f, 0.0f);
//
//        TTSRY.get(0).getChildObject().get(1).getChildObject().add(new Sphere2(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                ),
//                new Vector4f(1.0f, 1f, 1.0f, 1.0f),
//                0.00,
//                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
//                0.125f,
//                0.125f,
//                0.125f,
//                15, // Stack -->
//                30 // Sector --> Titik))
//        ));
//        TTSRY.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.2f, 0.2f, 0.2f);
//        TTSRY.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.5f, 0.15f, 0.0f);
    }

    boolean cek = false;
    boolean drag = false;
    int noHold = 0;

    boolean collisionFree = true;
    double jarak;
    ArrayList<Sphere2> TTSRY = new ArrayList<>();
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    Camera camera = new Camera();
    public void input() {

        List<ShaderProgram.ShaderModuleData> shader = Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData(
                        "resources/scene.frag", GL_FRAGMENT_SHADER)
        );

        /*
        0 = Matahari
        1 = Merkurius
        2 = Venus
        3 = Bumi
        4 = Mars
        5 = Bulan
         */
        if(window.isKeyPressed(GLFW_KEY_F)){
            TTSRY.get(1).rotateObject((float) Math.toRadians(0.5f),0.0f,0.001f,1.25f);
            TTSRY.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,0.001f,0.75f);
            TTSRY.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0.001f,1.0f);
            TTSRY.get(4).rotateObject((float) Math.toRadians(0.5f),0.0f,0.001f,1.25f);
            TTSRY.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0.001f,1.f);
        }
        if(window.isKeyPressed(GLFW_KEY_G)){

            TTSRY.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            Vector3f p1 = TTSRY.get(0).getModel().transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            TTSRY.get(1).translateObject(-p1.x, -p1.y, 0f);
            TTSRY.get(1).rotateObject((float) Math.toRadians(0.5f),1.0f,0.0f,0.0f);
            TTSRY.get(1).translateObject(p1.x, p1.y, 0f);
            TTSRY.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            TTSRY.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            TTSRY.get(4).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
            TTSRY.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.0f);
        }
        if(window.isKeyPressed(GLFW_KEY_H)){
            Vector3f moon = TTSRY.get(3).getModel().transformPosition(new Vector3f(0.0f,0.0f,0f));
            TTSRY.get(5).translateObject(-moon.x,-moon.y,0f);
            TTSRY.get(5).rotateObject((float) Math.toRadians(0.8f),0f,0f,1f);
            TTSRY.get(5).translateObject(moon.x,moon.y,0f);
            camera.moveForward(0.00000001f);
            TTSRY.get(0).rotateObject((float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
        }

        if(window.isKeyPressed(GLFW_KEY_E)){
            camera.moveBackwards(0.001f);
        }

        if(window.isKeyPressed(GLFW_KEY_W)){
//            countdegree++;
//            TTSRY.get(0).rotateObject();
        }
    }
    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(0.00f, 0.0f, 0.0f, 0.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();
            for (Sphere2 object : TTSRY) {
                object.draw(camera, projection);
            }
            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }


    public static void main (String[]args){
        new MainPlanet().run();
    }
}


