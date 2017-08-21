package com.welch.emt.ui.layout;

import com.welch.emt.ui.EmtUI;
import com.welch.emt.ui.chart.ChartDemo;

/**
 * Created by Administrator on 2017-6-9.
 */
public class OrderStatisticLayout extends EmtVerticalLayout{

    public OrderStatisticLayout(EmtUI emtUI){
        super(emtUI);
    }

    @Override
    protected void initContent() {
        ChartDemo chartDemo = new ChartDemo();
        this.addComponent(chartDemo.getChart());
    }
}
