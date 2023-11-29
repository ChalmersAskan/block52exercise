package oopd_gu_chalmers.polygonModel.adapter;

import java.awt.*;

/**
 * Created by Niklas on 2016-02-21.
 *
 * The purpose of this class is to turn an object of type
 *     DIT953.polygonModel.shapes.Polygon
 * into an object of type
 *     DIT953.polygonModel.adapter.Polygon
 */
/* package-private */ class PolygonWrapper implements Polygon {
    private final oopd_gu_chalmers.polygonModel.shapes.Polygon wrappedPolygon;

    PolygonWrapper(oopd_gu_chalmers.polygonModel.shapes.Polygon toBeWrapped) {
        this.wrappedPolygon = toBeWrapped;
    }

    @Override
    public void paint(Graphics g) { //A view function in a model?
        wrappedPolygon.paint(g);
    }

    /* This is where the magic happens */
    @Override
    public void updateCenter(int newX, int newY) {
        Point oldCenter = wrappedPolygon.getCenterPoint();
        wrappedPolygon.translate(newX - oldCenter.x, newY - oldCenter.y);
    }

    @Override
    public int getCenterX() {
        return wrappedPolygon.getCenterPoint().x;
    }

    @Override
    public int getCenterY() {
        return wrappedPolygon.getCenterPoint().y;
    }
}
