/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefano
 */
public class Mensagem {
    
    public static void ExibirMensagemErro(String Mensagem)
    {
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(Mensagem);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Mensagem");
        dialog.setVisible(true);  
    }
}
