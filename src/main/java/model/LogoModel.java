package model;

import interpreter.LogoInterpreter;
import interpreter.RegularExpression;
import io.LogoFileReader;

import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

public class LogoModel implements Model {

    private final LogoFileReader logofilereader = new LogoFileReader();
    List<String> instructions = new ArrayList<>();
    Map<RegularExpression,Integer> currentInstruction = new HashMap<>();
    Cursor cursorState;
    LogoInterpreter interpreter = new LogoInterpreter();
    private final int countInstruction = 0;

    public LogoModel() {
    }

    Function<RegularExpression,Integer> addToMap = e -> this.currentInstruction.put(e,this.countInstruction + 1);

    public List<String> readInstruction(String path) {
        return readLogoInstruction(path);
    }

    private List<String> readLogoInstruction(String path) {
        this.instructions = logofilereader.apply(Paths.get(path));
        mapInstructions();
        return logofilereader.apply(Paths.get(path));
    }

    private void mapInstructions() {
        interpreter.convertStringToExpressionp(this.instructions).parallelStream()
                .map(e -> addToMap.apply(e));
    }

}
