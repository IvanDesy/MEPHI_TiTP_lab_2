package statistic_classes;

import org.apache.commons.math3.stat.StatUtils;
import work_classes.Reader;

import java.util.ArrayList;
import java.util.List;

public class StandardDeviationTask3 implements statysticsInterface {
    private static List<Double> result = new ArrayList<>();
    @Override
    public void calculate(List<List<Double>> columns) {
        result = new ArrayList<>();
        for (List<Double> column : columns) {
            double sd = StatUtils.variance((column.stream().mapToDouble(Double::doubleValue).toArray()));
            result.add(Math.sqrt(sd));
        }
    }

    @Override
    public List<Double> getResult() {
        return result;
    }
}

