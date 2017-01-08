/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */

package view;

import features.SoundPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Board;


/**
 * This class creates a menu bar for Tetris.
 * 
 * @author Trung Dang
 * @version November 25, 2014
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
    
    /** A constant for the Board's height.*/
    private static final int DEFAULT_BOARD_HEIGHT = 20;

    /** A constant for the Board's width.*/
    private static final int DEFAULT_BOARD_WIDTH = 10;
    
    /** A custom selection to be used for JOptionPane.*/
    private static final int CUSTOM_SELECTION = 3;
    
    /** A list of options.*/
    private static final String[] DEFAULT_OPTIONS = {"Pause", "Resume", "Stop", 
                                                     "New Game", "Stop Game", "Save", 
                                                     "Load Game", "Exit"};
    
    /** A file menu.*/
    private JMenu myFile;
    
    /** An option menu.*/
    private JMenu myOption;
    
    /** The Board that needs to listener to changes from this MenuBar.*/
    private final Board myBoard;
    
    /** A timer.*/
    private final Timer myTimer;

    
    /**
     * Construct a MenuBar with default menus.
     * 
     * @param theFrame the JFrame that reacts to changes from this MenuBar
     * @param theBoard the Board that reacts to changes from this MenuBar
     * @param theTimer theTime that need to be start or stop by using this MenuBar's listener
     * @param thePlayer the sound player that will be asked to play sound 
     * <br>based on this class state
     */
    public MenuBar(final JFrame theFrame, final Board theBoard, final Timer theTimer,
                    final SoundPlayer thePlayer) {
        super();
        myBoard = theBoard;
        myTimer = theTimer;
        setUpFile(theFrame, thePlayer);
        setUpOptions();
        setUpAbout();
    }

    /**
     * A helper method to add File menu to this MenuBar.
     * 
     * @param theFrame the JFrame that reacts to changes from this MenuBar
     * @param thePlayer the sound player that will be asked to play sound 
     * <br>based on this class state
     */
    private void setUpFile(final JFrame theFrame, final SoundPlayer thePlayer) {
        
        //options: resume, save, stop game, and exit
        final Object[] options = {DEFAULT_OPTIONS[1], DEFAULT_OPTIONS[5], 
                                        DEFAULT_OPTIONS[4], 
                                        DEFAULT_OPTIONS[DEFAULT_OPTIONS.length - 1]};
        
        myFile = new JMenu("File");
        
        final JMenuItem pause = new JMenuItem(DEFAULT_OPTIONS[0]);
        final JMenuItem stop = new JMenuItem(DEFAULT_OPTIONS[2]);
        final JMenuItem newGame = new JMenuItem(DEFAULT_OPTIONS[3]);
        
//        final JMenuItem save = new JMenuItem(DEFAULT_OPTIONS[4]);
//        final JMenuItem load = new JMenuItem(DEFAULT_OPTIONS[5]);
        final JMenuItem exit = new JMenuItem(DEFAULT_OPTIONS[DEFAULT_OPTIONS.length - 1]);
       
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myTimer.stop();
                final int selected = JOptionPane.showOptionDialog(null, 
                    "Game Paused! Click Resume to continue.", "Pause", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, 
                    null, options, null);
                checkSelected(selected, theFrame, myTimer);
            }            
        });   

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myTimer.stop();
                thePlayer.stopAll();
                firePropertyChange(DEFAULT_OPTIONS[2], null, null);
                pause.setEnabled(false);
                stop.setEnabled(false);
                newGame.setEnabled(true);
                myOption.getItem(0).setSelected(false);
            }            
        });
       
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                stop.setEnabled(true);
                newGame.setEnabled(false);
                pause.setEnabled(true);
                myBoard.newGame(DEFAULT_BOARD_WIDTH, DEFAULT_BOARD_HEIGHT, null);
                firePropertyChange("new game", null, null);
            }           
        });     
        
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        myFile.add(pause);
        myFile.addSeparator();
        myFile.add(stop);
        myFile.addSeparator();
        newGame.setEnabled(false);
        myFile.add(newGame);
        myFile.addSeparator();
        myFile.add(exit);
        myFile.addSeparator();
        this.add(myFile);
        theFrame.setJMenuBar(this);
    }
    
    /**
     * A helper method to check the option selected by user.
     * 
     * @param theSelected the option chosen by user
     * @param theFrame the JFrame that reacts to changes from this MenuBar
     * @param theTimer theTime that need to be start or stop by using this MenuBar's listener
     */
    private void checkSelected(final int theSelected, final JFrame theFrame, 
                               final Timer theTimer) {
        if (theSelected == 0) {     //resume
            theTimer.start();
        } else if (theSelected == 2) {  //Stop game
            theTimer.stop();
            myFile.getMenuComponent(0).setEnabled(false);    //Get "Pause"
            myFile.getMenuComponent(4).setEnabled(true);    //Get "New Game"
            myFile.getMenuComponent(2).setEnabled(false);   //Get "Stop Game"
            firePropertyChange("stop", null, null);
        } else if (theSelected == CUSTOM_SELECTION) {  //Exit game
            theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
        }
    }
    
    /**
     * A helper method to add Options Menu into this MenuBar.
     */
    private void setUpOptions() {
        myOption = new JMenu("Options");
        final JCheckBoxMenuItem audio = new JCheckBoxMenuItem("Mute Audio");
        audio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (audio.isSelected()) {
                    firePropertyChange("selected", null, null);
                } else {
                    firePropertyChange("unselected", null, null);                
                }
            }          
        });
        myOption.add(audio);
        this.add(myOption);
    }
    
    /**
     * A helper method to add the About menu onto this menu bar.
     */
    private void setUpAbout() {
        final JMenu about = new JMenu("About");
        final JMenuItem credits = new JMenuItem("Credits");
        final JMenuItem score = new JMenuItem("Scoring Details");
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final StringBuilder sb = new StringBuilder(550);
                sb.append("Name: Tetris\nAuthor: Trung M. Dang\nCourse: TCSS 305 D"
                           + " - Programming Practicum\nIntructor: Alan Fowler\n"
                           + "University of Washington - Tacoma\n\nCredits:\n"
                           + "- Tetris theme: Nhaccuatui.com.\n- Mp3cut.net\n"
                              + "- drop.wav: User farbin on FreeSound.org\n"
                              + "- success.wav: User gunz on FreeSound.org\n"
                              + "- game over.wav: User notchfilter on FreeSound.org\n"
                              + "- arcade theme: User tyopos on FreeSound.org\n"
                              + "- level up.wav: User AdamWeeden on FreeSound.org\nIcons:\n"
                              + "- tetris-icon.png: taken from IconArchive.com\n"
                              + "\nAll rights reserved to The Tetris Company.");
                JOptionPane.showMessageDialog(null, sb.toString());
            }
            
        });
        score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, "Scoring formula:\n"
                                              + "Lines cleared * Level * 100\n"
                                              + "\nGame speed:\n"
                                              + "Increase 5% for each level.");               
            }
            
        });        
        about.add(credits);
        about.addSeparator();
        about.add(score);
        this.add(about);
    }
 
}
