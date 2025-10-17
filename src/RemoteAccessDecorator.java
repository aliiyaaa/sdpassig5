public class RemoteAccessDecorator extends DeviceDecorator {

    public RemoteAccessDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        return device.operate() + " [Remote Access]";
    }

    @Override
    public String getName() {
        return device.getName() + " (Remote)";
    }

    @Override
    public String turnOff() {
        return device.turnOff() + " [Remote Access]";
    }
}