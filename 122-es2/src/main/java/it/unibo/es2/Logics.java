package it.unibo.es2;

/**
 * logic for the GUI app.
 */
public interface Logics {

    /**
     * changes state for a button.
     * 
     * @param elem button to hit
     * @return text for the hit button
     */
    boolean hit(Pair<Integer, Integer> elem);

    /**
     * checks if its time to go home.
     * 
     * @param elem elem of which row to check
     * @return a funnyh boolean
     */
    boolean toQuit(Pair<Integer, Integer> elem);
}
