public enum TemperatureMinMax {
    MIN("Minimal"),
    MAX("Maximal");

    private String name;

    TemperatureMinMax(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
