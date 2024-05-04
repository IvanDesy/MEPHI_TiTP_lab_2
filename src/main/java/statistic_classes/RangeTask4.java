package statistic_classes;

import org.apache.commons.math3.stat.StatUtils;
import work_classes.Reader;

import java.util.ArrayList;
import java.util.List;

public class RangeTask4 implements statysticsInterface {

    private static List<Double> result = new ArrayList<>();

    @Override
    public void calculate(List<List<Double>> columns) {
        result = new ArrayList<>();
        for (List<Double> column : columns) {
            double range = StatUtils.max(column.stream().mapToDouble(Double::doubleValue).toArray()) - StatUtils.min(column.stream().mapToDouble(Double::doubleValue).toArray());
            result.add(range);
        }
    }
    @Override
    public List<Double> getResult() {
        {
            return result;
    }
}}

