package com.welch.emt.ui.chart;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-6-4.
 */
public class ChartDemo {

    public Chart getChart() {
        Chart chart = new Chart(ChartType.BAR);

        Configuration conf = chart.getConfiguration();
        chart.setSizeFull();

        conf.setTitle("2016年销售统计");
        conf.setSubTitle("数据来自于本系统交易结果");

        XAxis x = new XAxis();
        x.setCategories("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月");
        x.setTitle((String) null);
        conf.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        AxisTitle title = new AxisTitle("金额（万元）");
        title.setAlign(VerticalAlign.MIDDLE);
        y.setTitle(title);
        conf.addyAxis(y);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.series.name +': '+ this.y +' 万元'");
        conf.setTooltip(tooltip);

        PlotOptionsBar plot = new PlotOptionsBar();
        plot.setDataLabels(new DataLabels(true));
        conf.setPlotOptions(plot);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setAlign(HorizontalAlign.RIGHT);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(-100);
        legend.setY(100);
        legend.setFloating(true);
        legend.setBorderWidth(1);
        legend.setBackgroundColor(new SolidColor("#FFFFFF"));
        legend.setShadow(true);
        conf.setLegend(legend);

        conf.disableCredits();

        List<Series> series = new ArrayList<Series>();
        series.add(new ListSeries("布料", 107, 31, 635, 203, 2, 800, 100, 200, 405, 80, 90, 256));
        series.add(new ListSeries("成衣", 500, 300, 60, 288, 299, 400, 200, 365, 205, 180, 190, 456));
        series.add(new ListSeries("印花", 200, 310, 235, 403, 52, 378, 300, 100, 305, 280, 290, 56));
        conf.setSeries(series);

        chart.drawChart(conf);

        return chart;
    }
}
