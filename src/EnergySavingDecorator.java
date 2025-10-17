public class EnergySavingDecorator extends DeviceDecorator {

    public EnergySavingDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        return device.operate() + " [Energy Saving]";
    }

    @Override
    public String getName() {
        return device.getName() + " (Energy Saving)";
    }

    @Override
    public String turnOff() {
        return device.turnOff() + " [Energy Saving]";
    }
}