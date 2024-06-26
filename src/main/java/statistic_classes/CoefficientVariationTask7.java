package statistic_classes;

import org.apache.commons.math3.stat.StatUtils;
import work_classes.Reader;

import java.util.ArrayList;
import java.util.List;

public class CoefficientVariationTask7 implements statysticsInterface {
    private List<Double> result = new ArrayList<>();

    @Override
    public void calculate(List<List<Double>> columns) {
        result = new ArrayList<>();
        List<Double> sd = new ArrayList<>();
        for (List<Double> column : columns) {
            double ssdd = StatUtils.variance((column.stream().mapToDouble(Double::doubleValue).toArray()));
            sd.add(Math.sqrt(ssdd));
        }
        List<Double> mean = new ArrayList<>();
        for (List<Double> column : columns) {
            double mn = StatUtils.mean(column.stream().mapToDouble(Double::doubleValue).toArray());
            mean.add(mn);
        }
        for (int ind = 0; ind < columns.size(); ind++) {
            double cv = sd.get(ind) / mean.get(ind);
            result.add(cv);
        }
    }

    @Override
    public List<Double> getResult() {
        return result;
    }
}
