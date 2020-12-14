public abstract class Shape {
    private Double perimeter;
    private Double area;
    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public abstract void calculatePerimeter();
    public abstract void calculateArea();
    public Double getPerimeter() {
        return this.perimeter;
    }
    public Double getArea() {
        return this.area;
    }
    public void setArea(Double area) {
        this.area = area;
    }

}
