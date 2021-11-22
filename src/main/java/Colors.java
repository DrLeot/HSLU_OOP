public enum Colors {
    RED("Rot"),
    BLUE("Blau"),
    GREEN("Grün");

    private final String colorname;

    Colors(String colorname) {
        this.colorname = colorname;
    }

    public String getColorname() {
        return colorname;
    }
}
