package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final List<Integer> values;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        if (size < 1) {
            throw new IllegalArgumentException("at least one button is necessary..");
        }
        this.values = new ArrayList<>(Stream.generate(() -> 0).limit(size).toList()); // watch out
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.values.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return Collections.unmodifiableList(this.values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return this.values.stream()
            .map(elem -> elem < this.values.size())
            .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        // range check
        final int currentValue = this.values.get(elem);
        if (currentValue < this.values.size()) {
            this.values.set(elem, currentValue + 1);
        }
        return this.values.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return this.values.stream()
            .map(String::valueOf)
            .collect(Collectors.joining("|", "<<", ">>"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return values.stream().distinct().count() <= 1
            || this.enabledStates().stream().allMatch(x -> !x); // so true evaluates to false..
    }
}
