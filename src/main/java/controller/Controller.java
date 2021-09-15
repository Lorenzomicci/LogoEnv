package controller;

import interpreter.RegularExpression;
import interpreter.Action;

import java.util.Optional;

public interface Controller {
    Optional<RegularExpression> nextInstruction();
    RegularExpression prevInstruction();
    Action computeInstruction();
    void updateView();
}
