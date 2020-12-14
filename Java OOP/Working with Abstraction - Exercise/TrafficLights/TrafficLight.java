package TrafficLights;

public class TrafficLight {
    private Colour colour;

    public TrafficLight(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return this.colour;
    }

    public void update() {
        switch(colour) {
            case RED:
                this.colour = Colour.GREEN;
                break;
            case GREEN:
                this.colour = Colour.YELLOW;
                break;
            case YELLOW:
                this.colour = Colour.RED;
                break;
        }
    }
}
