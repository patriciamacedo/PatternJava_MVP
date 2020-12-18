package com.pa.pattern.mvp;

import com.pa.pattern.mvp.presenter.GroupPresenter;
import com.pa.pattern.mvp.model.Group;
import com.pa.pattern.mvp.view.GroupUI;

public class FactoryMVPGroup {

    public static GroupUI create()
    {
        Group model = new Group("PA-123");
        GroupUI view = new GroupUI(model);
        GroupPresenter presenter = new GroupPresenter(view, model);
        view.setTriggers(presenter);
        return view;
    }
}
