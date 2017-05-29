package com.epam.training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBImpl {
    private static Products products;
    private static FileReader reader;

    public static void unmarshalling(String inputXML) {
        try {
            reader = new FileReader(inputXML);
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            products = (Products) jaxbUnmarshaller.unmarshal(reader);
            for (Product product : products.getProduct()) {
                productToString(product);
            }
        } catch (JAXBException e) {
            System.err.println(e.toString());
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
    }

    public static void productToString(Product product) {
        StringBuilder productString = new StringBuilder();
        productString.append(
                "Product:\nname = " + product.getName() +
                        ",\nprice = " + product.getPrice() +
                        ",\namount = " + product.getAmount() +
                        ",\ndescription = " + product.getDescription() +
                        ",\ntype = " + product.getType() +
                        ".\n");
        System.out.println(productString.toString());
    }

    public static void marshalling(String outputXML) {
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            new File(outputXML).getParentFile().mkdirs();
            marshaller.marshal(products, new FileOutputStream(outputXML));
        } catch (JAXBException e) {
            System.err.println(e.toString());
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
    }
}
