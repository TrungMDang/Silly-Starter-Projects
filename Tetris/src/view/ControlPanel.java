/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Board;

/**
 * This class crates a panel contains the current control key bindings of Tetris game.
 * 
 * @author Trung Dang
 * @version November 25, 2014
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements Observer {
    
    /** A constant for the default number of lines of text painted on this ControlPanel.*/
    private static final int NUMBER_LINES = 8;

    /** A constant for the x coordinate of a string painted on this ControlPanel.*/
    private static final int DEFAULT_TEXT_X = 55;

    /** A constant for the combined free space of the top and bottom of this ControlPanel.*/
    private static final int TOP_BOTTOM_SPACE = 30;

    /** Default width of this ControlPanel.*/
    private static final int DEFAULT_WIDTH = 180;
    
    /** Default height of this ControlPanel.*/   
    private static final int DEFAULT_HEIGHT = 230;
    
    /** A modifier of text label position of this ControlPanel.*/
    private static final int SHIFT_DOWN = 8;
    
    /** A KeyBindings of this ControlPanel.*/
    private final KeyBindings myKeys;
    
    /**
     * Construct a ControlPanel with default key control bindings.
     * 
     * @param theKey a KeyBindings to be used as default control bindings for this ControlPanel
     */
    public ControlPanel(final KeyBindings theKey) {
        super();
        this.setName("Controls");
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        myKeys = theKey;
    }

    /**
     * {@inheritDoc}
     * 
     * Paint this ControlPanel.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        final int space = (this.getHeight() - TOP_BOTTOM_SPACE) / NUMBER_LINES;
        g2d.setColor(Color.WHITE);
        final int j = 6;
        int i = j;
        g2d.drawString("Move left:    " + myKeys.getLeft(), 
                       DEFAULT_TEXT_X, space + SHIFT_DOWN);
        g2d.drawString("Move right:    " + myKeys.getRight(), 
                       DEFAULT_TEXT_X, space * (NUMBER_LINES - i) + SHIFT_DOWN);
        i -= 1;
        g2d.drawString("Move down:    " + myKeys.getDown(), 
                       DEFAULT_TEXT_X, space * (NUMBER_LINES - i) + SHIFT_DOWN);
        i -= 1;
        g2d.drawString("Drop:    " + myKeys.getHardDrop(), 
                       DEFAULT_TEXT_X, space * (NUMBER_LINES - i) + SHIFT_DOWN);
        i -= 1;
        g2d.drawString("Rotate:    " + myKeys.getRotateCW(), 
                       DEFAULT_TEXT_X, space * (NUMBER_LINES - i) + SHIFT_DOWN);
        i -= 1;
        g2d.drawString("Pause:    " + myKeys.getPause(), 
                       DEFAULT_TEXT_X, space * (NUMBER_LINES - i) + SHIFT_DOWN);
        i -= 1;
        g2d.drawString("Resume:    " + myKeys.getResume(), 
                       DEFAULT_TEXT_X, space * (NUMBER_LINES - i) + SHIFT_DOWN);
        i -= 1;
        g2d.drawString("Save:    " + myKeys.getSave(), 
                       DEFAULT_TEXT_X, space * NUMBER_LINES + SHIFT_DOWN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Observable theObject, final Object theArg) {
        if (theObject instanceof Board) {
            repaint();
        }
    }
}
