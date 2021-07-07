package com.github.dawnflyc.tp6gen;

import com.github.dawnflyc.tp6gen.analyze.spec.AbstractAnalyze;
import com.github.dawnflyc.tp6gen.analyze.spec.SimpleAnalyze;
import com.github.dawnflyc.processtree.IScanResultHandler;
import com.github.dawnflyc.processtree.Result;
import com.github.dawnflyc.processtree.ScanNode;

import java.util.HashSet;
import java.util.Set;

@ScanNode(target = AbstractAnalyze.class ,packageName = "com.github.dawnflyc.tp6gen.analyze",recursive = false)
public class ScanHandler implements IScanResultHandler<AbstractAnalyze> {

    public static Set<AbstractAnalyze> ANALYZES = new HashSet<>();

    @Override
    public void handle(Result<AbstractAnalyze> result) {
        ANALYZES = result.build();
    }

}
