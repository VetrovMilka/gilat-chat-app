package org.students.ninjas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class XmlToJsonParser {

    private static final String RESOURCES_PATH = "xml-json-parser/src/main/resources/";

    public static void main(String[] args) throws Exception {
        File xmlDirectory = new File(RESOURCES_PATH + "xmls/");
        File jsonDirectory = new File(RESOURCES_PATH + "jsons/");
        while (true) {
            Thread.sleep(5000);
            convertXMLtoJSON(xmlDirectory, jsonDirectory);
        }
    }

    private static void convertXMLtoJSON(File xmlDirectory, File jsonDirectory) throws IOException {
        List<File> XMLs = Arrays.stream(Objects.requireNonNull(xmlDirectory.listFiles())).collect(Collectors.toList());
        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        for (File XML : XMLs) {
            Map<String, Object> map = xmlMapper.readValue(XML, Map.class);
            objectMapper.writeValue(new File(jsonDirectory + "/" + XML.getName().replace(".xml", ".json")), map);
        }
    }
}