package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogoFileReader implements Reader {

    private List<String> lines = new ArrayList<>();

    @Override
    public List<String> read() {
        String programPath = "D:\\Universita\\PA\\LogoEnvironment\\src\\main\\java\\files\\program.txt";
        try (Stream<String> stream = Files.lines(Paths.get(programPath))) {

            //1. convert all content to upper case
            //2. convert it into a List
            this.lines = stream
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void main(String[] args){
        LogoFileReader lfr = new LogoFileReader();
        List<String> app = lfr.read();

        app.forEach(System.out::println);
    }
}
