import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HomeAutomationFacade facade = new HomeAutomationFacade();
    private static List<Device> customDevices = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== Home Automation System ===");
        System.out.println("Demonstrating Facade, Decorator, and Factory Patterns");
        System.out.println("=====================================================");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    demonstrateFacadePattern();
                    break;
                case 2:
                    demonstrateDecoratorPattern();
                    break;
                case 3:
                    demonstrateFactoryPattern();
                    break;
                case 4:
                    showAllDevices();
                    break;
                case 5:
                    testCustomDevice();
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Facade Pattern Demo");
        System.out.println("2. Decorator Pattern Demo");
        System.out.println("3. Factory Pattern Demo");
        System.out.println("4. Show All Devices");
        System.out.println("5. Test Custom Device");
        System.out.println("6. Exit");
        System.out.println("==================");
    }
    
    private static void demonstrateFacadePattern() {
        System.out.println("\n=== FACADE PATTERN DEMONSTRATION ===");
        System.out.println("The Facade pattern provides a simplified interface to a complex subsystem.");
        System.out.println("Our HomeAutomationFacade manages multiple devices with simple methods.\n");
        
        System.out.println("Available Facade Operations:");
        System.out.println("1. Night Mode");
        System.out.println("2. Party Mode");
        System.out.println("3. Leave Home");
        System.out.println("4. Add Voice Control to all devices");
        
        int choice = getIntInput("Choose an operation: ");
        
        switch (choice) {
            case 1:
                System.out.println("\n--- Night Mode ---");
                facade.activateNightMode();
                break;
            case 2:
                System.out.println("\n--- Party Mode ---");
                facade.startPartyMode();
                break;
            case 3:
                System.out.println("\n--- Leave Home ---");
                facade.leaveHome();
                break;
            case 4:
                System.out.println("\n--- Adding Voice Control ---");
                facade.addVoiceControl();
                System.out.println("Voice control added to all devices!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void demonstrateDecoratorPattern() {
        System.out.println("\n=== DECORATOR PATTERN DEMONSTRATION ===");
        System.out.println("The Decorator pattern allows adding new functionality to objects dynamically.");
        System.out.println("We can wrap devices with different decorators.\n");
        
        // Create a basic device
        Device basicLight = new Light("Basic Light");
        System.out.println("Basic Device: " + basicLight.getName());
        System.out.println("Operation: " + basicLight.operate());
        
        System.out.println("\nAvailable Decorators:");
        System.out.println("1. Voice Control");
        System.out.println("2. Energy Saving");
        System.out.println("3. Remote Access");
        System.out.println("4. Multiple Decorators (Chain)");
        
        int choice = getIntInput("Choose a decorator: ");
        
        Device decoratedDevice = basicLight;
        
        switch (choice) {
            case 1:
                decoratedDevice = new VoiceControlDecorator(basicLight);
                break;
            case 2:
                decoratedDevice = new EnergySavingDecorator(basicLight);
                break;
            case 3:
                decoratedDevice = new RemoteAccessDecorator(basicLight);
                break;
            case 4:
                System.out.println("Creating a chain of decorators...");
                decoratedDevice = new VoiceControlDecorator(
                    new EnergySavingDecorator(
                        new RemoteAccessDecorator(basicLight)
                    )
                );
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("\n--- Decorated Device ---");
        System.out.println("Name: " + decoratedDevice.getName());
        System.out.println("Operation: " + decoratedDevice.operate());
        System.out.println("Turn Off: " + decoratedDevice.turnOff());
    }
    
    private static void demonstrateFactoryPattern() {
        System.out.println("\n=== FACTORY PATTERN DEMONSTRATION ===");
        System.out.println("The Factory pattern creates objects without specifying their exact classes.");
        System.out.println("We can create devices using the DeviceFactory.\n");
        
        System.out.println("Available Device Types:");
        String[] deviceTypes = DeviceFactory.getAvailableDeviceTypes();
        for (int i = 0; i < deviceTypes.length; i++) {
            System.out.println((i + 1) + ". " + deviceTypes[i]);
        }
        
        int deviceChoice = getIntInput("Choose device type: ");
        if (deviceChoice < 1 || deviceChoice > deviceTypes.length) {
            System.out.println("Invalid choice!");
            return;
        }
        
        String deviceName = getStringInput("Enter device name: ");
        
        // Map choice to device type constant
        String deviceType;
        switch (deviceChoice) {
            case 1:
                deviceType = DeviceFactory.DeviceType.LIGHT;
                break;
            case 2:
                deviceType = DeviceFactory.DeviceType.MUSIC;
                break;
            case 3:
                deviceType = DeviceFactory.DeviceType.CAMERA;
                break;
            case 4:
                deviceType = DeviceFactory.DeviceType.THERMOSTAT;
                break;
            default:
                deviceType = DeviceFactory.DeviceType.LIGHT;
        }
        
        System.out.println("\nAvailable Decorators:");
        String[] decorators = DeviceFactory.getAvailableDecorators();
        for (int i = 0; i < decorators.length; i++) {
            System.out.println((i + 1) + ". " + decorators[i]);
        }
        System.out.println((decorators.length + 1) + ". No Decorator");
        
        int decoratorChoice = getIntInput("Choose decorator (or " + (decorators.length + 1) + " for none): ");
        
        Device createdDevice;
        if (decoratorChoice == decorators.length + 1) {
            createdDevice = DeviceFactory.createDevice(deviceType, deviceName);
        } else if (decoratorChoice >= 1 && decoratorChoice <= decorators.length) {
            String decoratorType;
            switch (decoratorChoice) {
                case 1:
                    decoratorType = "voice";
                    break;
                case 2:
                    decoratorType = "energy";
                    break;
                case 3:
                    decoratorType = "remote";
                    break;
                default:
                    decoratorType = "voice";
            }
            createdDevice = DeviceFactory.createDeviceWithDecorator(deviceType, deviceName, decoratorType);
        } else {
            System.out.println("Invalid choice! Creating device without decorator.");
            createdDevice = DeviceFactory.createDevice(deviceType, deviceName);
        }
        
        System.out.println("\n--- Created Device ---");
        System.out.println("Name: " + createdDevice.getName());
        System.out.println("Operation: " + createdDevice.operate());
        System.out.println("Turn Off: " + createdDevice.turnOff());
        
        customDevices.add(createdDevice);
        System.out.println("Device added to custom devices list!");
    }
    
    private static void showAllDevices() {
        System.out.println("\n=== ALL DEVICES ===");
        System.out.println("Custom Devices:");
        if (customDevices.isEmpty()) {
            System.out.println("No custom devices created yet.");
        } else {
            for (int i = 0; i < customDevices.size(); i++) {
                Device device = customDevices.get(i);
                System.out.println((i + 1) + ". " + device.getName());
                System.out.println("   Status: " + device.operate());
            }
        }
        
        System.out.println("\nFacade Devices (from HomeAutomationFacade):");
        System.out.println("These are managed by the facade and not directly accessible.");
    }
    
    private static void testCustomDevice() {
        if (customDevices.isEmpty()) {
            System.out.println("No custom devices available. Create some using the Factory Pattern demo first!");
            return;
        }
        
        System.out.println("\n=== TEST CUSTOM DEVICE ===");
        System.out.println("Available Custom Devices:");
        for (int i = 0; i < customDevices.size(); i++) {
            System.out.println((i + 1) + ". " + customDevices.get(i).getName());
        }
        
        int choice = getIntInput("Choose device to test: ");
        if (choice < 1 || choice > customDevices.size()) {
            System.out.println("Invalid choice!");
            return;
        }
        
        Device device = customDevices.get(choice - 1);
        
        System.out.println("\n--- Testing Device ---");
        System.out.println("Name: " + device.getName());
        System.out.println("Operation: " + device.operate());
        System.out.println("Turn Off: " + device.turnOff());
        System.out.println("Operation Again: " + device.operate());
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
            return getIntInput(prompt);
        }
    }
    
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}