package com.github.dawnflyc.tp6gen.analyze;

import com.github.dawnflyc.tp6gen.analyze.spec.ParamAnalyze;

import java.util.List;
import java.util.regex.Pattern;

public class AnalDb extends ParamAnalyze {
    @Override
    protected String name() {
        return "db";
    }

    @Override
    protected void after() {
        if (!param.containsKey("var")){
            text.insert(0,"$res = ");
        }
        text.append(";\r\n");
    }

    private void _var(int index){
        text.append("$");
        text.append(data[index+1]);
        text.append(" = ");
    }

    private void _name(int index){
        text.append(".name('"+data[index+1]+"')");
    }

    private void _where(int index){
        if (data[index+1].matches("\".*\"")){
            text.append(".where("+data[index+1]+")");
        }else {

        }
    }
}
