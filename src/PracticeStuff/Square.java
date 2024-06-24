package PracticeStuff;

public class Square implements Shape {
    private double edgeLength;
    @Override
    public double getArea() {
        return edgeLength * edgeLength;
    }
    @Override
    public double getVolume() {
        return 0;
    }
    public void setEdgeLength(double a) {
        edgeLength = a;
    }
    public double getEdgeLength() {
        return edgeLength;
    }
}
