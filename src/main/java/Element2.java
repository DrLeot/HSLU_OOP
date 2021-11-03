public abstract class Element2 {

    private final String name;
    private final String symbole;
    private int numberOfProtons;

    public Element2(String name, int numberOfProtons, String symbole) {
        this.name = name;
        this.numberOfProtons = numberOfProtons;
        this.symbole = symbole;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfProtons() {
        return numberOfProtons;
    }

    public String getSymbole() {
        return symbole;
    }

    public abstract String light();

    @Override
    public String toString() {
        return symbole + ": " + name;
    }

}
