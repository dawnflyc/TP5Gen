package com.github.dawnflyc.tp6gen;

import com.github.dawnflyc.tp6gen.analyze.spec.AbstractAnalyze;
import com.github.dawnflyc.tp6gen.analyze.spec.SimpleAnalyze;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Core {

    private Set<AbstractAnalyze> anals = ScanHandler.ANALYZES;


    public void start(){
        try {
            List<String> lines = readLine("tpi");
            StringBuilder sb =new StringBuilder();
            lines.forEach(s -> {
                String[] param = s.trim().split(" ");
                String name = param[0];
                anals.forEach(analyze -> {
                    if(analyze.check(name)){
                        analyze.run(param);
                        sb.append(analyze.text);
                    }
                });
            });
            this.save("tpo",sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> readLine(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        List<String> list =new ArrayList<>();
        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            list.add(str);
        }
        inputStream.close();
        bufferedReader.close();
        return list;
    }
    public void save(String fileName,String text) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
        bufferedWriter.write(text);
        bufferedWriter.close();
        fileOutputStream.close();
    }



}
