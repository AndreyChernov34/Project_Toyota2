package proekt.cars.car_components;

public abstract class Components {
    public boolean functional;

    public Components(boolean functional) {
        this.functional = functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public boolean isFunctional() {
        return functional;
    }
}
