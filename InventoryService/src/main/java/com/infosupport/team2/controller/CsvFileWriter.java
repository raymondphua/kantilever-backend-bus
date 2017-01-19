package com.infosupport.team2.controller;

import com.infosupport.team2.model.TestObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by djones on 1/17/17.
 */
@Component
@Controller
public class CsvFileWriter extends TimerTask {

    @Override
    public void run() {
        try {
            downloadCsv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void downloadCsv() throws IOException {

        //Mock data pls
        TestObject testObject = new TestObject("MongoHashCode",  "5");
        TestObject testObject2 = new TestObject("MongoHashCode2", "8" );
        TestObject testObject3 = new TestObject("MongoHashCode3", "14");

        LocalDateTime localDateTime = LocalDateTime.now();
        List<TestObject>  testObjects = Arrays.asList(testObject, testObject2, testObject3);


        String filename = "_test_"+ localDateTime +"_.csv";
        String workingDirectory = System.getProperty("user.home");
        String absolutepath = workingDirectory + filename;

        ICsvBeanWriter beanWriter = null;
        try {

            beanWriter = new CsvBeanWriter(new FileWriter(absolutepath), CsvPreference.STANDARD_PREFERENCE);

            String[] header = {"id", "quantity"};
            beanWriter.writeHeader(header);

            for (TestObject item : testObjects) {
                beanWriter.write(item, header);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(beanWriter != null) {
                beanWriter.close();
            }
        }
    }
}
