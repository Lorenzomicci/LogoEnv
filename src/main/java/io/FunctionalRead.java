package io;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

public interface FunctionalRead extends Function<Path, List<String>> {

}
