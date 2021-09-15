package interpreter;

import controller.LogoController;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LogoInterpreter {

    LogoAction logoAction;
    private Action action;
    private static final Logger LOGGER = Logger.getLogger( LogoController.class.getName() );

    Function<String,RegularExpression> transform = stringinstruction -> logoAction.actionType(stringinstruction);

    public List<RegularExpression> convertStringToExpressionp(List<String> instructions) throws IOException {
        FileHandler fileHandler = new FileHandler("src/main/java/interpreter/interpreter.log");
        LOGGER.addHandler(fileHandler);
        //LOGGER.log(Level.INFO,instructions.parallelStream().forEach(System.out::println));
        instructions.parallelStream().forEach(System.out::println);
        return convertStringToExpression(instructions);
    }

    private List<RegularExpression> convertStringToExpression(List<String> instructions) {
        this.logoAction = new LogoAction();
        return instructions.parallelStream().map(s -> transform.apply(s)).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        LogoInterpreter li = new LogoInterpreter();

    }
}
