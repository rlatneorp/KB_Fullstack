package org.scoula.test.exam01;

import org.scoula.lib.cli.Application;

public class TestApplication extends Application {
    @Override
    protected void createMenu() {
        System.out.println("메뉴를 구성합니다");
    }
}
