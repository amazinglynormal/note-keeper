package org.example;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.*;
import java.util.concurrent.Callable;

@Command(name = "read", description = "prints contents of file to stdout")
public class NotekRead implements Callable<Integer> {
    @Parameters(index = "0", description = "file to read")
    File file;

    @Override
    public Integer call() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while((str = br.readLine()) != null) {
                System.out.println(str);
            }
            return 0;
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error: File not found. Try checking your spelling for errors.");
            return 1;
        } catch (IOException ioException) {
            System.err.println("Error: An I/O error occurred. Please try again.");
            return 1;
        }
    }
}
