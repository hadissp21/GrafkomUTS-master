package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object2d extends ShaderProgram{

    List<Vector3f> vertices;
    int vao;
    int vbo;
    //BARU 02-20-2023
    UniformsMap uniformsMap;
    Vector4f color;
    int vboColor;
    List<Vector3f> verticesColor;
    //BARU 03-13-2023
    Matrix4f model;
    //BARU 03-20-2023
    private List<Object2d> childObject;
    private List<Float> centerPoint;
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        //BARU 02-20-2023
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        this.color = color;
        //BARU 03-12-2023
        uniformsMap.createUniform("model");
        //BARU 04-10-2023
        uniformsMap.createUniform("projection");
        uniformsMap.createUniform("view");
        //
        model = new Matrix4f().identity();
        setChildObject(new ArrayList<>());
    }

    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
        //BARU 02-20-2023
    }

    public void setupVAOVBO(){
        //setvao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //setvbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor(){ // BARU 02-20-2023
        //setvao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //setvbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        //setvboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup(Camera camera, Projection projection){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);

        uniformsMap.setUniform("view", camera.getViewMatrix());
        uniformsMap.setUniform("projection", projection.getProjMatrix());
        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupVerticesColor(){
        bind();
        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        //Bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
    }

    public void draw(Camera camera, Projection projection){
        drawSetup(camera, projection);
        //optional
        glLineWidth(1); //Ketebalan Garis
        glPointSize(1); // Ngatur besar kecile vertex
        //wajib
        //GL_LINE
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_POLYGON, 0, vertices.size());

        for(Object2d child : childObject){
            child.draw(camera, projection);
        }
    }

    public void drawLine(Camera camera, Projection projection){
        drawSetup(camera, projection);
        //optional
        glLineWidth(1); //Ketebalan Garis
        glPointSize(1); // Ngatur besar kecile vertex
        //wajib
        //GL_LINE
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());

        for(Object2d child : childObject){
            child.draw(camera, projection);
        }
    }

    public void addVertices(Vector3f newVertices){
        vertices.add(newVertices);
        setupVAOVBO();
    }
    public int getVerticesSize(){
        return vertices.size();
    }

    public void setVertices(int index, Vector3f newVector){
        vertices.set(index, newVector);
        setupVAOVBO();
    }

    public void drawVerticesColor(){
        drawSetupVerticesColor();
        //optional
        glLineWidth(0.01f); //Ketebalan Garis
        glPointSize(0); // Ngatur besar kecile vertex
        //wajib
        //GL_LINE
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }

    public void translateObject(float offsetX, float offsetY, float offsetZ){
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object2d child : childObject){
            child.translateObject(offsetX, offsetY, offsetZ);
        }
    }

    public void rotateObject(float degree, float x, float y, float z){
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
        for(Object2d child : childObject){
            child.rotateObject(degree, x, y, z);
        }
    }

    public void scaleObject(float scaleX, float scaleY, float scaleZ){
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
        for(Object2d child : childObject){
            child.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public List<Vector3f> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
    }

    public List<Vector3f> getVerticesColor() {
        return verticesColor;
    }

    public void setVerticesColor(List<Vector3f> verticesColor) {
        this.verticesColor = verticesColor;
    }
    public Matrix4f getModel(){
        return model;
    }

    public List<Object2d> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object2d> childObject) {
        this.childObject = childObject;
    }

    public List<Float> getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(List<Float> centerPoint) {
        this.centerPoint = centerPoint;
    }
}

