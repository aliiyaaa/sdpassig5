public class Light implements Device {
    private String name;
    private boolean isOn;

    public Light(String name) {
        this.name = name;
        this.isOn = false;
    }

    @Override
    public String operate() {
        if (isOn) {
            return name + " is already on";
        } else {
            isOn = true;
            return name + " turned on";
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String turnOff() {
        if (!isOn) {
            return name + " is already off";
        } else {
            isOn = false;
            return name + " turned off";
        }
    }
}