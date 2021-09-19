package commands;

import controller.LogoController;
import interpreter.RegularExpression;
import model.LogoModel;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Setfillcolor implements RegularExpression {

    private static final Logger LOGGER = Logger.getLogger( LogoController.class.getName() );

    public Setfillcolor(int parseInt, int parseInt1, int parseInt2, LogoModel logoModel) throws IOException {
        FileHandler filehandler = new FileHandler("src/main/java/CommandsLog/instructions.log",true);
        LOGGER.addHandler(filehandler);
    }

    @Override
    public void interprete() {
        interpreteInstruction();
        LOGGER.info("SetFillColor");
    }

    private void interpreteInstruction() {
        System.out.println("SetFillColor");
    }
}
