class Device{
    int deviceId;
    String status;
    public Device(int deviceId, String status){
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus(){
        System.out.println("ID of the device is: " + deviceId + " Status of device is: " + status);
    }
}
class Thermostat extends Device{
    double temperatureSetting;
    public Thermostat(int deviceId, String status, double temperatureSetting){
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    public void displayStatus(){
        super.displayStatus();
        System.out.println("Temperature : " + temperatureSetting);
    }
}
public class SmartHomeDevices {
    public static void main(String[] args) {
        Thermostat therm = new Thermostat(125,"ACTIVE",78.85);
        therm.displayStatus();
    }
}
