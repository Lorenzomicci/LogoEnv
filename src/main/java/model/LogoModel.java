package model;

import interpreter.LogoInterpreter;
import interpreter.RegularExpression;
import io.LogoFileReader;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

public class LogoModel implements Model {

    private final LogoFileReader logofilereader = new LogoFileReader();
    private List<String> instructions = new ArrayList<>();
    private Map<RegularExpression,Integer> currentInstruction = new HashMap<>();
    private Cursor cursorState;
    private LogoInterpreter interpreter = new LogoInterpreter();
    private static int countInstruction = 0;

    public LogoModel(String path) throws IOException {
        this.cursorState = new LogoCursor();
        readInstruction(path);
    }

    Function<RegularExpression,Integer> addToMap = e -> this.currentInstruction.put(e,LogoModel.countInstruction + 1);

    public List<String> getInstructions() {
        return instructions;
    }

    public Map<RegularExpression, Integer> getCurrentInstruction() {
        return currentInstruction;
    }

    public Cursor getCursorState() {
        return cursorState;
    }

    public void readInstruction(String path) throws IOException {
         readLogoInstruction(path);
    }

    private void readLogoInstruction(String path) throws IOException {
        this.instructions = logofilereader.apply(Paths.get(path));
        mapInstructions();
        logofilereader.apply(Paths.get(path));
    }

    private void mapInstructions() throws IOException {
        interpreter.convertStringToExpressionp(this.instructions).forEach(e -> addToMap.apply(e));
    }

    public List<RegularExpression> mapString() throws IOException {
        return mapStringToRegEx();
    }

    private List<RegularExpression> mapStringToRegEx() throws IOException {
       return this.interpreter.convertStringToExpressionp(this.instructions);
    }

}
