public enum Aggregationstates {
    GAS("Gasförmig"),
    LIQUID("Flüssig"),
    SOLID("Fest");

    private final String state;

    Aggregationstates(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

}
