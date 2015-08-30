package com.alfredvc.graphics;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Grid2D extends JPanel
{
    private final int xSize;
    private final int ySize;
    private static final int DEFAULT_REFRESH_PERIOD = 100; //ms
    private final int gridSizePixels;
    private Color[][] grid;
    private final Color defaultBackgroundColor;

    public Grid2D(int ySize, int xSize, int gridSizePixels, Color defaultBackgroundColor) {
        this.ySize = ySize;
        this.xSize = xSize;
        this.defaultBackgroundColor = defaultBackgroundColor;
        this.grid = new Color[xSize][ySize];
        paintBackground();
        this.gridSizePixels = gridSizePixels;
        setPreferredSize(new Dimension(gridSizePixels * xSize, gridSizePixels * ySize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        int rectWidth = getWidth() / ySize;
        int rectHeight = getHeight() / xSize;

        for (int x = 0; x < xSize; x++){
            for (int y = 0; y < ySize; y++) {
                g.setColor(grid[x][ySize - 1 - y]);
                g.fillRect(x * rectWidth, y * rectHeight, rectWidth, rectHeight);
            }
        }

    }

    public void setPoints(List<Point> points, Color color) {
        for (Point point : points) {
            setPoint(point, color);
        }
    }

    public void setPoint(Point point, Color color) {
        grid[point.x][point.y] = color;
    }

    private void paintBackground() {
        for (int x = 0; x < xSize; x++){
            for (int y = 0; y < ySize; y++) {
                grid[x][y] = defaultBackgroundColor;
            }
        }
    }

    public Color getColor(int x, int y) {
        return grid[x][y];
    }


}
