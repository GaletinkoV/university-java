import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DigitalSignal {
    private static double m;

    public static int getDynamicSignalRange(List<Integer> numbers) { 
        return numbers.stream().max(Comparator.comparingInt(o -> o)).get() - numbers.stream().min(Comparator.comparingInt(o -> o)).get();
    }

    public static int getSignalEnergy(List<Integer> numbers) {     
        return numbers.stream().reduce(0, (a, b) -> a + b * b);
    }

    public static double getAverageSignalPower(List<Integer> numbers) {
        return (double) numbers.stream().reduce(0, (a, b) -> a + b * b) / numbers.size();
    }

    public static double getAverageValueOfSignalReadings(List<Integer> numbers) {
        double ms = (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();
        DigitalSignal.m = ms;
        
        return ms;
    }

    public static double getVarianceOfSignalReadings(List<Integer> numbers) {
        DigitalSignal.getAverageValueOfSignalReadings(numbers);
        
        return  numbers.stream().mapToDouble(v -> v).reduce(0, DigitalSignal::add) / numbers.size();
    }

    private static double add(double a, double b) {
        return a + (b - m) * (b - m);
    }

    public static List<Double> getDiscreteSignalAutocorrelationFunction(List<Integer> numbers) {
        List<Double> result = new ArrayList<>();
    
        for (int t = 0; t <= 5; t++) {
        	double temporary = 0;
        	
            for (int i = 0; i < numbers.size() - t - 1; i++) {
            	temporary += (numbers.get(i + t) - m) * (numbers.get(i) - m);
            }
            result.add(temporary / numbers.size() - t);
        }
        
        return result;
    }

    public static double getCorrelationInterval(List<Integer> numbers, List<Double> autocorrelation) {
        double Rxxj = 0;
        double Rxx0 = 0;
        
        for (Double aDouble : autocorrelation) {
            Rxxj += aDouble;
        }
        for (int i = 0, t = 0; i < numbers.size() - t - 1; i++) {
            Rxx0 += (numbers.get(i + t) - m) * (numbers.get(i) - m);
        }
    
        return Rxxj / Rxx0;
    }

}