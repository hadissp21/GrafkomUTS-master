package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle3d extends Object2d {
    List<Float> centerPoint;
    Float rX;
    Float rY;
    public Circle3d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX,Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.rX = radiusX;
        this.rY = radiusY;
        setupVAOVBO();
    }

    public Circle3d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }

    public Circle3d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList, vertices, verticesColor);
    }

    public double degToRad(float degree){
        return (degree * Math.PI / (float) 180);
    }
    public void createCircle(){
        vertices.clear();
        for(float i = 0;i<360;i+=0.1){
            double rad = degToRad(i);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*rX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*rY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
        }
    }
    public void createRectangle(){
        vertices.clear();
        int degree = 45;
        for(float i = 0;i<4;i++){
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*rX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*rY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
            degree+=90;
        }
    }
    public void createTriangle(){
        vertices.clear();
        int degree = 90;
        for(float i = 0;i<3;i++){
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*rX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*rY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
            if(degree == 90){
                degree += 135;
            }
            else{
                degree += 90;
            }
        }
    }
//    public void draw(){
//        drawSetup();
//        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
//    }

    public List<Float> getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(List<Float> centerPoint) {
        this.centerPoint = centerPoint;
    }
}