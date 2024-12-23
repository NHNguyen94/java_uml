package fr.epita.biostat.services;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

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
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(16);
        List<Integer> labelInput = new ArrayList<>(data.keySet());
        List<Double> valueInput = new ArrayList<>(data.values());
        chart.addSeries(seriesName, labelInput, valueInput);
        new SwingWrapper<>(chart).displayChart();
    }
}
