/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */

package view;

import features.SoundPlayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * This class creates a panel contains the current score, lines cleared, and levels.
 * 
 * @author Trung Dang
 * @version November 25, 2014
 */
@SuppressWarnings("serial")
public class StatisticPanel extends JPanel implements Observer {    

    /** Spacing between lines of text.*/
    private static final int SPACING = 21;

    /** Default y position of text.*/
    private static final int DEFAULT_Y = 38;

    /** Default x position of text.*/
    private static final int DEFAULT_X = 55;

    /** The default width of this StatisticPanel.*/
    private static final int DEFAULT_WIDTH = 180;
    
    /** The default height of this StatisticPanel.*/   
    private static final int DEFAULT_HEIGHT = 130;
    
    /** 
     * The default list of required lines cleared by levels. 
     * Level is the index of the array.
     * */
    private static final int[] LEVEL_LIST = {0, 4, 6, 12, 16, 20, 24, 28, 32};
    
    /** The default score multiplier.*/
    private static final int SCORE_MULTIPLIER = 100;
    
    /** The default spacing between text of this StatisticPanel.*/
    private static final int SPACING_MULTIPLIER = 3;
    
    /** A score.*/
    private int myScore;
    
    /** Number of lines cleared.*/
    private int myLines;
    
    /** The current level of the game.*/
    private int myLevel;
    
    /** A Swing timer.*/
    private final Timer myTimer;
    
    /**
     * Construct a new StatisticPanel with the default values.
     * 
     * @param theTimer a Swing timer that need to be notified when level goes up.
     */
    public StatisticPanel(final Timer theTimer) {
        super();
        this.setName("Statistics");
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        myScore = 0;
        myLines = 0;
        myLevel = 1;
        myTimer = theTimer;
    }
    /**
     * Get the panel's current score.
     * 
     * @return myScore the Score stored in this panel
     */
    public int getMyScore() {
        return myScore;
    }
    /**
     * Get the panel's current lines cleared.
     * 
     * @return myLines the Lines stored in this panel
     */
    public int getMyLines() {
        return myLines;
    }
    /**
     * Get the panel's current level.
     * 
     * @return myLevel the level stored in this panel
     */
    public int getMyLevel() {
        return myLevel;
    }

    /** 
     * {@inheritDoc}
     * 
     * Paints the statistic text on this StatisticPanel.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Score:    " + myScore, DEFAULT_X, DEFAULT_Y);
        g2d.drawString("Lines cleared:    " + myLines, DEFAULT_X, DEFAULT_Y + SPACING);
        
        if (myLevel < LEVEL_LIST.length) {
            g2d.drawString("Level:    " + myLevel, DEFAULT_X, DEFAULT_Y + SPACING * 2);
            g2d.drawString("Lines to level " + (myLevel + 1) + ": " 
                                            + (LEVEL_LIST[myLevel] - myLines),
                                            DEFAULT_X, DEFAULT_Y 
                                            + SPACING * SPACING_MULTIPLIER);
        } else {
            g2d.drawString("Level: MAX", DEFAULT_X, DEFAULT_Y + SPACING * 2);
            g2d.drawString("Lines to level MAX: 0", DEFAULT_X, DEFAULT_Y 
                           + SPACING * SPACING_MULTIPLIER);
        }
        g2d.drawString("Speed: " + myTimer.getDelay() + " ms", 
                       DEFAULT_X, DEFAULT_Y + SPACING * (SPACING_MULTIPLIER + 1));
    }
    
    /**
     * {@inheritDoc}
     * 
     * Update this StatisticPanel according to theObject changes.
     * If:  
     *  - theArg is an instance of Integer: check the current level and level up if permitted.
     *  - theArg is an instance of String: reset all fields (new game).
     */
    @Override
    public void update(final Observable theObject, final Object theArg) {
        final SoundPlayer sP = new SoundPlayer();
        if (theArg instanceof Integer) {
            sP.play("resources/sounds/success.wav");
            myLines = ((Integer) theArg).intValue();            
            if (myLines <= LEVEL_LIST[LEVEL_LIST.length - 1]) {
                final boolean check = checkLevel();
                if (!check) {
                    sP.play("resources/sounds/success.wav");
                }
            }           
            myScore = myLines * myLevel * SCORE_MULTIPLIER;
        } else if (theArg instanceof String 
                                        && "New Game".equals(((String) theArg).toString())) {
            myLines = 0;
            myLevel = 1;
            myScore = 0;
        }
        repaint();
    }
    
    /**
     * A helper method to check the current level and level up the game if permitted.
     * 
     * @return a boolean indicating if it was appropriate to increase the level
     */
    private boolean checkLevel() {
        boolean result = false;
        for (int i = 0; i < LEVEL_LIST.length; i++) {
            if (myLines >= LEVEL_LIST[i]) {
                myLevel = i + 1;
                if (myLevel >= LEVEL_LIST.length) {
                    firePropertyChange("Max Level", null, null);
                } else {
                    firePropertyChange("Level Up", null, null);
                    result = true;
                }
            } else {
                result = false;
            }
        }
        return result;
    }
}
