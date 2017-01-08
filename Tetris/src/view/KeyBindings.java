/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

/**
 * This class provides key control options.
 * 
 * @author Trung Dang
 * @version November 27, 2014
 */
@SuppressWarnings("serial")
public final class KeyBindings extends AbstractAction {

    /** KeyCode for moving left.*/
    private int myLeft;
    
    /** KeyCode for moving right.*/
    private int myRight;

    /** KeyCode for moving down.*/
    private int myDown;

    /** KeyCode for dropping hard.*/
    private int myHardDrop;

    /** KeyCode for rotating CW.*/
    private int myRotateCW;

    /** KeyCode for resuming the game.*/
    private int myResume;

    /** KeyCode for pausing the game.*/
    private int myPause;

    /** KeyCode for saving key.*/
    private int mySave;

    /**
     * Construct a new KeyBindings with default key controls.
     */
    public KeyBindings() {
        super();
        myLeft = KeyEvent.VK_LEFT;
        myRight = KeyEvent.VK_RIGHT;
        myDown = KeyEvent.VK_DOWN;
        myHardDrop = KeyEvent.VK_SPACE;
        myRotateCW = KeyEvent.VK_D;
        myPause = KeyEvent.VK_P;
        myResume = KeyEvent.VK_R;
        mySave = KeyEvent.VK_S;
    }

    /**
     * Determine the key associated with the parameter.
     * 
     * @param theString the name of the key
     * @return An integer indicating a key associated with theString name
     */
    public int determineKeyName(final String theString) {
        int key = 0;
        if ("Move Left".equalsIgnoreCase(theString)) {
            key = this.getMyLeft();
        } else if ("Move Right".equalsIgnoreCase(theString)) {
            key = this.getMyRight();
        } else if ("Move Down".equalsIgnoreCase(theString)) {
            key = this.getMyDown();
        } else if ("Rotate".equalsIgnoreCase(theString)) {
            key = this.getMyRotateCW();
        } else if ("Pause".equalsIgnoreCase(theString)) {
            key = this.getMyPause();
        } else if ("Save".equalsIgnoreCase(theString)) {
            key = this.getMySave();
        }
        return key;   
    }

    /**
     * Get the Moving Left key control.
     * 
     * @return the Moving Left key control
     */
    public int getMyLeft() {
        return myLeft;
    }
    
    /**
     * Get the Moving Right key control.
     * 
     * @return the Moving Right key control
     */
    public int getMyRight() {
        return myRight;
    }
    
    /**
     * Get the Moving Down key control.
     * 
     * @return the Moving Down key control
     */
    public int getMyDown() {
        return myDown;
    }
    
    /**
     * Get the Dropping Hard key control.
     * 
     * @return the Dropping Hard key control
     */
    public int getMyHardDrop() {
        return myHardDrop;
    }
    
    /**
     * Get the Rotating CW key control.
     * 
     * @return the Rotating CW key control
     */
    public int getMyRotateCW() {
        return myRotateCW;
    }
    
    /**
     * Get the Pausing key control.
     * 
     * @return the Pausing key control
     */
    public int getMyPause() {
        return myPause;
    }
    
    /**
     * Get the Resuming key control.
     * 
     * @return the Resuming key control
     */
    public int getMyResume() {
        return myResume;
    }
    
    /**
     * Get the Saving key control.
     * 
     * @return the Saving key control
     */
    public int getMySave() {
        return mySave;
    }
    
    /**
     * Get the RotateCW key control's text name.
     * 
     * @return the text name
     */
    public String getRotateCW() {
        return KeyEvent.getKeyText(myRotateCW);
    }

    /**
     * Get the Resume key control's text name.
     * 
     * @return the text name
     */
    public String getResume() {
        return  KeyEvent.getKeyText(myResume);
    }

    /**
     * Get the Pause key control's text name.
     * 
     * @return the text name
     */
    public String getPause() {
        return KeyEvent.getKeyText(myPause);
    }
    
    /**
     * Get the Save key control's text name.
     * 
     * @return the text name
     */
    public String getSave() {
        return KeyEvent.getKeyText(mySave);
    }

   
    
    /**
     * Get the Moving Left key control's text name.
     * 
     * @return the text name
     */
    public String getLeft() {
        return KeyEvent.getKeyText(myLeft);
    }
    
    /**
     * Get the Moving Right key control's text name.
     * 
     * @return the text name
     */
    public String getRight() {
        return KeyEvent.getKeyText(myRight);
    }
    
    /**
     * Get the Moving Doawn key control's text name.
     * 
     * @return the text name
     */
    public String getDown() {
        return KeyEvent.getKeyText(myDown);
    }
    
    /**
     * Get the Dropping Hard key control's text name.
     * 
     * @return the text name
     */
    public String getHardDrop() {
        return KeyEvent.getKeyText(myHardDrop);
    }

    /**
     * Set the Moving Left control to the specified value.
     * 
     * @param theLeft the key that need to be put into the Moving Left control
     */
    public void setMyLeft(final int theLeft) {
        System.out.println("set left: " + theLeft);
        this.myLeft = theLeft;
    }
    
    /**
     * Set the Moving Right control to the specified value.
     * 
     * @param theRight the key that need to be put into the Moving Right control
     */
    public void setMyRight(final int theRight) {
        this.myRight = theRight;
    }
    
    /**
     * Set the Moving Down control to the specified value.
     * 
     * @param theDown the key that need to be put into the Moving Down control
     */
    public void setMyDown(final int theDown) {
        this.myDown = theDown;
    }
    
    /**
     * Set the Dropping Hard control to the specified value.
     * 
     * @param theHardDrop the key that need to be put into the Dropping Hard control
     */
    public void setMyHardDrop(final int theHardDrop) {
        this.myHardDrop = theHardDrop;
    } 
    
    /**
     * Set the Rotating control to the specified value.
     * 
     * @param theRotateCW the key that need to be put into the Rotating control
     */
    public void setRotateCW(final int theRotateCW) {
        this.myRotateCW = theRotateCW;
    }
    
    /**
     * Set the Pause control to the specified value.
     * 
     * @param thePause the key that need to be put into the Pause control
     */
    public void setMyPause(final int thePause) {
        this.myPause = thePause;
    }
    
    /**
     * Set the Resume control to the specified value.
     * 
     * @param theResume the key that need to be put into the Resume control
     */
    public void setMyResume(final int theResume) {
        this.myResume = theResume;
    }
    
    /**
     * Set the Save control to the specified value.
     * 
     * @param theSave the key that need to be put into the Save control
     */
    public void setMySave(final int theSave) {
        this.mySave = theSave;
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        // TODO Auto-generated method stub
        
    }
}
