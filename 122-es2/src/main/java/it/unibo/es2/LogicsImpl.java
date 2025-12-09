package it.unibo.es2;

import java.util.Map;
import java.util.LinkedHashMap;

public class LogicsImpl implements Logics {
    private final Map<Pair<Integer, Integer>, Boolean> elems;

    public LogicsImpl(final int size) {
        elems = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                elems.put(new Pair<Integer,Integer>(i, j), false);
            }
        }
    }

    @Override
    public String hit(final Pair<Integer, Integer> elem) {
        elems.replace(elem, !elems.get(elem));
        System.out.println(elems.get(elem));
        if (elems.get(elem)) {
            return "*";
        } else {
            return " ";
        }
    }

    @Override
    public boolean toQuit(final Pair<Integer, Integer> elem) {
        final boolean myval = elems.get(elem);
        for (int i = 0; i < elems.size(); i++) {
            if (elems.get(new Pair<Integer, Integer>(elem.x(), i)) != myval
                && elems.get(new Pair<Integer, Integer>(i, elem.y())) != myval) {
                return false;
            }
        }
        return true;
    }
}
