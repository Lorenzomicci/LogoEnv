package model;

import interpreter.RegularExpression;
import io.LogoFileReader;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogoModel implements Model {

    private final LogoFileReader lfr = new LogoFileReader();
    List<String> instructions = new ArrayList<>();
    Map<RegularExpression,Integer> currentInstruction;
    Cursor cursorState;

    public List<String> readIntruction(String path) {
        return readLogoInstruction(path);
    }

    private List<String> readLogoInstruction(String path) {
        this.instructions = lfr.apply(Paths.get(path));
        return lfr.apply(Paths.get(path));
    }

    private void mapInstructions() {

    }

}
