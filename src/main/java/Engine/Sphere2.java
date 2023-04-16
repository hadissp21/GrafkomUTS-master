package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINE_STRIP;

public class Sphere2 extends Circle3d{
    float rZ;
    int stackCount;
    int sectorCount;

    public Sphere2(List<ShaderProgram.ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, ArrayList<Float> centerPoint, float rX, float rY, float rZ, int stackCount, int sectorCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.rZ = rZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createSphere2();
        //createHyperboloid1();
        //createHyperboloid2();
        //createEllipticCone();
        //createEllipticParaboloid();
        //createHyperboloidParaboloid();
        setupVAOVBO();
    }

    public Sphere2(List<ShaderProgram.ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, ArrayList<Float> centerPoint, float rX, float rY, float rZ, int stackCount, int sectorCount, int pilihan) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.rZ = rZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        if(pilihan == 1){
            createBox();
        }
        else if(pilihan == 2) {
            createSphere();
        }
        else if(pilihan == 3){
            createHyperboloid1();
        }
        else if(pilihan == 4){
            createHyperboloid2();
        }
        else if(pilihan == 5){
            createEllipticCone();
        }
        else if(pilihan == 6){
            createEllipticParaboloid();
        }
        else if(pilihan == 7){
            createHyperboloidParaboloid();
        }
        else if(pilihan == 8){
            createSphere2();
        }
        else if(pilihan == 9){
            createSphere3();
        }
        else if(pilihan == 10){
            createSphere4();
        }
        //createSphere();
        //createHyperboloid1();
        //createHyperboloid2();
        //createEllipticCone();
        //createEllipticParaboloid();
        //createHyperboloidParaboloid();
        setupVAOVBO();
    }

    public void createBox()
    {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        //titik 1 kiri atas belakang
        temp.x = (float)centerPoint.get(0) - rX/2;
        temp.y = (float)centerPoint.get(1) + rY/2;
        temp.z = (float)centerPoint.get(2) - rZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 2 kiri bawah belakang
        temp.x = (float)centerPoint.get(0) - rX/2;
        temp.y = (float)centerPoint.get(1) - rY/2;
        temp.z = (float)centerPoint.get(2) - rZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 3 kanan bawah belakang
        temp.x = (float)centerPoint.get(0) + rX/2;
        temp.y = (float)centerPoint.get(1) - rY/2;
        temp.z = (float)centerPoint.get(2) - rZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 4 kanan atas belakang
        temp.x = (float)centerPoint.get(0) + rX/2;
        temp.y = (float)centerPoint.get(1) + rY/2;
        temp.z = (float)centerPoint.get(2) - rZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 5 kiri atas depan
        temp.x = (float)centerPoint.get(0) - rX/2;
        temp.y = (float)centerPoint.get(1) + rY/2;
        temp.z = (float)centerPoint.get(2) + rZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 6 kiri bawah depan
        temp.x = (float)centerPoint.get(0) - rX/2;
        temp.y = (float)centerPoint.get(1) - rY/2;
        temp.z = (float)centerPoint.get(2) + rZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 7 kanan bawah depan
        temp.x = (float)centerPoint.get(0) + rX/2;
        temp.y = (float)centerPoint.get(1) - rY/2;
        temp.z = (float)centerPoint.get(2) + rZ/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 8 kanan atas depan
        temp.x = (float)centerPoint.get(0) + rX/2;
        temp.y = (float)centerPoint.get(1) + rY/2;
        temp.z = (float)centerPoint.get(2) + rZ/2;
        tempVertices.add(temp);


        vertices.clear();
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    public void createSphere(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/15){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/15){
                float x = this.rX * (float)(Math.cos(v) * Math.cos(u));
                float y = this.rY * (float)(Math.cos(v) * Math.sin(u));
                float z = this.rZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void createSphere2() {
        vertices.clear();

        for (float u = -180; u <= 180; u += 180 / 36) {
            for (float v = (-90); v <= 90; v += 180 / 36) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.x = (float) (this.rX * Math.cos(vRad) * Math.cos(uRad));
                temp_vector.z = (float) (this.rZ * Math.cos(vRad) * Math.sin(uRad));
                temp_vector.y = (float) (this.rY * Math.sin(vRad));
                vertices.add(temp_vector);
            }
        }
        for (float u = -180; u <= 180; u += 180 / 36) {
            for (float v = (-90); v <= 90; v += 180 / 36) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.y = (float) (this.rY * Math.cos(vRad) * Math.cos(uRad));
                temp_vector.z = (float) (this.rZ * Math.cos(vRad) * Math.sin(uRad));
                temp_vector.x = (float) (this.rX * Math.sin(vRad));
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphere3(){
        vertices.clear();

        for (float u = 180; u >= -180; u -= 180 / 30) {
            for (float v = 0; v <= 90; v += 180 / 30) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.x = (float) (this.rX * Math.cos(vRad) * Math.cos(uRad));
                temp_vector.z = (float) (this.rZ * Math.cos(vRad) * Math.sin(uRad));
                temp_vector.y = (float) (this.rY * Math.sin(vRad));
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphere4(){
        vertices.clear();

//        for (float u = 180; u >= -180; u -= 180 / 30) {
//            for (float v = -90; v <= 0; v += 180 / 30) {
//                Vector3f temp_vector = new Vector3f();
//                float uRad = (float) Math.toRadians(u);
//                float vRad = (float) Math.toRadians(v);
//                temp_vector.x = (float) (this.rX * Math.cos(vRad) * Math.cos(uRad));
//                temp_vector.z = (float) (this.rZ * Math.cos(vRad) * Math.sin(uRad));
//                temp_vector.y = (float) (this.rY * Math.sin(vRad));
//                vertices.add(temp_vector);
//            }
//        }
        for (float u = -180; u <= 180; u += 180 / 36) {
            for (float v = (-90); v <= 90; v += 180 / 36) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.x = (float) (this.rX * Math.cos(vRad) * Math.cos(uRad));
                temp_vector.z = (float) (this.rZ * Math.cos(vRad) * Math.sin(uRad));
                temp_vector.y = (float) (this.rY * Math.sin(vRad));
                vertices.add(temp_vector);
            }
        }
        for (float u = -180; u <= 180; u += 180 / 36) {
            for (float v = (-90); v <= 90; v += 180 / 36) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.y = (float) (this.rY * Math.cos(vRad) * Math.cos(uRad));
                temp_vector.z = (float) (this.rZ * Math.cos(vRad) * Math.sin(uRad));
                temp_vector.x = (float) (this.rX * Math.sin(vRad));
                vertices.add(temp_vector);
            }
        }
    }

    public void createHyperboloid1() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
                float y = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
                float z = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid2() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI / 2; u <= Math.PI / 2; u += Math.PI / 60) {
                float x = 0.5f * (float) ((Math.tan(v)) * Math.cos(u));
                float y = 0.5f * (float) ((Math.tan(v)) * Math.sin(u));
                float z = 0.5f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));

            }
        }
        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI / 2; u <= 4 * (Math.PI / 2); u += Math.PI / 60) {
                float x = -0.5f * (float) ((Math.tan(v)) * Math.cos(u));
                float y = -0.5f * (float) ((Math.tan(v)) * Math.sin(u));
                float z = -0.5f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));

            }
        }
        vertices = temp;

    }
    public void createEllipticCone() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        /*for(double v = 0; v<= 100; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=1){
                float x = 0.5f * (float)v * (float)(Math.cos(u));
                float y = 0.5f * (float)v * (float)((Math.sin(u)));
                float z = 0.5f * (float)v;
                temp.add(new Vector3f(x,z,y));
            }
        }*/
        for(double v = 0; v<= 100; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=1){
                float x = 0.5f * (float)u * (float)(Math.cos(v));
                float y = 0.5f * (float)u * (float)((Math.sin(v)));
                float z = 0.5f * (float)u;
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }
    public void createEllipticConev2() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (float u = -180; u <= 180; u += 180 / 36) {
            for (float v = (-90); v <= 90; v += 180 / 36) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.x = (float) (1 * vRad * Math.cos(uRad));
                temp_vector.z = (float) (1 * vRad * Math.sin(uRad));
                temp_vector.y = (float) (1 * vRad);
                vertices.add(temp_vector);
            }
        }
    }

    public void createEllipticConev3() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=0.01){
                float x = 0.5f * (float)v * (float)(Math.tan(u));
                float y = 0.5f * (float)v * (float)((1/Math.cos(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void createEllipticParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=0.01){
                float x = 0.5f * (float)v * (float)(Math.cos(u));
                float y = 0.5f * (float)v * (float)((Math.sin(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }

    public void createHyperboloidParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.01){
            for(double u = -Math.PI; u<= Math.PI; u+=0.666){
                float x = 0.125f * (float)v * (float)(Math.tan(u));
                float y = 0.25f * (float)v * (float)((1/Math.cos(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    /*
    public void createHyperboloidParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.01){
            for(double u = -Math.PI; u<= Math.PI; u+=0.666){
                float x = 0.125f * (float)v * (float)(Math.tan(u));
                float y = 0.25f * (float)v * (float)((1/Math.cos(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }*/

}

