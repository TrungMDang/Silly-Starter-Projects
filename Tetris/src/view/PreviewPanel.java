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
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.AbstractPiece;
import model.Board;
import model.Piece;

/**
 * This class creates a preview panel of Tetris next piece.
 * 
 * @author Trung Dang
 * @version November 25, 2014
 *
 */
@SuppressWarnings("serial")
public class PreviewPanel extends JPanel implements Observer {   

    /** The default width of  this PreviewPanel.*/
    private static final int DEFAULT_WIDTH = 180;
    
    /** The default height of this PreviewPanel.*/   
    private static final int DEFAULT_HEIGHT = 150;

    /** The default number of blocks on this PreviewPanel.*/
    private static final int NUMBER_BLOCKS = 6;
    
    /** A Tetris piece.*/
    private Piece myPiece;
    
    /**
     * Construct a new PreviewPanel with default values.
     */
    public PreviewPanel() {
        super();
        this.setName("Next Piece");
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        if (myPiece != null) {
           
            final int[][] rotation = ((AbstractPiece) myPiece).getRotation();
            for (int i = 0; i < rotation.length; i++) {
                final int[] localCoordinates = rotation[i].clone();
                for (int j = 0; j < localCoordinates.length; j++) {
                    final int translatedX = (localCoordinates[0] + 1) 
                                                    * this.getWidth() / NUMBER_BLOCKS;
                    final int translatedY = (NUMBER_BLOCKS - 2 - localCoordinates[1]) 
                                                    * this.getHeight() / NUMBER_BLOCKS;
                    g2d.setColor(((AbstractPiece) myPiece).getBlock().getColor());
                    g2d.fill(new Rectangle2D.Double(translatedX, translatedY, 
                                                    this.getWidth() / NUMBER_BLOCKS, 
                                                    this.getHeight() / NUMBER_BLOCKS));
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(translatedX, translatedY, 
                                                    this.getWidth() / NUMBER_BLOCKS, 
                                                    this.getHeight() / NUMBER_BLOCKS);
                }
            }        
        }   
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Observable theObject, final Object theArg) {
        if (theObject instanceof Board && ((Board) theObject).getNextPiece() != null) {
            myPiece = ((Board) theObject).getNextPiece();
        }
        repaint();     
    }

}
