public class MusicSystem implements Device {
    private String name;
    private boolean isPlaying;

    public MusicSystem(String name) {
        this.name = name;
        this.isPlaying = false;
    }

    @Override
    public String operate() {
        if (isPlaying) {
            return name + " is already playing";
        } else {
            isPlaying = true;
            return name + " started playing music";
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String turnOff() {
        if (!isPlaying) {
            return name + " is already off";
        } else {
            isPlaying = false;
            return name + " turned off";
        }
    }
}
