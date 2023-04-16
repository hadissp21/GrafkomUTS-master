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
public class MainProject {
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
    ArrayList<Sphere2> pY = new ArrayList<>(); //YOEL
    ArrayList<Sphere2> pZ = new ArrayList<>(); //ENVIRONMENT

    public void init() {
        window.init();
        GL.createCapabilities();
        // code dst jangan ditaruh diatas code diatas
        camera.setPosition(0, 0.0f, 2f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(3.0f));


        //ISI CODINGAN
        //YOEL
        //BADAN
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
                0.15f, 0.25f, 0.15f,
                30, 15, 1
        ));
        pY.get(0).translateObject(0.0f, 0.18f, 0.0f);

        //WAJAH
        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f, 0.2f, 0.2f,
                30, 15, 8
        ));
        pY.get(1).translateObject(0.0f, 0.5f, 0.0f);

        //MATA1
        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.03f, 0.03f, 0.03f,
                30, 15, 8
        ));
        pY.get(2).translateObject(-0.08f, 0.5f, 0.18f);

        //MATA2
        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.03f, 0.03f, 0.03f,
                30, 15, 8
        ));
        pY.get(3).translateObject(0.08f, 0.5f, 0.18f);

        //BAHU1
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
                0.08f, 0.08f, 0.08f,
                30, 15, 9
        ));
        pY.get(4).translateObject(0.08f, 0.24f, 0.0f);

        //BAHU2
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
                0.08f, 0.08f, 0.08f,
                30, 15, 9
        ));
        pY.get(5).translateObject(-0.08f, 0.24f, 0.0f);

        //BAWAH
        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f, 0.05f, 0.15f,
                30, 15, 1
        ));
        pY.get(6).translateObject(0.0f, 0.03f, 0.0f);

        //KAKI1
        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 1.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.075f, 0.15f, 0.1f,
                30, 15, 1
        ));
        pY.get(7).translateObject(-0.035f, -0.07f, 0.0f);

        //KAKI2
        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.075f, 0.15f, 0.1f,
                30, 15, 1
        ));
        pY.get(8).translateObject(0.039f, -0.07f, 0.0f);

        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.0375f, 0.0375f, 0.0375f,
                30, 15, 10
        ));
        pY.get(9).translateObject(-0.034f, -0.14f, 0.0f);

        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.0375f, 0.0375f, 0.0375f,
                30, 15, 10
        ));
        pY.get(10).translateObject(0.036f, -0.14f, 0.0f);

        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 1.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f, 0.2f, 0.1f,
                30, 15, 1
        ));
        pY.get(11).translateObject(-0.105f, 0.13f, 0.0f);

        pY.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f, 0.2f, 0.1f,
                30, 15, 1
        ));
        pY.get(12).translateObject(0.105f, 0.13f, 0.0f);

        pZ.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                0.5,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.5f, 0.5f, 0.5f,
                30, 15, 1
        ));
        pZ.get(0).translateObject(0.7f, 0.0f, -2f);
    }

    public void input() {
        List<ShaderProgram.ShaderModuleData> shader = Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData(
                        "resources/scene.frag", GL_FRAGMENT_SHADER)
        );

        //ISI COMMENT MAU APA AJA
        if(window.isKeyPressed(GLFW_KEY_F)){
//            pY.get(1).rotateObject((float) Math.toRadians(0.5f),1f,0.0f,0.0f);
            Vector3f head = pY.get(1).getModel().transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            pY.get(2).translateObject(-head.x, -head.y, 0.0f);
            pY.get(3).translateObject(-head.x, -head.y, 0.0f);
            pY.get(2).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(3).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(2).translateObject(head.x, head.y, 0.0f);
            pY.get(3).translateObject(head.x, head.y, 0.0f);
//            camera.moveForward(0.001f);
        }
        if(window.isKeyPressed(GLFW_KEY_G)){
//            camera.moveBackwards(0.01f);
            Vector3f body = pY.get(0).getModel().transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            pY.get(1).translateObject(-body.x, -body.y, 0.0f);
            pY.get(2).translateObject(-body.x, -body.y, 0.0f);
            pY.get(3).translateObject(-body.x, -body.y, 0.0f);
            pY.get(4).translateObject(-body.x, -body.y, 0.0f);
            pY.get(5).translateObject(-body.x, -body.y, 0.0f);
            pY.get(6).translateObject(-body.x, -body.y, 0.0f);
            pY.get(7).translateObject(-body.x, -body.y, 0.0f);
            pY.get(8).translateObject(-body.x, -body.y, 0.0f);
            pY.get(9).translateObject(-body.x, -body.y, 0.0f);
            pY.get(10).translateObject(-body.x, -body.y, 0.0f);
            pY.get(11).translateObject(-body.x, -body.y, 0.0f);
            pY.get(12).translateObject(-body.x, -body.y, 0.0f);
            pY.get(0).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(1).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(2).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(3).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(4).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(5).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(6).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(7).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(8).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(9).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(10).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(11).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(12).translateObject(0.001f, 0.0f, 0.0f);
            pY.get(1).translateObject(body.x, body.y, 0.0f);
            pY.get(2).translateObject(body.x, body.y, 0.0f);
            pY.get(3).translateObject(body.x, body.y, 0.0f);
            pY.get(4).translateObject(body.x, body.y, 0.0f);
            pY.get(5).translateObject(body.x, body.y, 0.0f);
            pY.get(6).translateObject(body.x, body.y, 0.0f);
            pY.get(7).translateObject(body.x, body.y, 0.0f);
            pY.get(8).translateObject(body.x, body.y, 0.0f);
            pY.get(9).translateObject(body.x, body.y, 0.0f);
            pY.get(10).translateObject(body.x, body.y, 0.0f);
            pY.get(11).translateObject(body.x, body.y, 0.0f);
            pY.get(12).translateObject(body.x, body.y, 0.0f);
        }
        if(window.isKeyPressed(GLFW_KEY_H)){
            Vector3f body = pY.get(0).getModel().transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            pY.get(4).translateObject(-body.x, -body.y, 0.0f);
            pY.get(5).translateObject(-body.x, -body.y, 0.0f);
            pY.get(6).translateObject(-body.x, -body.y, 0.0f);
            pY.get(7).translateObject(-body.x, -body.y, 0.0f);
            pY.get(8).translateObject(-body.x, -body.y, 0.0f);
            pY.get(9).translateObject(-body.x, -body.y, 0.0f);
            pY.get(10).translateObject(-body.x, -body.y, 0.0f);
            pY.get(11).translateObject(-body.x, -body.y, 0.0f);
            pY.get(12).translateObject(-body.x, -body.y, 0.0f);
            pY.get(4).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(5).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(6).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(7).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(8).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(9).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(10).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(11).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(12).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1f, 0.0f);
            pY.get(4).translateObject(body.x, body.y, 0.0f);
            pY.get(5).translateObject(body.x, body.y, 0.0f);
            pY.get(6).translateObject(body.x, body.y, 0.0f);
            pY.get(7).translateObject(body.x, body.y, 0.0f);
            pY.get(8).translateObject(body.x, body.y, 0.0f);
            pY.get(9).translateObject(body.x, body.y, 0.0f);
            pY.get(10).translateObject(body.x, body.y, 0.0f);
            pY.get(11).translateObject(body.x, body.y, 0.0f);
            pY.get(12).translateObject(body.x, body.y, 0.0f);

            pZ.get(0).translateObject(0.0f, 0.0f, 0.001f);
            camera.moveLeft(0.001f);
        }
        if(window.isKeyPressed(GLFW_KEY_I)){
//            pY.get(1).rotateObject((float) Math.toRadians(0.5f),1f,0.0f,0.0f);
            Vector3f head = pY.get(1).getModel().transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            pY.get(2).translateObject(-head.x, -head.y, 0.0f);
            pY.get(3).translateObject(-head.x, -head.y, 0.0f);
            pY.get(2).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            pY.get(3).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            pY.get(2).translateObject(head.x, head.y, 0.0f);
            pY.get(3).translateObject(head.x, head.y, 0.0f);
//            camera.moveForward(0.001f);
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
        new MainProject().run();
    }
}
