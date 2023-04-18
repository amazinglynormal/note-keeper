package org.example;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;

@Command(name = "add", description = "adds file to demo folder")
public class NotekAdd implements Callable<Integer> {

    @Option(names = {"-f", "--file"}, description = "file in which to add note")
    File file;

    @Option(names = {"-o", "--overwrite"}, description = "overwrite all previous notes")
    boolean overwrite;

    @Parameters(index = "0", description = "note that will be written to file")
    String note;


    public Integer call() throws IOException {
        Path path = Paths.get(file.getPath());
        List<String> currentNotes = Files.readAllLines(path);

        if (overwrite) {
            currentNotes.clear();
        }
        currentNotes.add(note);

        FileWriter writer = new FileWriter(file);
        String newNotes = String.join("\n",currentNotes);
        writer.write(newNotes);
        writer.close();
        return 0;
    }
}
