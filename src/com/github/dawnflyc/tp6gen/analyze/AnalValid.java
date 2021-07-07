package com.github.dawnflyc.tp6gen.analyze;

import com.github.dawnflyc.tp6gen.analyze.spec.SimpleAnalyze;

public class AnalValid extends SimpleAnalyze {
    @Override
    protected String name() {
        return "valid";
    }

    protected void main(){
        if(this.data.length == 3){
            this.text.append("if(!$"+this.data[1]+")\r\n");
            this.text.append("{\r\n");
            this.text.append("\tthrow new ValidateException('"+this.data[2]+"');\r\n");
            this.text.append("}\r\n");
        }
    }
}
