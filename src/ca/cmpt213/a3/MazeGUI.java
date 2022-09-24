package ca.cmpt213.a3;

import ca.cmpt213.a3.UI.Canvas;
import ca.cmpt213.a3.UI.CanvasIcon;
import ca.cmpt213.a3.maze.*;

import javax.swing.*;
import java.awt.*;

/**
 * A program to display a generated maze in a GUI
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public class MazeGUI {
    // Default size of the panels
    private static final int SIZE_X = 20;
    private static final int SIZE_Y = 16;
    // Creates the Maze
    private static final Maze maze = new Maze();

    public static void main(String[] args) {
        Canvas canvas = new Canvas(SIZE_X, SIZE_Y);
        draw(canvas);

        JFrame frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(new JLabel(new CanvasIcon(canvas)));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void draw(Canvas canvas) {
        MazeCell[][] myMaze = maze.getMyMaze();
        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                if (myMaze[y][x].getCellType() == CellType.WALL) {
                    canvas.setCellColor(x, y, Color.BLACK);
                }
            }
        }
    }


}
