/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */

package view;

import features.SoundPlayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Board;



/**
 * This class creates a graphical user interface for Tetris game.
 * 
 * @author Trung Dang
 * @version November 25, 2014
 */
public class TetrisGUI implements ActionListener, PropertyChangeListener {

    /***/
    private static final String MUSIC_FILE_PATH = "resources/sounds/arcade theme.wav";
    /** A constant for the Board's height.*/
    private static final int DEFAULT_BOARD_HEIGHT = 20;

    /** A constant for the Board's width.*/
    private static final int DEFAULT_BOARD_WIDTH = 10;

    /** Default speed of the game.*/
    private static final int DEFAULT_INTERVAL = 800;

    /** A toolkit.*/
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();

    /** Hold the screen size of the current display.*/
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    /** Hold the width of the screen.*/
    private static final int SCREEN_WIDTH = SCREEN_SIZE.width;

    /** Hold the height of the screen.*/
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height;

    /** A name for the program.*/
    private static final String TITLE = "Tetris";

    /** A default spacing in pixels for components.*/
    private static final int DEFAULT_SPACING = 5;

    /** The default width of the Tetris GUI.*/
    private static final int DEFAULT_WIDTH = 565;

    /** The default height of the Tetris GUI.*/
    private static final int DEFAULT_HEIGHT = 660;
    
    /** The current game speed will decrease by 5% with every level.*/
    private static final double INTERVAL_DECREASE_PERCENTAGE = 0.95;

    /** A frame to contain all the component for the program.*/
    private final JFrame myFrame;
    
    /** A menu bar.*/
    private JMenuBar myMenuBar;
    
    /** A panel to display statistics of the game.*/
    private StatisticPanel myStat;

    /** The game's Board that is to be placed blocks on.*/   
    private Board myBoard;

    /** Hold a key control bindings option.*/
    private KeyBindings myKeys;

    /** The timer to inject events periodically.*/
    private Timer myTimer;
    
    /** A list of KeyListeners.*/
    private KeyListener[] myListeners;
    
    /** A removed listener that to be added back.*/
    private KeyListener myRemovedListener;
   
    /** A sound player object.*/
    private SoundPlayer mySoundPlayer;

    /**
     * Construct a new TetrisGUI with default values.
     */
    public TetrisGUI() {
        myFrame = new JFrame(TITLE);
        myFrame.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
      
        try {
            setUpGUI();
        } catch (final IOException e) {
            e.printStackTrace();
        }     
        myFrame.pack();
        myFrame.setLocation(SCREEN_WIDTH / 2 - myFrame.getWidth() / 2, SCREEN_HEIGHT / 2
                            - myFrame.getHeight() / 2);
        myFrame.setVisible(true);
    }

    /**
     * A helper method to set up the Tetris GUI.
     * 
     * @throws IOException
     */
    private void setUpGUI() throws IOException {
        myTimer = new Timer(DEFAULT_INTERVAL, this);
        myBoard = new Board();
        
        myFrame.addKeyListener(new MyKeyListener());
        myFrame.addKeyListener(new MyCommandListener());
        
        myListeners = myFrame.getKeyListeners();
        
        //A notification that the game has paused when using the pause key
        final JPanel p = (JPanel) myFrame.getGlassPane();
        p.add(new JLabel("Game Paused!", JLabel.CENTER));

        myKeys = new KeyBindings();
        mySoundPlayer = new SoundPlayer();
     
        readIcon();
        addPanels();
        myTimer.start();
        mySoundPlayer.loop(MUSIC_FILE_PATH);
        addMenuBar();     
    }

    /**
     * Read and set the icon of the frame into the given icon.
     */
    private void readIcon() {
        try {                              
            myFrame.setIconImage(ImageIO.read(new File("resources/icons/tetris-icon.png")));
        } catch (final IOException e) {
            e.printStackTrace();
        }  
    }

    /**
     * A helper method to add to the TetrisGUI necessary panels.
     */
    private void addPanels() {
        final JPanel superVerticalPanel = new JPanel();
        superVerticalPanel.setLayout(new BoxLayout(superVerticalPanel, BoxLayout.PAGE_AXIS));
        superVerticalPanel.add(
            Box.createRigidArea(new Dimension(myFrame.getWidth(), DEFAULT_SPACING)));

        final JPanel superHorizontalPanel = new JPanel();
        superHorizontalPanel.setLayout(
            new BoxLayout(superHorizontalPanel, BoxLayout.LINE_AXIS));   
        superHorizontalPanel.add(
            Box.createRigidArea(new Dimension(DEFAULT_SPACING, myFrame.getHeight())));
        
        final GamePanel game = new GamePanel();
        superHorizontalPanel.add(game);

        final JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));

        final PreviewPanel preview = new PreviewPanel();
        createPanelBorder(preview);
        rightPanel.add(preview);
        rightPanel.add(
            Box.createRigidArea(new Dimension(preview.getWidth(), DEFAULT_SPACING)));

        myStat = new StatisticPanel(myTimer);
        createPanelBorder(myStat);
        rightPanel.add(
                       Box.createRigidArea(new Dimension(myStat.getWidth(), DEFAULT_SPACING)));
        rightPanel.add(myStat);

        final ControlPanel control = new ControlPanel(myKeys);
        createPanelBorder(control);
        rightPanel.add(
            Box.createRigidArea(new Dimension(control.getWidth(), DEFAULT_SPACING)));
        rightPanel.add(control);

        superHorizontalPanel.add(
            Box.createRigidArea(new Dimension(DEFAULT_SPACING, myFrame.getHeight()))); 
        superHorizontalPanel.add(rightPanel);
        superHorizontalPanel.add(
            Box.createRigidArea(new Dimension(DEFAULT_SPACING, myFrame.getHeight())));
        superVerticalPanel.add(superHorizontalPanel);
        superVerticalPanel.add(
            Box.createRigidArea(new Dimension(myFrame.getWidth(), DEFAULT_SPACING)));
        myFrame.add(superVerticalPanel);
        registerObservers(game);
        registerObservers(preview);
        registerObservers(myStat);
        myStat.addPropertyChangeListener(this);
        myStat.addPropertyChangeListener(game);
        registerObservers(control);
    }

    /**
     * Register the Observer to Tetris Board.
     * 
     * @param theObserver the Observer that need to be added to Tetris Board
     */
    private void registerObservers(final Observer theObserver) {
        myBoard.addObserver(theObserver);  
    }

    /**
     * Set border on the parameter JPanel.
     * 
     * @param thePanel the JPanel that need to be painted with borders.
     */
    private void createPanelBorder(final JPanel thePanel) {
        final Border top = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
            Color.BLUE), thePanel.getName(), TitledBorder.CENTER, TitledBorder.TOP, 
            null, Color.WHITE);
        final Border bottom = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
            Color.BLUE), "******", TitledBorder.CENTER, TitledBorder.BOTTOM, 
            null, Color.WHITE);    
        thePanel.setBorder(BorderFactory.createCompoundBorder(top, bottom));
    }

    /**
     * A helper method to create a MenuBar at the default location on the JFrame.
     */
    private void addMenuBar() {
        myMenuBar = new MenuBar(myFrame, myBoard, myTimer, mySoundPlayer);
        myFrame.setJMenuBar(myMenuBar);
        myMenuBar.addPropertyChangeListener(this);   
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Object[] options = {"New Game", "Exit Game"};
        if (myBoard.isGameOver()) {
            mySoundPlayer.stopAll();
            mySoundPlayer.play("resources/sounds/game over.wav");
            myTimer.stop();
            removeKeyListeners();
            final int selected = JOptionPane.showOptionDialog(null, 
                 "Game is Over! Please select an option", "Game Over", 
                 JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
                 null, options, null);
            if (selected == JOptionPane.YES_OPTION) {
                myTimer.start();
                myTimer.setDelay(DEFAULT_INTERVAL);
                mySoundPlayer.play(MUSIC_FILE_PATH);
                myFrame.addKeyListener(myRemovedListener);
                myBoard.newGame(DEFAULT_BOARD_WIDTH, DEFAULT_BOARD_HEIGHT, null);
            } else if (selected == JOptionPane.NO_OPTION) {
                myTimer.stop();
                myFrame.dispatchEvent(
                                      new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
            }
        } else {
            myBoard.step(); 
        }        
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("stop".equals(theEvent.getPropertyName())) {
            myTimer.stop();
            mySoundPlayer.stopAll();
            removeKeyListeners();      
        } else if ("new game".equals(theEvent.getPropertyName())) {
            myBoard.newGame(DEFAULT_BOARD_WIDTH, DEFAULT_BOARD_HEIGHT, null);
            myFrame.addKeyListener(new MyKeyListener());
            myTimer.setDelay(DEFAULT_INTERVAL);
            mySoundPlayer.loop(MUSIC_FILE_PATH);
            myTimer.start();
        } else if ("Level Up".equals(theEvent.getPropertyName())) {
            myTimer.setDelay((int) (myTimer.getDelay() * INTERVAL_DECREASE_PERCENTAGE));
        } else if ("selected".equals(theEvent.getPropertyName())) {
            mySoundPlayer.stop(MUSIC_FILE_PATH);
        } else if ("unselected".equals(theEvent.getPropertyName())) {
            mySoundPlayer.loop(MUSIC_FILE_PATH);
        }
    }

    /**
     * 
     */
    private void removeKeyListeners() {
        for (int i = 0; i < myListeners.length; i++) {
            if ("MyKeyListener".equals(myListeners[i].getClass().getSimpleName())) {
                myRemovedListener = myListeners[i];
                myFrame.removeKeyListener(myRemovedListener); 
            }                
        }       
    }
    /****************************************************************************************/
    /**
     * This class provides listener for KEY PRESSED event.
     * 
     * @author Trung Dang
     * @version November 27, 2014
     */
    private class MyKeyListener implements KeyListener {      
        /**
         * {@inheritDoc}
         */
        @Override
        public void keyPressed(final KeyEvent theEvent) {
            if (theEvent.getKeyCode() == myKeys.getMyLeft()) {
                myBoard.moveLeft();
            } else if (theEvent.getKeyCode() == myKeys.getMyRight()) {
                myBoard.moveRight();
            } else if (theEvent.getKeyCode() == myKeys.getMyDown()) {
                myBoard.moveDown();
            } else if (theEvent.getKeyCode() == myKeys.getMyHardDrop()) {
                myBoard.hardDrop();
                mySoundPlayer.play("resources/sounds/drop.wav");
            } else if (theEvent.getKeyCode() == myKeys.getMyRotateCW()) {
                myBoard.rotateCW();
            }
        }
        
        /** 
         * {@inheritDoc}
         */
        @Override
        public void keyReleased(final KeyEvent theEvent) {
            //Do something
        }
        /** 
         * {@inheritDoc}
         */
        @Override
        public void keyTyped(final KeyEvent theEvent) {
            //Do something
        }
    }
    
    /**
     * This class provides listener for pause, resume, save event.
     * 
     * @author Trung Dang
     * @version December 2, 2014 
     */
    private class MyCommandListener implements KeyListener {

        @Override
        public void keyTyped(final KeyEvent theEvent) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyPressed(final KeyEvent theEvent) {
            if (theEvent.getKeyCode() == myKeys.getMySave()) {
                //Still working on this.               
            } else if (theEvent.getKeyCode() == myKeys.getMyResume()) {     
                myMenuBar.getMenu(0).getItem(0).setEnabled(true); //get "Pause"
                myFrame.addKeyListener(myRemovedListener);
                myFrame.getGlassPane().setVisible(false);
                myTimer.start();
            } else if (theEvent.getKeyCode() == myKeys.getMyPause()) {
                removeKeyListeners();
                myMenuBar.getMenu(0).getItem(0).setEnabled(false); //get "Pause"
                myFrame.getGlassPane().setVisible(true);
                myTimer.stop();
            }
        }

        @Override
        public void keyReleased(final KeyEvent theEvent) {
            // TODO Auto-generated method stub
            
        }        
    }
}
