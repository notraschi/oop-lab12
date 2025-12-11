package it.unibo.es3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<Pair<Integer, Integer>, JButton> cells = new LinkedHashMap<>();
    private final Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.logics = new LogicsImpl(width);
        // JFrame settings
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Layout
        final var panel = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(BorderLayout.CENTER, panel);

        final var next = new JButton(">");
        this.getContentPane().add(BorderLayout.SOUTH, next);
        next.addActionListener(e -> {
            for (var p : logics.next_hit()) {
                cells.get(p).setText("*");
            }
            if (logics.toQuit()) {
                this.dispose();
            }
        });

        // Create buttons and add them to the panel // why buttons?
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton(" ");
                this.cells.put(new Pair<>(i, j), button);
                panel.add(button);
            }
        }

        pack();
        this.setVisible(true);
        // load curr state
        logics.state().forEach(p -> cells.get(p).setText("*"));
    }
}
