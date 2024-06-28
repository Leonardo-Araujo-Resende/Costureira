
package DAO;

import Model.Costureira;
import Model.TipoServico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoServicoDAO {
    
    public static void salvarTipoServico(TipoServico tipoServico) throws SQLException {
        String sql = "INSERT INTO tipo_servico (tipo, valor, observacao, costureira_id) VALUES(?,?,?,?)";
        
        PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        st.setString(1, tipoServico.getTipo());
        st.setDouble(2, tipoServico.getValor());
        st.setString(3, tipoServico.getObservacao());
        st.setInt(4, tipoServico.getCostureira().getId());

        st.execute();
        st.close();
        
        System.out.println("Salvou tipo servico");
    }
        
    public static ArrayList<TipoServico> recuperarServicosDeCostureira(Costureira costureira){
        String sql = "SELECT * FROM tipo_servico WHERE costureira_id = ?;";
        ArrayList<TipoServico> tipoServicos = new ArrayList<>();


        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1,costureira.getId());
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                String observacao = rs.getString("observacao");
                
                TipoServico tipoServico = new TipoServico( tipo, valor, observacao, costureira);
                tipoServicos.add(tipoServico);
            }

            st.close();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tipoServicos;
    }
    
    public static TipoServico recuperarTipoServicoPorChave(String pkTipo){
        String sql = "SELECT *  FROM tipo_servico WHERE tipo = ?;";
        TipoServico tipoServico = null;
        
        try {
            
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setString(1, pkTipo);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                
                double valor = rs.getDouble("valor");
                String observacao = rs.getString("observacao");
                int costureira_id = rs.getInt("costureira_id");
                
                tipoServico = new TipoServico( pkTipo, valor, observacao, CostureiraDAO.procuraCostureiraPorId(costureira_id));
            }
            
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tipoServico;
    }
}
