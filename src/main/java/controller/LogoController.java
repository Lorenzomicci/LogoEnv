package controller;

import interpreter.Action;
import interpreter.RegularExpression;
import model.LogoModel;
import model.Model;
import view.LogoConsoleView;
import view.View;

public class LogoController implements Controller {

    LogoModel CurrentModel;
    LogoConsoleView CurrentView;

    public LogoController(Model lm, View lw){
        this.CurrentModel = (LogoModel) lm;
        this.CurrentView = (LogoConsoleView) lw;
    }

    @Override
    public RegularExpression nextInstruction() {
        return null;
    }

    @Override
    public RegularExpression prevInstruction() {
        return null;
    }

    @Override
    public Action computeInstruction() {
        return null;
    }

    @Override
    public void updateView() {

    }
}
