package proekt.cars.car_components;

public class Wheel {
    private WheelDiskEnum wheelDisk;
    private boolean puncture;

    public Wheel(WheelDiskEnum wheelDiskEnum) {

        this.wheelDisk = wheelDiskEnum;
    }

    public void setPuncture(boolean puncture) {

        this.puncture = puncture;
    }

    public WheelDiskEnum getWheelDisk() {

        return wheelDisk;
    }

    public boolean isPuncture() {

        return puncture;
    }
}
