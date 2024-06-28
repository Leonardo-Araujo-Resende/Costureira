
package DAO;

import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    
    public static void salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (telefone, endereco, observacao, pessoa_id) VALUES(?,?,?,?)";


        if(!PessoaDAO.salvarPessoa(cliente)){
            System.out.println("Algo deu errado");
            return;
        }

        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);

            st.setString(1, cliente.getTelefone());
            st.setString(2, cliente.getEndereco());
            st.setString(3, cliente.getObservacao());
            st.setInt(4, cliente.getId());

            st.execute();
            st.close();

            System.out.println("Salvou cliente!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Cliente> retornaTodosClientes(){
        String sql = "SELECT * FROM cliente c INNER JOIN pessoa p ON c.pessoa_id = p.id_pessoa;";
        ArrayList<Cliente> clientes = new ArrayList<>();


        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("id_pessoa");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String observacao = rs.getString("observacao");
                
                Cliente cliente = new Cliente(id, nome, telefone, endereco, observacao);
                clientes.add(cliente);
                
                
            }
        
            st.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Buscou todos os clientes!");
        return clientes;
    }
    
    public static Cliente retornaClientePorId(int id){
        String sql = "SELECT * FROM cliente c INNER JOIN pessoa p ON c.pessoa_id = p.id_pessoa WHERE c.pessoa_id = ?;";
        Cliente cliente = null;
        
        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String observacao = rs.getString("observacao");
                
                cliente = new Cliente(id, nome, telefone, endereco, observacao);                
            }
        
            st.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Achou Cliente por Id!");
        return cliente;
    }
    
    public static void atualizarCliente(Cliente cliente){
        String sql = "UPDATE cliente c INNER JOIN pessoa p ON c.pessoa_id = p.id_pessoa SET p.nome = ?, c.telefone = ?, c.endereco = ?, c.observacao = ? WHERE c.pessoa_id = ?;";
        
        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getTelefone());
            st.setString(3, cliente.getEndereco());
            st.setString(4, cliente.getObservacao());
            st.setInt(5, cliente.getId());
            
            st.execute();
            st.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
