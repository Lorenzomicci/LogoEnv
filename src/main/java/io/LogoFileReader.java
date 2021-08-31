package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogoFileReader implements FunctionalRead {

    FunctionalRead funRead = path1 -> {
        try {
            return Files.lines(path1).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    };

    @Override
    public List<String> apply(Path path) {
        return funRead.apply(path);
    }

}
