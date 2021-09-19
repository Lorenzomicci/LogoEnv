
package controller;

import interpreter.Action;
import interpreter.RegularExpression;
import model.LogoModel;
import model.Position;
import view.LogoConsoleView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lorenzo Micci
 * public class {@link controller.LogoController}
 * Il {@link controller.LogoController} viene utilizzato per gestire le informazioni che arrivano dal
 * {@link model.LogoModel} e aggiornare il {@link view.LogoConsoleView}
 *
 * Costruttore
 *
 * public LogoController(LogoModel lm, LogoConsoleView lw) throws IOException {
 *         FileHandler filehandler = new FileHandler("src/main/java/controller/controller.log");
 *         LOGGER.addHandler(filehandler);
 *         logoModel = lm;
 *         currentView = lw;
 *         logoModel.mapString().parallelStream().forEach(instructions::add);
 *     }
 *
 *     Inizializza il LogoModel e la View e inserisce all'interno della
 *     lista instructions le istruzioni le espression convertite in {@link interpreter.RegularExpression}
 *
 */
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
        computeInstruction();
    }

    @Override
    public Optional<RegularExpression> nextInstruction() {
        return null;
    }

    @Override
    public Optional<RegularExpression> prevInstruction() {
        return null;
    }

    @Override
    public void computeInstruction() {
        instructions.forEach(RegularExpression::interprete);
    }

    @Override
    public void updateView() {

    }

    public static void main(String[] args) throws IOException {
        LogoController lc = new LogoController(new LogoModel(args[0]),new LogoConsoleView());
    }
}
