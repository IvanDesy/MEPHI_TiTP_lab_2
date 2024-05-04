package statistic_classes;

import java.util.List;

public interface statysticsInterface {
    void calculate(List<List<Double>> columns);
    List<?> getResult();
}
