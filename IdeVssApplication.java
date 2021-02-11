package com.group5.ide_vss;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group5.ide_vss.utils.HaochengPi;
import com.group5.ide_vss.utils.UtilPi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class IdeVssApplication {

    public static void main(String[] args) throws IOException {
       // UtilPi.testForJson();
//        HaochengPi.Get_Temperature_C();
    	UtilPi.getTweetsFromPi();
        SpringApplication.run(IdeVssApplication.class, args);
    }

}
