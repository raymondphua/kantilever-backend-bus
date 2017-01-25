package com.infosupport.team2.controller;

import com.infosupport.team2.model.Product;
import com.infosupport.team2.serviceCaller.OrderServiceCaller;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;

/**
 * Created by djones on 1/17/17.
 */
@NoArgsConstructor
@Controller
public class CsvFileWriter extends TimerTask {

    private Long refreshRate;
    private int runs = 0;

    public void setRefreshRate(Long refreshRate){
        this.refreshRate = refreshRate;
    }

    @Autowired
    OrderServiceCaller orderServiceCaller;

    public CsvFileWriter(Long parseStringToLong) {
        this.refreshRate = parseStringToLong;
    }

    @Override
    public void run() {
        if (runs != 0) {
            try {
                downloadCsv();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        runs++;
    }


    public void downloadCsv() throws IOException {
        List<Product> products = orderServiceCaller.productList(refreshRate);

        //Mock data pls
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        File file = new File(System.getProperty("user.dir") + "/config.properties");
        FileInputStream fileInputStream = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(fileInputStream);
        String value = properties.getProperty("directory");

        String filename = "Voorraad_"+ localDateTime.format(formatter)+".csv";
        String absolutepath = value + filename;

        ICsvBeanWriter beanWriter = null;
        try {

            beanWriter = new CsvBeanWriter(new FileWriter(absolutepath), CsvPreference.STANDARD_PREFERENCE);

            String[] header = {"id", "quantity"};
            beanWriter.writeHeader(header);

            for (Product item : products) {
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
