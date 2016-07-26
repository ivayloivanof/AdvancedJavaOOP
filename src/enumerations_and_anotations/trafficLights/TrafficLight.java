package enumerations_and_anotations.trafficLights;

public class TrafficLight {
    private Signals signal;

    public TrafficLight(Signals signal) {
        this.signal = signal;
    }

    public void update(){
        switch (this.signal){
            case RED:
                this.signal = Signals.GREEN;
                break;

            case GREEN:
                this.signal = Signals.YELLOW;
                break;

            case YELLOW:
                this.signal = Signals.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}
