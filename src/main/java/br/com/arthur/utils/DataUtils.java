package br.com.arthur.utils;

import java.text.*;
import java.util.*;

public class DataUtils {

    public static Date obterDataComDiferencaDias(int dias){
        //aponta para a data atual
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH , dias);
        return  calendar.getTime();
    }

    public static String obterDataFormatada(Date data){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        return dateFormat.format(data);
    }
}
