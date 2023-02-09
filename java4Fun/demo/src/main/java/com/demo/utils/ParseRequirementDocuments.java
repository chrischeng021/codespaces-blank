package main.java.com.demo.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * Created by chrischeng021@gmail.com
 * Version 1.0
 */
@Slf4j
public class ParseRequirementDocuments {
    private static final String PREFIX = "http://cgf-qc.coupang.net/rfm-qc/bulk-review/download/batteryImage?";
    public static void parseDocuments (String input, String output) {
        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new FileReader(input));
            writer = new BufferedWriter(new FileWriter(output));

            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                if(StringUtils.isNotEmpty(line)) {
                    String parsedLine = parseLine(line);
                    writer.write(parsedLine);
                }

            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseLine(String line) {
        String[] arr = line.split(",\"");
        String inventoryId = arr[0].replace("\"", "");
        String vendorId = arr[1].replace("\"", "");
        List<String> urlList = new ArrayList<>();
        
        String[] documentArr = arr[2].replace("\"", "").split("},");

        for(String document : documentArr) {
            String path = document
                    .substring(document.indexOf("path="), document.indexOf("requiredtype=null") - 1)
                    .replace(" ", "+")
                    .replace(",", "");
            urlList.add(PREFIX + path);
        }

        return "%s\n".formatted(
                StringUtils.join(
                        ImmutableList.of(
                                inventoryId,
                                vendorId,
                                StringUtils.join(urlList, ",")),
                        ","));
    }
}
