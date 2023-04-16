package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends Circle2{
    float radiusZ;
    int stackCount;
    int sectorCount;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, float radiusZ, int sectorCount, int stackCount, int pilihan) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        if (pilihan == 1){
            createBox();
        }
        else if(pilihan == 2){
            createSphere();
        }
        else if(pilihan == 3){
            createSphere2();
        }
        else if(pilihan == 4){
            createSphere3();
        }
        else{
            createSphere4();
        }
        setupVAOVBO();

    }

    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //0
        temp.x = (getCenterPoint().get(0) - radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) + radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) - radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();
        //1
        temp.x = (getCenterPoint().get(0) + radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) + radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) - radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();
        //2
        temp.x = (getCenterPoint().get(0) + radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) - radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) - radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();
        //3
        temp.x = (getCenterPoint().get(0) - radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) - radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) - radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();
        //4
        temp.x = (getCenterPoint().get(0) - radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) + radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) + radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();
        //5
        temp.x = (getCenterPoint().get(0) + radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) + radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) + radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();
        //6
        temp.x = (getCenterPoint().get(0) + radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) - radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) + radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();
        //7
        temp.x = (getCenterPoint().get(0) - radiusX / 2.0f);
        temp.y = (getCenterPoint().get(1) - radiusY / 2.0f);
        temp.z = (getCenterPoint().get(2) + radiusZ / 2.0f);
        tempVertices.add(temp);
        temp = new Vector3f();



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
        float pi = (float) Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, stackAngle, x, y, z;

        for(float u = -180; u <= 180; u+= 180/36){
            for(float v = (-90); v <= 90; v+= 180/36){
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.z = (float) (1 * Math.cos(vRad) * Math.cos(uRad));
                temp_vector.y = (float) (1 * Math.cos(vRad) * Math.sin(uRad));
                temp_vector.x = (float) (1 * Math.sin(vRad));
                vertices.add(temp_vector);
            }
        }

        for(float u = -180; u <= 180; u+= 180/36){
            for(float v = (-90); v <= 90; v+= 180/36){
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.z = (float) (1 * Math.cos(vRad) * Math.cos(uRad));
                temp_vector.x = (float) (1 * Math.cos(vRad) * Math.sin(uRad));
                temp_vector.y = (float) (1 * Math.sin(vRad));
                vertices.add(temp_vector);
            }
        }

//        for(int i = 0; i <= stackCount; i ++){
//            stackAngle = pi / 2 - i * sectorStep;
//            x =  (radiusX + (float)Math.cos(stackAngle));
//            y =  (radiusY + (float)Math.cos(stackAngle));
//            z =  (radiusZ + (float)Math.sin(stackAngle));
//
//            for(int j = 0; j <= sectorCount; ++j){
//                sectorAngle = j * sectorStep;
//                Vector3f temp_vector = new Vector3f();
//                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
//                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
//                temp_vector.z = centerPoint.get(2) + z * (float)Math.cos(sectorAngle);
//                vertices.add(temp_vector);
//            }
//
//        }
    }

    public void createSphere2(){
        float pi = (float) Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, stackAngle, x, y, z;

        for(float u = -180; u <= 180; u+= 180/36){
            for(float v = (-90); v <= 90; v+= 180/36){
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.x = (float) (1 * Math.tan(vRad) * Math.cos(uRad));
                temp_vector.z = (float) (1 * Math.tan(vRad) * Math.sin(uRad));
                temp_vector.y = (float) (1 * Math.asin(vRad));
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphere3() {
        float pi = (float) Math.PI;

        float sectorStep = 2 * (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, stackAngle, x, y, z;

        for (float u = -180; u <= 180; u += 180 / 36) {
            for (float v = (-90); v <= 90; v += 180 / 36) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.x = (float) (1 * Math.asin(vRad) * Math.cos(uRad));
                temp_vector.z = (float) (1 * Math.asin(vRad) * Math.sin(uRad));
                temp_vector.y = (float) (1 * Math.tan(vRad));
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphere4() {
        float pi = (float) Math.PI;

        float sectorStep = 2 * (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, stackAngle, x, y, z;

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
}

