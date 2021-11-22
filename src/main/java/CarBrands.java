public enum CarBrands {
    BMW("BMW"),
    MERCEDES("Mercedes Benz"),
    VW("Volkswagen"),
    HYUNDAI("Hyundai");

    private String carBrandName;

    CarBrands(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarBrandName() {
        return carBrandName;
    }
}
