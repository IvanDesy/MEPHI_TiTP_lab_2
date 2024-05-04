package statistic_classes;

import org.apache.commons.math3.stat.StatUtils;
import work_classes.Reader;

import java.util.ArrayList;
import java.util.List;

public class MaximumTask10 implements statysticsInterface {
    private List<Double> result = new ArrayList<>();

    @Override
    public void calculate(List<List<Double>> columns) {
        result = new ArrayList<>();
        for (List<Double> column : columns) {
            double maximum = StatUtils.max(column.stream().mapToDouble(Double::doubleValue).toArray());
            result.add(maximum);
        }
    }

    @Override
    public List<Double> getResult() {
        return result;
    }
}
