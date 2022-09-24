package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

/**
 * An interface that specifies methods that need to be implemented in order
 * to draw a shape onto a canvas.
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public interface Shape {

    int getLocationX();

    int getLocationY();

    void setBorderChar(char borderChar);

    char getBorderChar();

    void setColor(Color color);

    Color getColor();

    void draw(Canvas canvas);
}
