package com.welch.emt.ui.layout;

import com.welch.emt.model.Order;
import com.welch.emt.ui.EmtUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-6-9.
 */
public class OrderLayout extends EmtVerticalLayout {

    public OrderLayout(EmtUI emtUI){
        super(emtUI);
    }

    /*public void init(){
        this.setSizeFull();
        this.setSpacing(false);
        this.setMargin(true);
        this.initContent();
    }*/

    protected void initContent(){
        Grid<Order> grid = new Grid<>();
        grid.setHeight(100, Unit.PERCENTAGE);
        grid.addStyleName(ValoTheme.TABLE_SMALL);
        grid.addColumn(Order::getName).setCaption("订单名称");
        grid.addColumn(Order::getStatus).setCaption("状态");
        grid.addColumn(Order::getAmount).setCaption("总额（元）");

        List<Order> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Order order = new Order();
            order.setName("订单： " + i);
            order.setStatus("处理中");
            order.setAmount(10000);
            list.add(order);
        }
        grid.setItems(list);
        grid.addItemClickListener(itemClick -> {
            if(itemClick.getMouseEventDetails().isDoubleClick()){
                System.out.println(itemClick.getItem().getName());
            }
        });
        this.addComponent(grid);
    }
}
