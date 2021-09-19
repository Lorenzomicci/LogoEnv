package controller;

import interpreter.RegularExpression;
import interpreter.Action;

import java.util.Optional;

public interface Controller {
    /**
     *
     * @return un optional della prossima istruzione da eseguire
     */
    Optional<RegularExpression> nextInstruction();

    /**
     *
     * @return un optional dell espressione precente
     */
    Optional<RegularExpression> prevInstruction();

    /**
     *
     * @return Computa un istruzione e restituisce un Action richiama il metodo
     * Interprete dell interfaccia {@link RegularExpression}
     */
    void computeInstruction();

    /**
     * Aggiorna la Vista in base alle istruzioni eseguite
     */
    void updateView();
}
