package com.pa.pattern.mvc;

import com.pa.pattern.mvc.controller.GroupController;
import com.pa.pattern.mvc.model.Group;
import com.pa.pattern.mvc.view.GroupUI;

public class FactoryMVCGroup {

    public static GroupUI create()
    {
        Group model = new Group("PA-123");
        GroupUI view = new GroupUI(model);
        GroupController controller = new GroupController(view, model);
        view.setTriggers(controller);
        return view;
    }
}
