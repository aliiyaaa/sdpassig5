public class DeviceFactory {
    

    public static class DeviceType {
        public static final String LIGHT = "LIGHT";
        public static final String MUSIC = "MUSIC";
        public static final String CAMERA = "CAMERA";
        public static final String THERMOSTAT = "THERMOSTAT";

        private DeviceType() {}
    }
    
    public static Device createDevice(String type, String name) {
        switch (type) {
            case DeviceType.LIGHT:
                return new Light(name);
            case DeviceType.MUSIC:
                return new MusicSystem(name);
            case DeviceType.CAMERA:
                return new SecurityCamera(name);
            case DeviceType.THERMOSTAT:
                return new Thermostat(name);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
    
    public static Device createDeviceWithDecorator(String type, String name, String decoratorType) {
        Device device = createDevice(type, name);
        
        switch (decoratorType.toLowerCase()) {
            case "voice":
                return new VoiceControlDecorator(device);
            case "energy":
                return new EnergySavingDecorator(device);
            case "remote":
                return new RemoteAccessDecorator(device);
            default:
                return device;
        }
    }
    
    public static String[] getAvailableDeviceTypes() {
        return new String[]{"Light", "Music System", "Security Camera", "Thermostat"};
    }
    
    public static String[] getAvailableDecorators() {
        return new String[]{"Voice Control", "Energy Saving", "Remote Access"};
    }
}
