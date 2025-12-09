package it.unibo.es2;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * happy logic impl.
 */
public class LogicsImpl implements Logics {
    private final Map<Pair<Integer, Integer>, Boolean> elems;

    /**
     * simple constructor.
     * 
     * @param size n in nxn matrix
     */
    public LogicsImpl(final int size) {
        elems = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                elems.put(new Pair<>(i, j), false);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hit(final Pair<Integer, Integer> elem) {
        elems.replace(elem, !elems.get(elem));
        return elems.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit(final Pair<Integer, Integer> elem) {
        final boolean myval = elems.get(elem);
        boolean quit = false;
        for (int i = 0; i < Math.sqrt((double) elems.size()); i++) {
            if (elems.get(new Pair<>(i, elem.y())) != myval && !quit) {
                return false;
            }
        }
        quit = true;
        for (int i = 0; i < Math.sqrt((double) elems.size()); i++) {
            if (elems.get(new Pair<>(elem.x(), i)) != myval && !quit) {
                return false;
            }
        }
        return true;
    }
}
