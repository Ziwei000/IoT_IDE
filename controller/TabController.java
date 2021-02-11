package com.group5.ide_vss.controller;

import com.group5.ide_vss.data.dataServices;
import com.group5.ide_vss.object.Relationship;
import com.group5.ide_vss.object.Service;
import com.group5.ide_vss.object.Thing;
import com.group5.ide_vss.utils.HaochengPi;
import com.group5.ide_vss.utils.UtilPi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class TabController {

    @RequestMapping("/getThing")
    public Thing[] initiationOfThings() throws IOException {
//        HaochengPi.Tap_Times(5);
    	Thing[] res = new Thing[dataServices.things.size()];
        int index = 0;
        for (String s : dataServices.things.keySet())
        	res[index++] = dataServices.things.get(s);
//        res[0] = new Thing("12136717", "just a name", "just a owner", "just a vendor", "just a model", "just a release", "just a type", "just a OS", "just a des", "just a comment");
//        res[1] = new Thing("3213324", "just a name", "just a owner", "just a vendor", "just a model", "just a release", "just a type", "just a OS", "just a des", "just a comment");
//        res[2] = new Thing("423255", "just a name", "just a owner", "just a vendor", "just a model", "just a release", "just a type", "just a OS", "just a des", "just a comment");
        return res;
    }

    @RequestMapping("/getService")
    public Service[] initiationOfServices() throws IOException {
//        HaochengPi.Get_Humidity();
        Service[] res = new Service[dataServices.services.size()];
        int index = 0;
        for(String s: dataServices.services.keySet()){
            res[index++] = dataServices.services.get(s);
        }
//        res[0] = new Service("name1", "just a owner", "just a category", "just a type", "just a keywords", "just a description");
//        res[1] = new Service("name2", "just a owner", "just a category", "just a type", "just a keywords", "just a description");
//        res[2] = new Service("name3", "just a owner", "just a category", "just a type", "just a keywords", "just a description");
//        res[3] = new Service("name4","just a owner", "just a category", "just a type", "just a keywords", "just a description");
        return res;
    }

    @RequestMapping("/getRelationship")
    public Relationship[] initiationOfRelationships() throws IOException {
//        HaochengPi.Get_Temperature_C();
        Relationship[] res = new Relationship[2];
        res[0] = new Relationship("parent1", "child1", "hello");
        res[1] = new Relationship("parent2", "child2", "hi");
        return res;
    }
}
