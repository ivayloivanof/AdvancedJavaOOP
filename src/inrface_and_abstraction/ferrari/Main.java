package inrface_and_abstraction.ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ivanof on 7/14/16.
 */
public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String driver = br.readLine();
            Ferrari car = new Car("488-Spider", driver, true, true);
            if (car.getBrakes() && car.getGasPedal()) {
                System.out.printf("%s/%s/%s/%s%n",
                        car.getModel(),
                        "Brakes!",
                        "Zadu6avam sA!",
                        car.getDriver());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Car implements Ferrari {

    private String model;
    private String driver;
    private boolean brakes;
    private boolean gasPedal;

    public Car(String model, String driver, boolean brakes, boolean gasPedal) {
        this.model = model;
        this.driver = driver;
        this.brakes = brakes;
        this.gasPedal = gasPedal;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public boolean getBrakes() {
        return this.brakes;
    }

    @Override
    public boolean getGasPedal() {
        return this.gasPedal;
    }
}

interface Ferrari {
    String getModel();
    String getDriver();
    boolean getBrakes();
    boolean getGasPedal();
}