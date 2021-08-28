package io;

import java.nio.file.Path;
import java.util.List;

@FunctionalInterface
public interface Reader {
    List<String> read();
}
