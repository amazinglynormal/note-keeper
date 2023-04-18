package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "notek",
        mixinStandardHelpOptions = true ,
        subcommands = {
            NotekAdd.class,
            NotekRead.class
})
public class Notek {

    public static void main( String[] args ) {
        int exitCode = new CommandLine(new Notek()).execute(args);
        System.exit(exitCode);
    }
}
