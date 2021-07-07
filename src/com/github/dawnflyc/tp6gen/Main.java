package com.github.dawnflyc.tp6gen;

import com.github.dawnflyc.processtree.ProcessTree;

public class Main {

    public static final String packageName =Main.class.getPackage().getName();

    public static void main(String[] args) {
        ProcessTree processTree = new ProcessTree(packageName);
        processTree.start();
        Core core = new Core();
        core.start();
    }
}
