package MilitaryElite;

public class Mission implements Miss {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s MilitaryElite.State: %s%n", this.codeName, this.state.getState());
    }
}
