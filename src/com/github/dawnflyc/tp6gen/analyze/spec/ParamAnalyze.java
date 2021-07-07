package com.github.dawnflyc.tp6gen.analyze.spec;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class ParamAnalyze extends AbstractAnalyze {

    public Map<String, String> param =new HashMap<>();


    /**
     * 处理前
     */
    protected void before(){}
    /**
     * 处理后
     */
    protected void after(){}

//    private void findParam(){
//        for (int i = 0; i < data.length; i++) {
//            String datum = data[i];
//            if(datum.indexOf("-") == 0){
//                if (i+1 == data.length){
//                    throw new RuntimeException("必须写全参数");
//                }
//                param.put(datum.replace("-",""),data[i+1]);
//            }
//        }
//    }

    @Override
    protected void analyze() {
        before();
//        findParam();
//        for (String key : param.keySet()) {
//            try {
//                Method method =this.getClass().getDeclaredMethod("_"+key);
//                method.setAccessible(true);
//                method.invoke(this, param.get(key));
//            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
        for (int i = 0; i < data.length; i++) {
            String datum = data[i];
            if (datum.indexOf("-") == 0){
                String param =  datum.replace("-", "");
                try {
                    Method method = this.getClass().getDeclaredMethod("_"+param);
                    if (method != null){
                        method.setAccessible(true);
                        method.invoke(this,i);
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        after();
    }
}
