public class SecurityCamera implements Device {
    private String name;
    private boolean isRecording;

    public SecurityCamera(String name) {
        this.name = name;
        this.isRecording = false;
    }

    @Override
    public String operate() {
        if (isRecording) {
            return name + " is already recording";
        } else {
            isRecording = true;
            return name + " started recording";
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String turnOff() {
        if (!isRecording) {
            return name + " is already off";
        } else {
            isRecording = false;
            return name + " turned off";
        }
    }
}