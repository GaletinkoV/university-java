import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            List<Integer> numbers = FileReader.readDataFromFile(args[0]);
            List<Double> auto—orrelation = DigitalSignal.getDiscreteSignalAutocorrelationFunction(numbers);
           
            System.out.println("Dynamic signal range: " + DigitalSignal.getDynamicSignalRange(numbers));
            System.out.println("Signal energy: " + DigitalSignal.getSignalEnergy(numbers));
            System.out.println("Average signal power: " + DigitalSignal.getAverageSignalPower(numbers));
            System.out.println("Value of signal readings: " + DigitalSignal.getAverageValueOfSignalReadings(numbers));
            System.out.println("Variance of signal readings: " + DigitalSignal.getVarianceOfSignalReadings(numbers));
            
            for (int i = 0; i < auto—orrelation.size(); i++) {
                System.out.println("t = " + i + " : autocorrelation = " + auto—orrelation.get(i));
            }
            
            System.out.println("Correlation interval: " + DigitalSignal.getCorrelationInterval(numbers, auto—orrelation));
        } else {
            System.err.println("Incorrect input data");
        }
    }
}
