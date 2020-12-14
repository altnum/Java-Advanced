package MilitaryElite;

public enum Corps {
    AIRFORCES("Airforces"),
    MARINES("Marines");

    private String corps;

    Corps (String str) {
        this.corps = str;
    }

    public String getCorps() {
        return this.corps;
    }
}

