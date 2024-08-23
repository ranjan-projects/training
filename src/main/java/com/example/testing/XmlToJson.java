package com.example.testing;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class XmlToJson {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
/*    public static String TEST_XML_STRING =
                    "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";*/

    public static String TEST_XML_STRING =
                    "<?xml version=\"1.0\" ?><results><result><value>1</value><value>2</value></result><result><value>1</value><value>2</value></result></results>";


    public static void main(String[] args)
                    throws IOException, ParserConfigurationException, TransformerException, SAXException {

      /*  Path path = Paths.get("/Users/s610231/work/Testing/src/main/resources/static/XML-Decision-Data.xml");
        File file = new File(path.toUri());*/
        NamespaceRemover remover = new NamespaceRemover();

        //String content = FileUtils.readFileToString(file, "UTF-8");
        String content = StringUtils.substringBetween(remover.remove(), "<Body>", "</Body>");

            try {
                JSONObject xmlJSONObj = XML.toJSONObject(content);

//https://www.baeldung.com/java-jsonnode-get-keys
                


                String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
                //.replaceAll(":\"s([\"d]+)", ": \"$1\"")
                System.out.println(jsonPrettyPrintString);
            } catch (JSONException je) {
                System.out.println(je.toString());
            }
    }
}
