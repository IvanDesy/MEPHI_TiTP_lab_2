package statistic_classes;

import work_classes.Reader;

import java.util.ArrayList;
import java.util.List;

public class QuantityElemTask6 implements statysticsInterface {
    private List<Integer> result = new ArrayList<>();

    @Override
    public void calculate(List<List<Double>> columns) {
        result = new ArrayList<>();
        for (List<Double> column : columns) {
            Integer quantity = column.size();
            result.add(quantity);
        }
    }

    @Override
    public List<Integer> getResult() {
        return result;
    }
}
