public class HomeAutomationFacade {
    private Device light;
    private Device music;
    private Device camera;

    public HomeAutomationFacade() {
        this.light = new Light("Living Room Light");
        this.music = new MusicSystem("Home Theater");
        this.camera = new SecurityCamera("Security Camera");
    }

    public void activateNightMode() {
        System.out.println("Night Mode:");
        System.out.println(light.turnOff());
        System.out.println(camera.operate());
    }

    public void startPartyMode() {
        System.out.println("Party Mode:");
        System.out.println(light.operate());
        System.out.println(music.operate());
    }

    public void leaveHome() {
        System.out.println("Leaving Home:");
        System.out.println(light.turnOff());
        System.out.println(music.turnOff());
        System.out.println(camera.operate());
    }

    public void addVoiceControl() {
        this.light = new VoiceControlDecorator(light);
        this.music = new VoiceControlDecorator(music);
        this.camera = new VoiceControlDecorator(camera);
    }
}