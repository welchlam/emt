package com.welch.emt.ui.layout;

import com.welch.emt.ui.EmtUI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Administrator on 2017-6-9.
 */
public abstract class EmtVerticalLayout extends VerticalLayout {
    protected EmtUI emtUI;

    public EmtVerticalLayout(EmtUI emtUI){
        this.emtUI = emtUI;
        this.init();
    }

    public void init(){
        this.setSizeFull();
        this.setSpacing(false);
        this.setMargin(true);
        this.initContent();
    }

    protected abstract void initContent();
}
