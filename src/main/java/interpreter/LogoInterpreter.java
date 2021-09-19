package interpreter;

import controller.LogoController;
import model.LogoModel;
import model.Model;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Lorenzo Micci
 * Il LogoInterpreter si compone di due Funzioni convertStringToExpressionp e convertStringToExpression che
 * servono per convertire le stringhe lette dal file delle istruzioni in {@link RegularExpression}
 */
public class LogoInterpreter {

    private LogoAction logoAction;
    private Action action;
    private LogoModel logoModel;
    private static final Logger LOGGER = Logger.getLogger( LogoController.class.getName() );

    public LogoInterpreter(LogoModel model) {
        logoModel = model;
    }

    Function<String,RegularExpression> transform = stringinstruction -> {
        try {
            return logoAction.actionType(stringinstruction,this.logoModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    };

    public List<RegularExpression> convertStringToExpressionp(List<String> instructions) throws IOException {
        FileHandler fileHandler = new FileHandler("src/main/java/interpreter/interpreter.log");
        LOGGER.addHandler(fileHandler);
        return convertStringToExpression(instructions);
    }

    private List<RegularExpression> convertStringToExpression(List<String> instructions) {
        this.logoAction = new LogoAction();
        return instructions.parallelStream().map(s -> transform.apply(s)).collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }

}
