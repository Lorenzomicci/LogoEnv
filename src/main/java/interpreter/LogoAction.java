package interpreter;

import commands.*;
import model.LogoModel;
import model.Model;

import java.io.IOException;
import java.util.Locale;

/**
 * @author Lorenzo Micci
 * Il metodo actiontype serve per convertire una istruzione in formato testo
 * in un oggetto corrispondente di tipo {@link RegularExpression}
 */
public class LogoAction implements Action {

    /**
     *
     * @param instruction istruzione da convertire, viene utilizzato il metodo split per
     *                    dividere l istruzione nella parte testuale e nella parate parametrica
     *
     * @return una {@link RegularExpression}
     */
    @Override
    public RegularExpression actionType(String instruction, LogoModel logoModel) throws IOException {

        String[] parts = instruction.split(" ");

        return switch (parts[0].toLowerCase(Locale.ROOT)) {
            case "forward" -> new Forward(Integer.parseInt(parts[1]),logoModel);
            case "backward" -> new BackWard(Integer.parseInt(parts[1]),logoModel);
            case "left" -> new Left(logoModel);
            case "right" -> new Right(logoModel);
            case "setpencolor" -> new Setpencolor(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),logoModel);
            case "setfillcolor" -> new Setfillcolor(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),logoModel);
            case "setpensize" -> new Setpensize(Integer.parseInt(parts[1]),logoModel);
            case "setscreencolor" -> new Setscreencolor(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),logoModel);
            case "repeat" -> new Repeat(logoModel);
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