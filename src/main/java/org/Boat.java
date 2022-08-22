package org;

import java.awt.*;

public class Boat extends Rectangle {
    public Boat() {
        super();
    }

    public Boat(Rectangle r) {
        super(r);
    }

    public Boat(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Boat(int width, int height) {
        super(width, height);
    }

    public Boat(Point p, Dimension d) {
        super(p, d);
    }

    public Boat(Point p) {
        super(p);
    }

    public Boat(Dimension d) {
        super(d);
    }
}
