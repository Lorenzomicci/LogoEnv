package interpreter;

import commands.*;

public class LogoAction implements Action {

    @Override
    public RegularExpression actionType(String instruction) {

        return switch (instruction) {
            case "forward" -> new Forward();
            case "backward" -> new BackWard();
            case "left" -> new Left();
            case "right" -> new Right();
            case "setpencolor" -> new Setpencolor();
            case "setfillcolor" -> new Setfillcolor();
            case "setpensize" -> new Setpensize();
            case "setscreencolor" -> new Setscreencolor();
            case "repeat" -> new Repeat();
            default -> null;
        };

    }

}















/*        return switch (instruction) {
            case "forward" -> TypeOfOperation.FORWARD;
            case "backward" -> TypeOfOperation.BACKWARD;
            case "left" -> TypeOfOperation.LEFT;
            case "right" -> TypeOfOperation.RIGHT;
            case "setpencolor" -> TypeOfOperation.SETPENCOLOR;
            case "setfillcolor" -> TypeOfOperation.SETFILLCOLOR;
            case "setpensize" -> TypeOfOperation.SETPENSIZE;
            case "setscreencolor" -> TypeOfOperation.SETSCREENCOLOR;
            case "repeat" -> TypeOfOperation.REPEAT;
            default -> null;
        };*/