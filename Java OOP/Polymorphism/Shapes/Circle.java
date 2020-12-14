public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        setArea(Math.PI * this.radius * this.radius);
    }

    public final Double getRadius() {
        return radius;
    }
}
