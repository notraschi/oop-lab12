package it.unibo.es3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * impls the logis.
 */
public class LogicsImpl implements Logics {
    private final Set<Pair<Integer, Integer>> dead;
    private final int size;

    /**
     * constr.
     * @param width how large the grid is
     */
    @SuppressFBWarnings("DMI_RANDOM_USED_ONLY_ONCE")
    public LogicsImpl(final int width) {
        size = width;
        dead = new LinkedHashSet<>();
        final Random rand = new Random();
        while (dead.size() < 3) {
            dead.add(new Pair(rand.nextInt(size), rand.nextInt(size)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Pair<Integer, Integer>> state() {
        return Collections.unmodifiableSet(dead);
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Pair<Integer, Integer>> next_hit() {
        return neighbors().stream()
            .peek(n -> dead.add(n))
            .toList();
    }

    /**
     * gets neighbrs to hit.
     * @return the ALIVE neighbors as coords
     */
    private List<Pair<Integer, Integer>> neighbors() {
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pair<Integer, Integer> tmp = new Pair(i, j);
                if (dead.stream().anyMatch(p -> {
                    return Math.abs(p.x() - tmp.x()) < 2 && Math.abs(p.y() - tmp.y()) < 2 && !dead.contains(tmp);
                })) {
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean toQuit() {
        return dead.size() == size * size;
    }
}
