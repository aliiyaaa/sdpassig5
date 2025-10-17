public class Main {
    public static void main(String[] args) {
        System.out.println("=== Decorator + Facade Demo ===\n");

        System.out.println("1. Decorator Pattern:");
        Device light = new Light("Light");
        System.out.println(light.operate());
        System.out.println(light.turnOff());

        Device voiceLight = new VoiceControlDecorator(light);
        System.out.println(voiceLight.operate());
        System.out.println(voiceLight.turnOff());

        Device smartLight = new EnergySavingDecorator(
                new VoiceControlDecorator(new Light("Smart Light"))
        );
        System.out.println(smartLight.operate());
        System.out.println(smartLight.turnOff());

        System.out.println("\n2. Facade Pattern:");
        HomeAutomationFacade home = new HomeAutomationFacade();
        home.activateNightMode();
        home.startPartyMode();
        home.leaveHome();

        System.out.println("\n3. Combined:");
        home.addVoiceControl();
        home.activateNightMode();
        home.startPartyMode();

        System.out.println("Done!");
    }
}