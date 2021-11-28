public enum Aggregationstates {
    GAS("Gasförmig"),
    LIQUID("Flüssig"),
    SOLID("Fest"),
    PLASMA("Plasma");

    private final String state;

    Aggregationstates(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

}
