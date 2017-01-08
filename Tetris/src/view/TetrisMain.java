/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */

package view;

import java.awt.EventQueue;

/**
 * This main class runs the Tetris game.
 * 
 * @author Trung Dang
 * @version November 25, 2014
 *
 */
public final class TetrisMain {
    
    /**
     * Private constructor. Prevent instantiation.
     */
    private TetrisMain() {
        
    }

    /**
     * Construct a new Tetris GUI in a thread safe invocation.
     * 
     * @param theArgs command line argument
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetrisGUI();            
            }     
        });
    }
}
