package model;

import compiler.Expression;
import io.LogoFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogoModel implements Model {

    private final LogoFileReader lfr = new LogoFileReader();
    List<String> instructions = new ArrayList<>();
    Map<Expression,Integer> currentInstruction;
    Cursor cursorState;

}
