package ca.cmpt213.a3.shapes;

/**
 * A class that extends the ShapeImpl class in order to construct
 * a rectangle given the size and coordinates.
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public class Rectangle extends ShapeImpl {
    public Rectangle(int locationX, int locationY, int width, int height) {
        super(locationX, locationY, width, height);
    }

    @Override
    protected boolean isBorder(int x, int y) {
        if (x == getLocationX()) {
            return true;
        } else if (x == getLocationX() + getWidth() - 1) {
            return true;
        } else if (y == getLocationY()) {
            return true;
        } else if (y == getLocationY() + getHeight() - 1) {
            return true;
        }
        if (getLocationX() + getWidth() > getLocationX() + 2) {
            if (x == getLocationX() + 1) {
                return true;
            } else if (x == getLocationX() + getWidth() - 2) {
                return true;
            }
        }
        if (getLocationY() + getHeight() > getLocationY() + 2) {
            if (y == getLocationY() + 1) {
                return true;
            } else if (y == getLocationY() + getHeight() - 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean isInside(int x, int y) {
        if (x > getLocationX() && x < getLocationX() + getWidth() - 1) {
            return true;
        } else if (y > getLocationY() && y < getLocationY() + getHeight() - 1) {
            return true;
        }
        return false;
    }
}
