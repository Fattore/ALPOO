/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Stefano
 */
public class Conversor {
    
    public static Date StringParaData(String valor)
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return new java.sql.Date(format.parse(valor).getTime());
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
