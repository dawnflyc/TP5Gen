package com.github.dawnflyc.tp6gen.analyze.spec;

/**
 * 抽象解析器
 */
public abstract class AbstractAnalyze {

    /**
     * 接受参数
     */
    protected String[] data;
    /**
     * 解析结果
     *
     */
    public StringBuilder text = new StringBuilder();

    /**
     * 检查是否可以解析，判断行开始
     * @param name
     * @return
     */
    public boolean check(String name){
        return name.equals(this.name());
    }

    /**
     * 抽象，获取名称
     * @return
     */
    abstract protected String name();

    /**
     * 开始解析
     * @param text
     * @return
     */
    public String run(String[] text) {
        this.text =  new StringBuilder();
        this.data = text;
        this.analyze();
        return this.text.toString();
    }

    /**
     * 抽象解析器处理
     */
    abstract protected  void analyze();
}
