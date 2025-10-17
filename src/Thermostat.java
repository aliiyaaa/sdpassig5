public class Thermostat implements Device {
    private String name;
    private boolean isActive;

    public Thermostat(String name) {
        this.name = name;
        this.isActive = false;
    }

    @Override
    public String operate() {
        if (isActive) {
            return name + " is already active";
        } else {
            isActive = true;
            return name + " activated";
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String turnOff() {
        if (!isActive) {
            return name + " is already off";
        } else {
            isActive = false;
            return name + " turned off";
        }
    }
}