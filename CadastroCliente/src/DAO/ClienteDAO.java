package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Cliente;

public class ClienteDAO {
    
    public void create(Cliente cli){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO Cliente (COD_Cliente,CPF_Cliente,Nasc_Cliente,Nome_Cliente,Tel_Cliente) VALUES (?,?,?,?,?)");
            stmt.setInt(1,cli.getCodigo());
            stmt.setString(2,cli.getCPF());
            stmt.setDate(3, (Date) cli.getNascimento());
            stmt.setString(4,cli.getNome());
            stmt.setString(5,cli.getTelefone());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Cliente> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> cliList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Cliente cli = new Cliente();
                
                cli.setCodigo(rs.getInt("COD_Cliente"));
                cli.setCPF(rs.getString("CPF_Cliente"));
                cli.setNascimento(rs.getDate("Nasc_Cliente"));
                cli.setNome(rs.getString("Nome_Cliente"));
                cli.setTelefone(rs.getString("Tel_Cliente"));
                
                cliList.add(cli);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cliList;
    }
    
    public void update(Cliente cli){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Cliente SET CPF_Cliente = ?,Nasc_Cliente = ?,Nome_Cliente = ?,Tel_Cliente = ? WHERE COD_Cliente = ?");
            stmt.setString(1,cli.getCPF());
            stmt.setDate(2, (Date) cli.getNascimento());
            stmt.setString(3,cli.getNome());
            stmt.setString(4,cli.getTelefone());
            stmt.setInt(5,cli.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Cliente cli){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Cliente WHERE COD_Cliente = ?");
            stmt.setInt(1,cli.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
