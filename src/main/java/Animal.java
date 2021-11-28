public class Animal {

    private String name;

    public Animal(String name){
        this.name = name;
    }

    public String getWert() {
        return name;
    }

    @Override
    public String toString(){
        return "Der Name des Tiers lautet "+this.name+".";
    }


}
