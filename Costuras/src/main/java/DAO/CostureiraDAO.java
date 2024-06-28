package DAO;

import Model.Costureira;
import Model.Exceptions.CostureiraJaExisteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class CostureiraDAO {
    
    
    public static void salvarCostureira(Costureira costureira) throws CostureiraJaExisteException {
        
        if(procurarCostureiraLoginSenha(costureira)){
            throw new CostureiraJaExisteException("Costureira já existe!");
        }
        
        String sql = "INSERT INTO costureira (login, senha, pessoa_id) VALUES(?,?,?)";
                
        if(!PessoaDAO.salvarPessoa(costureira)){
            System.out.println("Nao salvou pessoa!");
            return;
        }
        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setString(1, costureira.getLogin());
            st.setString(2, costureira.getSenha());
            st.setInt(3, costureira.getId());

            st.execute();
            st.close();
            
            System.out.println("Costureira salva!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean procurarCostureiraLoginSenha(Costureira costureira){
        String sql = "SELECT *  FROM costureira c INNER JOIN pessoa p ON c.pessoa_id = p.id_pessoa WHERE BINARY login = ? AND BINARY senha = ?;";
        boolean achouCostureira = false;
        
        try {
            
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setString(1, costureira.getLogin());
            st.setString(2, costureira.getSenha());
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                costureira.setId(rs.getInt("pessoa_id"));
                costureira.setNome(rs.getString("nome"));
                achouCostureira = true;
            }
            
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Achou costureira? " + achouCostureira);
        return achouCostureira;
    }
    
    public static Costureira procuraCostureiraPorId(int id){
        String sql = "SELECT * FROM costureira c INNER JOIN pessoa p ON c.pessoa_id = p.id_pessoa WHERE c.pessoa_id = ?;";
        Costureira costureira = null;
        
        try {
            
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                
                
                
                costureira = new Costureira(id, nome, login, senha);
            }
            
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return costureira;
    }

        
    
}
