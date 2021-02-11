package com.group5.ide_vss.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.group5.ide_vss.data.dataServices;
import com.group5.ide_vss.object.App;
import com.group5.ide_vss.object.Service;
import com.group5.ide_vss.object.Thing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class UtilPi {
	
    public static void getTweetsFromPi() {
        try{
        	System.out.println("haha");
            MulticastSocket ms = new MulticastSocket(1235);
            InetAddress ia = InetAddress.getByName("232.1.1.1");
            ms.joinGroup(ia);
            byte[] buffer = new byte[4096];
            List<String> thinglist = new ArrayList<String>();
            List<String> tStatus = new ArrayList<String>();
            int thingcount = 0;
            tStatus.add("stop");
            tStatus.add("stop");
            tStatus.add("stop");
            tStatus.add("stop");
            tStatus.add("stop");
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData());
                s.contains("hah");
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rtweets = mapper.readTree(s);
                
                String ss = rtweets.get("Space ID").asText();
                
                //SmartSpaceGroup5 Group3SmartSpace
                if(ss.equals("HaoSpace01")) {
                    String tid = rtweets.get("Thing ID").asText();
                    String strs[] = tid.split("0");
                    int i = Integer.parseInt(strs[1]);
                    if(rtweets.get("Tweet Type").asText().equals("Identity_Thing")) { //first tweet of each loop
                        if (!thinglist.contains(tid)) {
                            thinglist.add(tid);
                            tStatus.set(i, "activate");
                            String ip0 = dp.getAddress().toString();
                            int port0 = dp.getPort();
                            //System.out.println(s);
                            Thing thi0 = new Thing(rtweets.get("Thing ID").asText(), rtweets.get("Space ID").asText(), rtweets.get("Name").asText(), rtweets.get("Model").asText(), rtweets.get("Vendor").asText(), rtweets.get("Owner").asText(), rtweets.get("Description").asText(), rtweets.get("OS").asText());
                            dataServices.things.put(thi0.getId(), thi0);
                        }else {
                        	tStatus.set(i, "stop");
                            thingcount++;
                            System.out.println("finished listening to" + tid);
                        }
                    }else {//other tweets
                        if(thinglist.contains(tid) && tStatus.get(i).equals("activate")) {
                        	if(rtweets.get("Tweet Type").asText().equals("Service")) {
                        		 String ip0 = dp.getAddress().toString();
                                 int port0 = dp.getPort();
                                 Service serv0 = new Service(ip0, port0, rtweets.get("Name").asText(), rtweets.get("Thing ID").asText(), rtweets.get("Entity ID").asText(), rtweets.get("Space ID").asText(), rtweets.get("Vendor").asText(), rtweets.get("API").asText(), rtweets.get("Type").asText(), rtweets.get("AppCategory").asText(), rtweets.get("Description").asText(), rtweets.get("Keywords").asText() );
                                 dataServices.services.put(serv0.getName(), serv0);
                        	}
                           
                        }
                    }
                }
                if (thingcount == 1) {
                    System.out.println("all tweets are received");
                    break;
                }
               
            }
        }
        catch (IOException ex){
            System.err.println(ex);
        }
        //Service ser0 = new Service();
        //
    }


    public static String ActivateService(String ip, String port, String Tweet_Type, String Thing_ID, String Space_ID, String Service_Name, String Service_Inputs) throws IOException {
        Socket socket = new Socket(ip, Integer.valueOf(port));
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("Tweet Type", Tweet_Type);
        node.put("Thing ID", Thing_ID);
        node.put("Space ID", Space_ID);
        node.put("Service Name", Service_Name);
        node.put("Service Inputs", Service_Inputs);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output.write(json);
        output.flush();
        StringBuilder builder = new StringBuilder();
        while (true) {
            String curLine = br.readLine();
            if (curLine == null)
                break;
            builder.append(curLine).append(System.lineSeparator());
        }
        br.close();
        output.close();
        socket.close();
        String tweet = builder.toString();
        JsonNode resultJson = mapper.readTree(tweet);
        String result = resultJson.get("Service Result").asText();
        return result;
    }
    public static void testForJson() throws JsonProcessingException {
        getTweetsFromPi();
        for (String s : dataServices.services.keySet())
            System.out.println(dataServices.services.get(s));
    }
}
