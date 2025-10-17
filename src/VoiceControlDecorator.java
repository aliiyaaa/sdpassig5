public class VoiceControlDecorator extends DeviceDecorator {

    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public String operate() {
        return device.operate() + " [Voice Control]";
    }

    @Override
    public String getName() {
        return device.getName() + " (Voice)";
    }

    @Override
    public String turnOff() {
        return device.turnOff() + " [Voice Control]";
    }
}