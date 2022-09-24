package ca.cmpt213.a3.maze;

/**
 * A class that creates a cell within the Maze. Each cell has a position, it's wall state, the type of Cell
 * it is and whether it has been visited or not.
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public class MazeCell {
    private boolean isWall;
    private boolean isVisited;
    private CellType cellType;
    private int xPosition;
    private int yPosition;

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public MazeCell(boolean isWall) {
        this.isWall = isWall;
        isVisited = false;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setWall(boolean wall) {
        isWall = wall;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }


    public void setCellType(CellType type) {
        switch (type) {
            case WALL:
                cellType = CellType.WALL;
                break;
            case EMPTY:
                cellType = CellType.EMPTY;
                break;
            default:
                assert false;
        }
    }


    public CellType getCellType() {
        return cellType;
    }
}
