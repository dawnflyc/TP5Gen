package com.github.dawnflyc.tp6gen.analyze;

import com.github.dawnflyc.tp6gen.analyze.spec.ParamAnalyze;
import com.github.dawnflyc.tp6gen.analyze.spec.SimpleAnalyze;

public class AnalFun extends SimpleAnalyze {
    @Override
    protected String name() {
        return "fun";
    }

    @Override
    protected void main() {
        if(this.data.length == 2){
            if("end".equals(this.data[1])){
                this.text.append("}\r\n");
            }else {
                this.text.append("function "+this.data[1]+"(){\r\n");
            }
        }
        if(this.data.length == 3){
            String [] param = this.data[2].split(",");
            if(param.length>0){
                this.text.append("function "+this.data[1]+"("+data[2]+"){\r\n");
            }
        }
    }


}
