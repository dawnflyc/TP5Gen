package com.github.dawnflyc.tp6gen.analyze;

import com.github.dawnflyc.tp6gen.analyze.spec.SimpleAnalyze;

public class AnalVar extends SimpleAnalyze {


    @Override
    public String name() {
        return "var";
    }

    protected void main(){
        switch (this.data[1]){
            case "uid":
                if(this.data.length == 2){
                    this.text.append("$uid = $this->request->uid;\r\n");
                }else{
                    this.text.append("$"+this.data[2]+" = $this->request->uid;\r\n");
                }
                break;
            case "param":
                if(this.data.length == 3){
                    this.text.append("$"+this.data[2]+" = $this->request->get('"+this.data[2]+"');\r\n");
                }else if (this.data.length == 4){
                    this.text.append("$"+this.data[2]+" = $this->request->"+this.data[3]+"('"+this.data[2]+"');\r\n");
                }
                break;
            default:
                if (this.data.length == 3){
                    this.text.append("$"+this.data[2]+" = "+this.data[3]+";\r\n");
                }
                break;
        }
    }
}
