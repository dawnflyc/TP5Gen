package com.github.dawnflyc.tp6gen.analyze.spec;

public abstract class SimpleAnalyze extends AbstractAnalyze {

    abstract protected void main();

    protected void analyze(){
        this.main();
    }
}
