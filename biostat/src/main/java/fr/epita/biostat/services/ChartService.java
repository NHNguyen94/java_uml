package fr.epita.biostat.services;

import org.knowm.xchart.*;

import java.util.*;

public class ChartService {

    private final Integer chartWidth;
    private final Integer chartHeight;

    public ChartService(Integer chartWidth, Integer chartHeight) {
        this.chartWidth = chartWidth;
        this.chartHeight = chartHeight;
    }

    public void drawBarChart(Map<String, Long> data,
                             String chartTitle,
                             String xTitle,
                             String yTitle,
                             String seriesName) {
        CategoryChart chart = new CategoryChartBuilder()
                .width(chartWidth)
                .height(chartHeight)
                .title(chartTitle)
                .xAxisTitle(xTitle)
                .yAxisTitle(yTitle)
                .build();
        List<String> labelInput = new ArrayList<>(data.keySet());
        List<Long> valueInput = new ArrayList<>(data.values());
        chart.addSeries(seriesName, labelInput, valueInput);
        new SwingWrapper<>(chart).displayChart();
    }

    public void drawScatterChart(Map<Integer, Double> data,
                                 String chartTitle,
                                 String xTitle,
                                 String yTitle,
                                 String seriesName) {
        XYChart chart = new XYChartBuilder()
                .width(chartWidth)
                .height(chartHeight)
                .title(chartTitle)
                .xAxisTitle(xTitle)
                .yAxisTitle(yTitle)
                .build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        List<Integer> labelInput = new ArrayList<>(data.keySet());
        List<Double> valueInput = new ArrayList<>(data.values());
        chart.addSeries(seriesName, labelInput, valueInput);
        new SwingWrapper<>(chart).displayChart();
    }

    public void drawPieChart(Map<String, Long> data,
                             String chartTitle) {
        PieChart chart = new PieChartBuilder()
                .width(chartWidth)
                .height(chartHeight)
                .title(chartTitle)
                .build();
        data.forEach((key, value) -> chart.addSeries(key, value));
        new SwingWrapper<>(chart).displayChart();
    }
}
