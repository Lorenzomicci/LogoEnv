package interpreter;

import commands.*;

public class LogoAction implements Action {

    @Override
    public RegularExpression actionType(String instruction) {

        String[] parts = instruction.split(" ");

        return switch (parts[0]) {
            case "forward" -> new Forward(Integer.parseInt(parts[1]));
            case "backward" -> new BackWard();
            case "left" -> new Left();
            case "right" -> new Right();
            case "setpencolor" -> new Setpencolor();
            case "setfillcolor" -> new Setfillcolor();
            case "setpensize" -> new Setpensize();
            case "setscreencolor" -> new Setscreencolor();
            case "repeat" -> new Repeat();
            default -> null; //TODO refactor per togliere null e usare gli optional
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