package ca.cmpt213.a3.shapes;

/**
 * A class that extends the ShapeImpl class in order to construct
 * a pyramid given the size and coordinates.
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public class Pyramid extends ShapeImpl {
    public Pyramid(int locationX, int locationY, int width, int height) {
        super(locationX, locationY, width, height);
    }

    @Override
    protected boolean isBorder(int x, int y) {
        int base = getWidth();
        int baseLocation = getLocationY() + getHeight() - 1;
        int levelFromBase = Math.abs(y - baseLocation);
        double left = Math.floor(levelFromBase * (base / (2.0 * getHeight())));
        double right = Math.ceil((base - 1) - levelFromBase * (base / (2.0 * getHeight())));
        if (y == baseLocation) {
            return true;
        }
        if (x == getLocationX() + left) {
            return true;
        }
        if (x == getLocationX() + right) {
            return true;
        }
        if (y == getLocationY() && x > getLocationX() + left && x < getLocationX() + right) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isInside(int x, int y) {
        int base = getWidth();
        int baseLocation = getLocationY() + getHeight() - 1;
        int levelFromBase = Math.abs(y - baseLocation);
        double left = Math.floor(levelFromBase * (base / (2.0 * getHeight())));
        double right = Math.ceil((base - 1) - levelFromBase * (base / (2.0 * getHeight())));
        return x > getLocationX() + left && x < getLocationX() + right;
    }
}
