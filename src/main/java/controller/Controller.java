package controller;

import interpreter.RegularExpression;
import interpreter.Action;

public interface Controller {
    RegularExpression nextInstruction();
    RegularExpression prevInstruction();
    Action computeInstruction();
    void updateView();
}
