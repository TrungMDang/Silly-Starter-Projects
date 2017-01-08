/*
 * TCSS 305D Autumn 2014
 * Assignment 1 - Testing
 */

package tests;

import static org.junit.Assert.*;

import circle.Circle;

import java.awt.Color;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the Circle class.
 * 
 * @author Trung Dang
 * @version 04 October 2014
 */
public final class CircleTest {

    /** A tolerance used when comparing double values for equality. */
    private static final double MAX_TOLERANCE = .000001;

    /** An instance field to hold the new circle for testing. */
    private Circle myCircle;

    /**
     * This method initializes a new test Circle for each test methods.
     */
    @Before
    public void setUp() {
        myCircle = new Circle();
    }

    /**
     * Test the constructor when the radius is less than 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCircleConstructorInvalidRadius() {
        new Circle(-1, new Point(), Color.BLACK);
    }

    /**
     * Test the constructor when the center point is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCircleConstructorNullCenter() {
        new Circle(1, null, Color.BLACK);
    }

    /**
     * Test the constructor when the color is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCircleConstructorNullColor() {
        new Circle(1, new Point(), null);
    }

    /**
     * Test method for {@link Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius() {
        myCircle.setRadius(2.0);
        assertEquals("setRadius method fails to set radius correctly", 2.0,
                     myCircle.getRadius(), MAX_TOLERANCE);
    }

    /**
     * Test method for {@link Circle#setRadius(double)} with less than 0 radius.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusNegative() {
        myCircle.setRadius(-1.0);
    }

    /**
     * Test method for {@link Circle#setCenter(Point)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetCenter() {
        final Point testPoint = new Point(2, 2);
        myCircle.setCenter(testPoint);
        assertEquals("setCenter method fails to set center correctly", testPoint,
                     myCircle.getCenter());

        // Call in the code that results in the expected exception.
        myCircle.setCenter(null);
    }

    /**
     * Test method for {@link Circle#setColor(Color)}.
     */
    @Test
    public void testSetColor() {
        myCircle.setColor(Color.BLUE);
        assertEquals("setColor fails to set color correctly", Color.BLUE, myCircle.getColor());
    }

    /**
     * Test method for {@link Circle#setColor(Color)} when the color is null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetColorNull() {
        myCircle.setColor(null);
    }

    /**
     * Test method for {@link Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter() {
        myCircle.setRadius(2.0);
        assertEquals("calculateDiamter fails to calculate the correct diameter", 2 * 2.0,
                     myCircle.calculateDiameter(), MAX_TOLERANCE);
    }

    /**
     * Test method for {@link Circle#calculateCircumference()}. Note: The bug
     * had been fixed.
     */
    @Test
    public void testCalculateCircumference() {
        myCircle.setRadius(2.0);
        assertEquals("calculateCircumference fails to calculate the correct circumference",
                     2 * Math.PI * 2.0, myCircle.calculateCircumference(), MAX_TOLERANCE);
    }

    /**
     * Test method for {@link Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {
        myCircle.setRadius(2.0);
        assertEquals("calculateDiamter fails to calculate the correct diameter",
                     Math.PI * Math.pow(2.0, 2), myCircle.calculateArea(), MAX_TOLERANCE);
    }

    /**
     * Test method for {@link Circle#toString()}.
     */
    @Test
    public void testToString() {
        myCircle = new Circle(2.0, new Point(2, 2), Color.BLUE);
        assertEquals("toSting methods fail to produce a correct string",
                     "Circle [radius=2.00, center=java.awt.Point[x=2,y=2], "
                                     + "color=java.awt.Color[r=0,g=0,b=255]]",
                     myCircle.toString());
    }
}
