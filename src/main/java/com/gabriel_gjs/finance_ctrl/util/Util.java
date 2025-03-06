package com.gabriel_gjs.finance_ctrl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Util {

    public static Date generateDate(String dateString) {
        Date date;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            date = sdf.parse(dateString);

            return date;
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data: " + e.getMessage());
        }

        return null;
    }
}
