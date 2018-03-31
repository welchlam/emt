package com.welch.emt.ui;

//import UserService;
import com.welch.emt.service.UserService;
import com.welch.emt.ui.layout.OrderLayout;
import com.welch.emt.ui.layout.OrderStatisticLayout;
import com.welch.emt.ui.util.UIHelper;
import com.welch.emt.ui.window.LoginWindow;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Widgetset;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017-5-26.
 */
@Widgetset("EmtWidgetset")
@SpringUI(path = EmtUI.rootUri)
@PreserveOnRefresh
public class EmtUI extends UI {
    public static final String rootUri = "/emt";

    private static Logger Log = LoggerFactory.getLogger(EmtUI.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LoginWindow loginWindow;

    private Panel mainPanel = null;

    private Panel workPanel = null;

    //private VerticalLayout workArea = null;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //this.welcome();
        Log.info("Initializing main UI.");
        if(this.getUI().getCurrent().getSession().getAttribute("user") != null){
            this.welcome();
        }else{
            //this.userService.appUserInit();
            this.addLoginWindow();
        }
    }

    private void addLoginWindow(){
        this.getUI().getCurrent().addWindow(this.loginWindow.init(this));
    }

    public void welcome(){
        String user = (String) this.getUI().getCurrent().getSession().getAttribute("user");
        this.mainPanel = new Panel("网上跟单系统 - 用户：" + user);
        this.mainPanel.setSizeFull();
        this.setContent(this.mainPanel);
        this.initMainPanel();
    }

    private void initMainPanel(){
        HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setSplitPosition(15, Unit.PERCENTAGE);
        //horizontalSplitPanel.setLocked(true);
        this.mainPanel.setContent(horizontalSplitPanel);
        VerticalLayout leftLayout = new VerticalLayout();
        VerticalLayout rightLayout = new VerticalLayout();
        horizontalSplitPanel.addComponent(leftLayout);
        horizontalSplitPanel.addComponent(rightLayout);
        this.initLeftLayout(leftLayout);
        this.initRightLayout(rightLayout);
    }

    private void initLeftLayout(VerticalLayout leftLayout){
        leftLayout.setSizeFull();
        leftLayout.setMargin(false);
        leftLayout.setSpacing(false);

        Tree tree = UIHelper.createTree();
        leftLayout.addComponent(tree);
    }

    private void initRightLayout(VerticalLayout rightLayout){
        rightLayout.setSizeFull();
        rightLayout.setMargin(false);
        rightLayout.setSpacing(false);

        this.initMenuArea(rightLayout);
        this.workPanel = new Panel();
        this.workPanel.setSizeFull();
        rightLayout.addComponent(workPanel);
        this.initWorkArea();

        VerticalLayout footer = new VerticalLayout();
        footer.setMargin(false);
        footer.setSpacing(false);
        footer.setHeight("20px");
        footer.setWidth(100, Unit.PERCENTAGE);
        rightLayout.addComponent(footer);
        //rightLayout.setComponentAlignment(footer, Alignment.TOP_CENTER);
        Label label = new Label("@2017 XX公司 网上跟单系统 京ICP证000000号  京公网安备00000000000000号 <br><br/>", ContentMode.HTML);
        label.addStyleName(ValoTheme.LABEL_SMALL);
        rightLayout.addComponent(label);
        rightLayout.setComponentAlignment(label, Alignment.TOP_CENTER);

        rightLayout.setExpandRatio(workPanel, 1);
    }

    private void initMenuArea(VerticalLayout rightLayout){
        /////////////////////////////////////////////////////////////////////////
        MenuBar.Command command = (MenuBar.Command) menuItem -> {
            if(menuItem.getText().equals("退出")){
                this.logout();
            }else if(menuItem.getText().equals("详情")){
                this.showOrders();
            }else if(menuItem.getText().equals("统计")){
                this.initWorkArea();
            }
        };
        /////////////////////////////////////////////////////////////////////////
        MenuBar menuBar = new MenuBar();
        menuBar.setStyleName(ValoTheme.MENUBAR_SMALL);
        menuBar.setHeight("40px");
        menuBar.setWidth("100%");
        rightLayout.addComponent(menuBar);
        rightLayout.setComponentAlignment(menuBar, Alignment.TOP_LEFT);

        MenuBar.MenuItem menuItem0 = menuBar.addItem("订单", VaadinIcons.CALC_BOOK, null);
        menuItem0.addItem("详情", VaadinIcons.LIST, command);
        menuItem0.addItem("统计", VaadinIcons.BAR_CHART_V, command);

        for (int i = 0; i < 3; i++) {
            MenuBar.MenuItem menuItem = menuBar.addItem("功能 " + i, VaadinIcons.ACCORDION_MENU, null);
            for (int j = 0; j < 3; j++) {
                menuItem.addItem("子功能 " + j, VaadinIcons.MENU, null);
            }
        }

        MenuBar.MenuItem menuItem = menuBar.addItem("用户", VaadinIcons.USER, null);
        menuItem.addItem("退出", VaadinIcons.EXIT, command);
        menuItem.addItem("帮助", VaadinIcons.QUESTION, null);
        menuItem.addItem("关于", VaadinIcons.INFO, null);
    }

    private void initWorkArea(){
        this.workPanel.setCaption("销售统计");
        this.workPanel.setContent(new OrderStatisticLayout(this));
    }

    private void showOrders(){
        this.workPanel.setCaption("详情");
        this.workPanel.setContent(new OrderLayout(this));
    }

    private void logout(){
        this.getUI().getCurrent().getPage().setLocation(EmtUI.rootUri);
        this.getUI().getCurrent().getSession().getSession().invalidate();
    }
}
