package com.example.testing;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

        public class NamespaceRemover {

            public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException,
                            TransformerFactoryConfigurationError, TransformerException {

                NamespaceRemover remover = new NamespaceRemover();

                String resp = remover.remove();

                System.out.println(resp);
            }

            public String remove() throws SAXException, IOException, ParserConfigurationException,
                            TransformerFactoryConfigurationError, TransformerException {
                Path path = Paths.get("/Users/s610231/work/Testing/src/main/resources/static/1859500558.xml");
                File initialFile = new File(path.toUri());
                InputStream xmlData = new FileInputStream(initialFile);

                Path xslpath = Paths.get("/Users/s610231/work/Testing/src/main/resources/static/cleanxml.xsl");
                URL xsltURL = xslpath.toUri().toURL();
                Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlData);
                Source stylesource = new StreamSource(xsltURL.openStream(), xsltURL.toExternalForm());
                Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
                StringWriter stringWriter = new StringWriter();
                transformer.transform(new DOMSource(xmlDocument), new StreamResult(stringWriter));
                return stringWriter.toString();
            }
        }



