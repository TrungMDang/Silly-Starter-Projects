/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.AbstractPiece;
import model.Block;
import model.Board;
import model.Piece;

/**
 * This class creates a placeholder for the current and frozen Tetris pieces.
 * 
 * @author Trung Dang
 * @version November 25, 2014
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Observer, PropertyChangeListener, 
                                                                               ActionListener {
    
    /** A denominator to divide the width and height of this component.*/
    private static final int LOCATION_SEPARATOR = 5;

    /** The default duration of a text being displayed.*/
    private static final int TEXT_DURATION = 3;

    /** The default font size of the text.*/
    private static final int DEFAULT_FONT_SIZE = 50;

    /** The default height of this GamePanel.*/
    private static final int DEFAULT_HEIGHT = 600;

    /** The default width of this GamePanel.*/
    private static final int DEFAULT_WIDTH = 300;

    /** The default number of squares in x-direction of a Tetris board.*/
    private static final int NUMBER_BLOCKS_X = 10;

    /** The default number of squares in y-direction of a Tetris board.*/
    private static final int NUMBER_BLOCKS_Y = 20;

    /** The default interval for the timer of text painted on this panel when leveling up.*/
    private static final int DEFAULT_INTERVAL = 500;

    /** No piece.*/
    private static final Piece NO_PIECE = null;

    /** A Tetris piece.*/
    private Piece myPiece;

    /** A current list of frozen blocks on the Tetris board.*/
    private List<Block[]> myFrozenBlocks;

    /** An indicator that this panel should draw the text when leveling up.*/
    private boolean myDrawText;

    /** A text to be displayed when leveling up.*/
    private String myText;

    /** A counter to control how long a text should be displayed.*/
    private int myCounter;

    /** A timer for the text painted on this panel when leveling up.*/
    private final Timer myTextTimer;

    /**
     * Construct a new GamePanel with the default values.
     */
    public GamePanel() {
        super();
        final Dimension size = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setPreferredSize((Dimension) size.clone());
        setMinimumSize(new Dimension((Dimension) size.clone()));
        setBackground(Color.BLACK);
        myFrozenBlocks = new ArrayList<>();
        myPiece = NO_PIECE;
        myDrawText = false;
        myCounter = 0;
        myTextTimer = new Timer(DEFAULT_INTERVAL, this);
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

        drawCurrentPiece(g2d);

        drawFrozenBlocks(g2d);

        if (myDrawText && myCounter <= TEXT_DURATION) {
            myTextTimer.start();
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Distant Galaxy", Font.PLAIN, DEFAULT_FONT_SIZE));
            g2d.drawString(myText, this.getWidth() / 2 
                           - this.getWidth() / LOCATION_SEPARATOR, 
                           this.getHeight() / 2 - this.getHeight() / (LOCATION_SEPARATOR * 2));
        } else {
            myTextTimer.stop();
            myCounter = 0;
            myDrawText = false;
        }              
        this.drawGrid(g2d, 
                      this.getWidth(), this.getHeight());     
    }

    /**
     * Paint the current piece on this panel.
     * 
     * @param theGraphics the Graphics context used to paint the current piece.
     */
    private void drawCurrentPiece(final Graphics2D theGraphics) {
        if (myPiece != null) {
            final int[][] boardCoordinates =
                      Objects.requireNonNull(((AbstractPiece) myPiece).getBoardCoordinates());
            for (int outer = 0; outer < boardCoordinates.length; outer++) {
                final int[] a = boardCoordinates[outer];
                for (int inner = 0; inner < a.length; inner++) {
                    final int translatedX = a[0] * this.getWidth() / NUMBER_BLOCKS_X;
                    final int translatedY = (NUMBER_BLOCKS_Y - a[1]) 
                                                    * this.getHeight() / NUMBER_BLOCKS_Y
                                                    - this.getHeight() / NUMBER_BLOCKS_Y;
                    theGraphics.setColor(((AbstractPiece) myPiece).getBlock().getColor());

//                    theGraphics.fill(new Rectangle2D.Double(translatedX, translatedY,
//                                     this.getWidth() / NUMBER_BLOCKS_X, 
//                                     this.getHeight() / NUMBER_BLOCKS_Y));
                    theGraphics.fill(new RoundRectangle2D.Double(translatedX, translatedY,
                                                            this.getWidth() / NUMBER_BLOCKS_X, 
                                                            this.getHeight() / NUMBER_BLOCKS_Y,
                                                            9, 9));
                }
            }
        }
    }
    
    /**
     * Paint the frozen blocks on this panel.
     * 
     * @param theGraphics the Graphics context used to paint the current piece.
     */
    private void drawFrozenBlocks(final Graphics2D theGraphics) {
        if (myFrozenBlocks != null) {
            int counterY = this.getHeight() - this.getHeight() / NUMBER_BLOCKS_Y;
            for (int i = 0; i < myFrozenBlocks.size(); i++) {
                final Block[] blocks = myFrozenBlocks.get(i);               
                int counterX = 0;
                for (int j = 0; j < blocks.length; j++) {                  
                    if (blocks[j] != Block.EMPTY) {
                        theGraphics.setColor(blocks[j].getColor());
                        theGraphics.fill(new Rectangle2D.Double(counterX, counterY, 
                                         this.getWidth() / NUMBER_BLOCKS_X, 
                                         this.getHeight() / NUMBER_BLOCKS_Y));
                    }
                    counterX += this.getWidth() / NUMBER_BLOCKS_X;
                }
                counterY = counterY - this.getHeight() / NUMBER_BLOCKS_Y;
            }
        }
    }
    /**
     * Draw a grid on the drawing area. The grid will be on top of any other drawings.
     * 
     * @param theGraphics The drawing area's graphics context
     * @param theWidth The drawing area's width
     * @param theHeight The drawing area's height
     */
    private void drawGrid(final Graphics2D theGraphics, 
                          final int theWidth, final int theHeight) {

        //The default width of each side of the squares of the grid is 1 pixel.
        theGraphics.setStroke(new BasicStroke(1));

        theGraphics.setColor(Color.DARK_GRAY);

        //Draw vertical lines
        for (int i = 0; i < theWidth; i += theWidth / NUMBER_BLOCKS_X) {
            theGraphics.drawLine(i, 0, i, theHeight);
        }
        //Draw horizontal lines
        for (int j = 0; j < theHeight; j += theHeight / NUMBER_BLOCKS_Y) {
            theGraphics.drawLine(0, j, theWidth, j);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Observable theObject, final Object theArg) {
        if (theObject instanceof Board) {
            if (((Board) theObject).getCurrentPiece() != null
                                            || ((Board) theObject).getFrozenBlocks() != null) {
                myPiece = ((Board) theObject).getCurrentPiece();
                myFrozenBlocks = ((Board) theObject).getFrozenBlocks();
            }
            repaint();         
        }
    }
    /** 
     * {@inheritDoc}
     * 
     * Change the text to the according values.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("Level Up".equals(theEvent.getPropertyName())) {
            myDrawText = true;
            switch (((StatisticPanel) theEvent.getSource()).getMyLevel()) {
                case 2: 
                    myText = "GOOD!"; break;
                case 3: 
                    myText = "NICE!"; break;
                case 4: 
                    myText = "HURRAY!"; break;
                case 5: 
                    myText = "YEAH!!"; break;
                case 6: 
                    myText = "O M G!"; break;
                case 7: 
                    myText = "W O W!"; break;
                case 8: 
                    myText = "WICKED!"; break;
                default:
                    myText = " ";
                    break;

            }
        }
    }
    /** 
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myCounter++;
    }
}
