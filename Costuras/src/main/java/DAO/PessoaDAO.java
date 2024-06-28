
package DAO;

import Model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {
    
    public static boolean salvarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome) VALUES(?)";
        boolean isSalvouPessoa = false;
        
        try {
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, pessoa.getNome());
            
            
            st.execute();
            ResultSet generatedKeys = st.getGeneratedKeys();
            
            int pessoaId = -1;
            if (generatedKeys.next()) {
                pessoaId = generatedKeys.getInt(1);
                pessoa.setId(pessoaId);
                isSalvouPessoa = true;
            }

            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Salvou pessoa? " + isSalvouPessoa);
        return isSalvouPessoa;
    }
    
    public static boolean recuperarPessoaPorId(Pessoa pessoa){
        String sql = "SELECT *  FROM pessoa WHERE id_pessoa = ?;";
        boolean retorno = false;
        
        try {
            
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, pessoa.getId());
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                pessoa.setNome(rs.getString("nome"));
                retorno = true;
            }
            
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return retorno;
    }

    
}
