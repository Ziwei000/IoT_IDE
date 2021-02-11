package com.group5.ide_vss.object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//{appname:"",
// units:[{pre:"null", prepara:"", value:"" post:"service2", postpara:"},
//        {pre:"service1", prepara:"", value:"true", post:"service2", postpara:"}
//        {pre:"service3", prepara:"", value:"5", post:"service2", postpara:"}]}
public class App {

    String fileName;
    String appName;
    String workingDirectory;
    Unit[] units;

    public App(String json) throws JsonProcessingException {
//        this.workingDirectory = Utils.workingDirectory;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        this.appName = node.get("appname").asText();
        JsonNode unitOfNode = node.get("units");
        for (JsonNode curNode : unitOfNode) {
            
        }
    }

    // todo 2: take care of input and value types, may need conversion
    private Unit[] generateUnits(String json) throws JsonProcessingException {
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        System.out.println(node.get("appname"));
        System.out.println(node.get("units"));

        return new Unit[1];
    }

//    public void run() {
//        for (Unit unit : units) {
//            unit.run();
//        }
//    }

    class Unit {
        Service pre;
        String prePara;
        String value; // int, bool, or string?
        Service post;
        String postPara;

//        void run() {
//            if (pre == null) {
//                post.call(prePara);
//                System.out.println("Service result is: "); // todo 3.1: print service running info
//                return;
//            }
//            if (pre.call(prePara).equals(value)) {
//                post.call(postPara);
//                System.out.println("Service result is: "); // todo 3.1: print service running info
//            }
//        }
    }

//    public void saveApp(JSONObject jsonObject) {
//        try {
//            FileWriter file = new FileWriter(this.workingDirectory + this.fileName);
//            file.write(jsonObject.toJSONString());
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("JSON file created: " + jsonObject);
//    }
//
//    public void deleteApp() {
//        File myObj = new File(this.workingDirectory + this.fileName);
//        if (myObj.delete()) {
//            System.out.println("Deleted the file: " + myObj.getName());
//        } else System.out.println("Failed to delete the file.");
//    }

//    public static void main(String[] args) {
//        App app = new App(null);
//        app.deleteApp();
//    }
}

