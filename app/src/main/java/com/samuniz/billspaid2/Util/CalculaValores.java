package com.samuniz.billspaid2.Util;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lucas on 14/11/2017.
 */

public class CalculaValores {

    public CalculaValores() {
    }

    public String calculaTotal(List<String> lista){
        double vTotal = 0, vAtual;
        String result = "";
        DecimalFormat df = new DecimalFormat("#,###.00");

        for(int i = 0; i < lista.size(); i++){
            String s = lista.get(i);
            vAtual = Double.parseDouble(s);
            vTotal = vAtual + vTotal;
        }

        result = df.format(vTotal);
        return result;
    }


}
