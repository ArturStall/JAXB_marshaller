package com.epam.training;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final String INARGUMENT = "-in";
        final String OUTARGUMENT = "-out";
        String inputXML = null;
        String outputXML = null;

        if (Arrays.asList(args).size() != 4) {
            System.err.println("Wrong arguments,\nwrite parameters: -in, -out");
        } else {
            System.out.println("Start programm:");
            for (String s : args) {
                if (s.toLowerCase().equals(INARGUMENT)) {
                    int indexInArg = (Integer) Arrays.asList(args).indexOf(s) + 1;
                    System.out.println("Path in - " + args[indexInArg]);
                    inputXML = args[indexInArg];
                }
                if (s.toLowerCase().equals(OUTARGUMENT)) {
                    int indexOutArg = (Integer) Arrays.asList(args).indexOf(s) + 1;
                    System.out.println("Path out - " + args[indexOutArg] + "\n");
                    outputXML = args[indexOutArg];
                }
            }
            JAXBImpl.unmarshalling(inputXML);
            JAXBImpl.marshalling(outputXML);
            System.out.println("End programm.");
        }
    }
}
