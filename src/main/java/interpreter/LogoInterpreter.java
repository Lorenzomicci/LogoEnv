package interpreter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LogoInterpreter {

    LogoAction logoAction;
    private Action action;

    Function<String,RegularExpression> transform = stringinstruction -> logoAction.actionType(stringinstruction);

    public List<RegularExpression> convertStringToExpressionp(List<String> instructions) {
        return convertStringToExpression(instructions);
    }

    private List<RegularExpression> convertStringToExpression(List<String> instructions) {
        this.logoAction = new LogoAction();
        return instructions.parallelStream().map(s -> transform.apply(s)).collect(Collectors.toList());
    }
}
