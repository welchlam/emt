package com.welch.emt.ui.util;


import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;

/**
 * Created by Administrator on 2017-6-4.
 */
public class UIHelper {

    public static void showErrorNotification(String header, String errorMsg, Position position){
        Notification error = new Notification(header, "<br/> " + errorMsg, Notification.Type.ERROR_MESSAGE, true);
        error.setPosition(position);
        error.show(Page.getCurrent());
    }

    //vaadin 7 API
    /*public static Tree createTree(){
        Tree tree = new Tree();
        tree.addItem("买家");
        tree.setChildrenAllowed("买家", true);
        tree.addItem("卖家");
        tree.setChildrenAllowed("卖家", true);

        String[] buyers = new String[]{"大熊", "小明", "小二","A", "B", "C", "D", "E", "F", "G"};
        String[]  sales= new String[]{"张三","李四","王五","A", "B", "C", "D", "E", "F", "G"};
        for(String buyer: buyers){
            tree.addItem(buyer);
            tree.setParent(buyer, "买家");
        }
        for (String sale: sales) {
            tree.addItem(sale);
            tree.setParent(sale, "卖家");
        }
        tree.expandItem("买家");
        tree.expandItem("卖家");

        return tree;
    }*/

    //vaadin 8 API
    public static Tree<String> createTree(){
        Tree<String> tree = new Tree<>("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的好友");
        tree.setCaptionAsHtml(true);

        TreeData<String> data = new TreeData<>();
        data.addItems(null, "买家", "卖家")
                .addItems("买家", "张三", "李四", "王五", "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1", "I1", "J1")
                .addItems("卖家", "大熊", "小明", "小二", "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2", "I2", "J2");
                //.addItems("小二","A","B","C","D");

        tree.setDataProvider(new TreeDataProvider<>(data));
        tree.expand("买家", "卖家");
        tree.setItemIconGenerator(item -> {
            if (item.equals("买家")) {
                return VaadinIcons.USER_STAR;
            } else if (item.equals("卖家")) {
                return VaadinIcons.USERS;
            }
            return null;
        });

        tree.addItemClickListener(itemClick -> {
           System.out.println(itemClick.getItem());
        });

        return tree;
    }
}
