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
    public String hit(Pair<Integer, Integer> elem);

    /**
     * checks if its time to go home.
     * 
     * @return a funnyh boolean
     */
    public boolean toQuit(Pair<Integer, Integer> elem);
} 