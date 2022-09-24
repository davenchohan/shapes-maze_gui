package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

/**
 * An abstract base class that implements the Shape interface.
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public abstract class ShapeImpl implements Shape {
    private int locationX;
    private int locationY;
    private int width;
    private int height;
    private Color color = Color.ORANGE;
    private char borderChar = '*';

    public ShapeImpl(int locationX, int locationY, int width, int height) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getLocationX() {
        return locationX;
    }

    @Override
    public int getLocationY() {
        return locationY;
    }

    @Override
    public void setBorderChar(char borderChar) {
        this.borderChar = borderChar;
    }

    @Override
    public char getBorderChar() {
        return borderChar;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = locationX; i < locationX + width; i++) {
            for (int j = locationY; j < locationY + height; j++) {
                if (isBorder(i, j)) {
                    canvas.setCellText(i, j, borderChar);
                    canvas.setCellColor(i, j, color);
                } else if (isInside(i, j)) {
                    canvas.setCellText(i, j, ' ');
                    canvas.setCellColor(i, j, color);
                }
            }
        }
    }

    protected abstract boolean isBorder(int x, int y);

    protected abstract boolean isInside(int x, int y);
}
