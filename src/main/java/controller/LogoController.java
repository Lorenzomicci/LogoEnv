package controller;

import interpreter.Action;
import interpreter.RegularExpression;
import model.LogoModel;
import view.LogoConsoleView;
import view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogoController implements Controller {

    private static final Logger LOGGER = Logger.getLogger( LogoController.class.getName() );
    private LogoModel logoModel;
    private LogoConsoleView currentView;
    private static List<RegularExpression> instructions = new ArrayList<>();


    public LogoController(LogoModel lm, LogoConsoleView lw) throws IOException {
        FileHandler filehandler = new FileHandler("src/main/java/controller/controller.log");
        LOGGER.addHandler(filehandler);
        logoModel = lm;
        currentView = lw;
        logoModel.mapString().parallelStream().forEach(instructions::add);
    }

    @Override
    public Optional<RegularExpression> nextInstruction() {
        LOGGER.log(Level.INFO,instructions.get(0).toString());
        return instructions.stream().findFirst();
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
        //this.currentView.printAction();
    }

    public static void main(String[] args) throws IOException {
        LogoController lc = new LogoController(new LogoModel(args[0]),new LogoConsoleView());

        System.out.println(lc.nextInstruction().toString());
    }
}
