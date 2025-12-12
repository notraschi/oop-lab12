package it.unibo.es3;

import java.util.List;
import java.util.Set;

/**
 * logcs interface.
 */
public interface Logics {
    /**
     * hits elems.
     * 
     * @return coords of elems hit
     */
    List<Pair<Integer, Integer>> nextHit();

    /**
     * is it time to go?.
     * 
     * @return whether to quit
     */
    boolean toQuit();

    /**
     * gets curr grid state.
     * 
     * @return cells state
     */
    Set<Pair<Integer, Integer>> state();
}
