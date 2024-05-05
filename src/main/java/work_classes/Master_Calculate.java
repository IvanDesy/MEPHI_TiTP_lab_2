package work_classes;

import statistic_classes.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Master_Calculate {
    private Map<String, statysticsInterface> statObjects = new HashMap<>();
    private Map<String, List<?>> allResults = new HashMap<>();
    private List<List<Double>> columns;
    private  List<String>labels;

    public Master_Calculate() {
        statObjects.put("Оценка стандартного отклонения", new StandardDeviationTask3());
        statObjects.put("Доверительный интервал для мат. ожидания", new ConfidenceIntervalTask8());
        statObjects.put("Количество элементов", new QuantityElemTask6());
        statObjects.put("Среднее арефметическое", new MeanTask2());
        statObjects.put("Максимальное значение", new MaximumTask10());
        statObjects.put("Минимальное значение", new MinimumTask10());
        statObjects.put("Среднее геометрическое", new GeometricMeanTask1());
        statObjects.put("Коэффициент вариации", new CoefficientVariationTask7());
        statObjects.put("Оценка дисперсии", new VarianceTask9());
        statObjects.put("Размах", new RangeTask4());
        statObjects.put("Ковариация", new CovariationTask5());
    }

    public void read(String file, String name) throws IOException {
        Reader reader = new Reader();
        Map<String, List<Double>> data  = reader.readFromExcel(file, name);
        labels = new ArrayList<>(data.keySet());
        columns = new ArrayList<>(data.values());

        }


    public void calculateAll() {
        for (Map.Entry<String, statysticsInterface> entry : statObjects.entrySet()) {
            String name = entry.getKey();
            statysticsInterface calc = entry.getValue();
            try {
                calc.calculate(columns);
                allResults.put(name, calc.getResult());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public Map<String, List<?>> getAllResults() {
        return allResults;
    }

    public void write() throws IOException{
            Writer.write(allResults, labels, "calculated_statistics");



}}
