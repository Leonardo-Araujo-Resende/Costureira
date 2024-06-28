package DAO;

import Model.Cliente;
import Model.Costureira;
import Model.Servico;
import Model.StatusServico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO {
    
    public static void salvarServico(Servico servico) {
        String sql = "INSERT INTO servico (status, tipo, valor, custoPecas, dataPedido, dataEntrega, observacao, id_costureira, id_cliente) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement statementServico = ConexaoBd.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            statementServico.setString(1, servico.getStatus());
            statementServico.setString(2, servico.getTipo());
            statementServico.setDouble(3, servico.getValor());
            statementServico.setDouble(4, servico.getCustoPecas());
            statementServico.setString(5, servico.getDataPedido());
            statementServico.setString(6, servico.getDataEntrega());
            statementServico.setString(7, servico.getObservacao());
            statementServico.setInt(8, servico.getCostureira().getId());
            statementServico.setInt(9, servico.getCliente().getId());
            
            statementServico.execute();
            
            ResultSet generatedKeys = statementServico.getGeneratedKeys();
            
            int servicoId = -1;
            if (generatedKeys.next()) {
                servicoId = generatedKeys.getInt(1);
                servico.setId(servicoId);
            }
            statementServico.close();
            
            System.out.println("Salvou servico!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Servico> retornaTodosServicoDeCostureira(Costureira costureira){
        String sql = "SELECT * FROM servico s INNER JOIN costureira c ON c.pessoa_id = s.id_costureira WHERE c.pessoa_id = ?;";
        ArrayList<Servico> servicos = new ArrayList<>();


        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, costureira.getId());
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("idservico");
                String status = rs.getString("status");
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                double custoPecas = rs.getDouble("custoPecas");
                String dataPedido = rs.getString("dataPedido");
                String dataEntrega = rs.getString("dataEntrega");
                String observacao = rs.getString("observacao");
                Cliente cliente = ClienteDAO.retornaClientePorId(rs.getInt("id_cliente"));
                
                Servico servico = new Servico(id, tipo, costureira, cliente, valor, custoPecas, dataPedido, dataEntrega, observacao, StatusServico.valueOf(status));
                servicos.add(servico);
 
            }
        
            st.close();
            
            
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaTodosServicos");
            e.printStackTrace();
        }
        
        System.out.println("Buscou todos os serviços de uma costureira!");
        return servicos;
    }
    
    public static ArrayList<Servico> retornaTodosServicoDeCliente(Cliente cliente){
        String sql = "SELECT * FROM servico s INNER JOIN cliente ON cliente.pessoa_id = s.id_cliente WHERE cliente.pessoa_id = ?;";
        ArrayList<Servico> servicos = new ArrayList<>();


        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, cliente.getId());
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("idservico");
                String status = rs.getString("status");
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                double custoPecas = rs.getDouble("custoPecas");
                String dataPedido = rs.getString("dataPedido");
                String dataEntrega = rs.getString("dataEntrega");
                String observacao = rs.getString("observacao");
                Costureira costureira = CostureiraDAO.procuraCostureiraPorId( Integer.parseInt(rs.getString("id_costureira")));
                
                
                Servico servico = new Servico(id, tipo, costureira, cliente, valor, custoPecas, dataPedido, dataEntrega, observacao, StatusServico.valueOf(status));
                servicos.add(servico);
            }

            st.close();
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaTodosServicosDeCliente");
            e.printStackTrace();
        }
        
        System.out.println("Buscou todos os serviços! de um cliente");
        return servicos;
    }
    
    public static ResultSet retornaEstatisticasServicoClienteCostureira(int clienteId, int costureiraId){
        String sql = "SELECT AVG(s.valor) AS media_valor, COUNT(s.valor) AS qnt_servicos,SUM(s.valor) AS valor_total FROM servico s INNER JOIN cliente c ON c.pessoa_id = s.id_cliente WHERE id_cliente = ? AND id_costureira = ?;";
        ResultSet resultSet = null;

        try {

            PreparedStatement sr = ConexaoBd.getConexao().prepareStatement(sql);
            sr.setInt(1, clienteId);
            sr.setInt(2, costureiraId);
            resultSet = sr.executeQuery();
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaEstatisticasServicoClienteCostureira");
            e.printStackTrace();
        }
        
        System.out.println("Retorna estatisticas ");
        return resultSet;
    }
    
    public static Servico retornaServicoPorId(int id){
        
        
        String sql = "SELECT *  FROM servico WHERE idservico = ?;";
        Servico servico = null;
        
        try {
            
            PreparedStatement sr = ConexaoBd.getConexao().prepareStatement(sql);
            sr.setInt(1, id);
            
            ResultSet rs = sr.executeQuery();
            
            if(rs.next()){
                String status = rs.getString("status");
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                double custoPecas = rs.getDouble("custoPecas");
                String dataPedido = rs.getString("dataPedido");
                String dataEntrega = rs.getString("dataEntrega");
                String observacao = rs.getString("observacao");
                Costureira costureira = CostureiraDAO.procuraCostureiraPorId( Integer.parseInt( rs.getString("id_costureira") ));
                Cliente cliente = ClienteDAO.retornaClientePorId( Integer.parseInt( rs.getString("id_cliente") ) );
                
                
                servico = new Servico(id, tipo, costureira, cliente, valor, custoPecas, dataPedido, dataEntrega, observacao, StatusServico.valueOf(status));
            }
            
            sr.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return servico;
    }
    
    public static ArrayList<Servico> retornaTodosServicoStatus(Costureira costureira, StatusServico status){
        String sql = "SELECT * FROM servico WHERE status = ? AND id_costureira = ?;";
        ArrayList<Servico> servicos = new ArrayList<>();


        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setString(1, status.name());
            st.setInt(2, costureira.getId());
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt("idservico");
                String tipo = rs.getString("tipo");
                double valor = rs.getDouble("valor");
                double custoPecas = rs.getDouble("custoPecas");
                String dataPedido = rs.getString("dataPedido");
                String dataEntrega = rs.getString("dataEntrega");
                String observacao = rs.getString("observacao");
                Cliente cliente = ClienteDAO.retornaClientePorId(rs.getInt("id_cliente"));
                
                Servico servico = new Servico(id, tipo, costureira, cliente, valor, custoPecas, dataPedido, dataEntrega, observacao, status);
                servicos.add(servico);
 
            }
        
            st.close();
            
            
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaTodosServicosStatus");
            e.printStackTrace();
        }
        
        System.out.println("Buscou todos os serviços de um status");
        return servicos;
    }
    
    public static void atualizaStatusServicoPorId(int id, StatusServico statusServico){
        String sql = "UPDATE servico SET status = ? WHERE idservico = ?";
        
        try {
            
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            
            st.setString(1, statusServico.name());
            st.setInt(2, id);
            
            st.execute();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void excluirStatusPorId(int id){
        String sql = "DELETE FROM servico WHERE idservico = ?";
        
        try {
            
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            
            st.setInt(1, id);
            
            st.execute();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void atualizaServico(Servico servico){
        String sql = "UPDATE servico SET status = ?, tipo = ?, valor = ?, custoPecas = ?, dataEntrega = ?, observacao = ?, id_cliente = ? WHERE idservico = ?;";
        
        try {
            
            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            
            st.setString(1, servico.getStatus());
            st.setString(2, servico.getTipo());
            st.setDouble(3, servico.getValor());
            st.setDouble(4, servico.getCustoPecas());
            st.setString(5, servico.getDataEntrega());
            st.setString(6, servico.getObservacao());
            st.setInt(7, servico.getCliente().getId());
            st.setInt(8, servico.getId());
            
            st.execute();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Costureira retornaCostureiraPreferidaDoCliente(Cliente cliente){ 
        String sql = "SELECT id_cliente, id_costureira, count(id_costureira) as quantidades_servicos_c_costureira "
                + "FROM servico "
                + "WHERE id_cliente = ? "
                + "GROUP BY id_costureira "
                + "ORDER BY quantidades_servicos_c_costureira desc;";
        Costureira costureiraPreferida = null;

        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, cliente.getId());
            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                costureiraPreferida = CostureiraDAO.procuraCostureiraPorId(rs.getInt("id_costureira"));
            }
            
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaIdCostureiraPreferidaDoCliente");
            e.printStackTrace();
        }
        
        return costureiraPreferida;
    }
    
    public static String retornaTipoServicoMaisOferecidoPorCostureira(Costureira costureira){ 
        String sql = "SELECT tipo, count(tipo) as quantidades "
                + "FROM servico "
                + "WHERE id_costureira = ? "
                + "GROUP BY tipo "
                + "ORDER BY quantidades asc;";
        
        String tipoServicoMaisOferecido = null;

        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, costureira.getId());
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                tipoServicoMaisOferecido = rs.getString("tipo");
            }
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaTipoServicoMaisOferecidoPorCostureira");
            e.printStackTrace();
        }
        
        return tipoServicoMaisOferecido;
    }
    
    public static String retornaTipoServicoPreferidoDoCliente(Cliente cliente){ 
        String sql = "SELECT tipo, count(tipo) as quantidades "
                + "FROM servico "
                + "WHERE id_cliente = ? "
                + "GROUP BY tipo "
                + "ORDER BY quantidades desc;";
        
        String tipoServicoMaisPedido = null;

        try {

            PreparedStatement sr = ConexaoBd.getConexao().prepareStatement(sql);
            sr.setInt(1, cliente.getId());
            
            ResultSet rs = sr.executeQuery();
            
            if(rs.next()){
                tipoServicoMaisPedido = rs.getString("tipo");
            }
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaTipoServicoPreferidoDoCliente");
            e.printStackTrace();
        }
        
        return tipoServicoMaisPedido;
    }
    
    public static ResultSet retornaEstatisticasPorMes(){
        String sql = "SELECT DATE_FORMAT(STR_TO_DATE(dataPedido, '%d/%m/%Y %H:%i'), '%m/%Y') AS mes_ano, "
                + "COUNT(*) AS qnt, "
                + "SUM(valor) AS valor_receber "
                + "FROM  servico "
                + "GROUP BY  DATE_FORMAT(STR_TO_DATE(dataPedido, '%d/%m/%Y %H:%i'), '%m/%Y') "
                + "ORDER BY  mes_ano;";
        
        ResultSet rs = null;

        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            rs = st.executeQuery();
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaEstatisticasPorMes");
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public static ResultSet retornaEstatisticasStatusPedido(Costureira costureira){
        String sql = "SELECT status, sum(valor) as valor_total, count(status) as qnt "
                + "FROM servico "
                + "WHERE id_costureira = ? "
                + "GROUP BY servico.status;";
        
        ResultSet rs = null;

        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, costureira.getId());
            rs = st.executeQuery();
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaEstatisticasStatusPedido");
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public static ResultSet retornaEstatisticasTipoPedido(Costureira costureira){
        String sql = "SELECT tipo, count(tipo) as qnt, sum(valor) as valor_receber "
                + "FROM servico "
                + "WHERE id_costureira = ? "
                + "GROUP BY tipo "
                + "ORDER BY valor_receber; ";
        
        ResultSet rs = null;

        try {

            PreparedStatement st = ConexaoBd.getConexao().prepareStatement(sql);
            st.setInt(1, costureira.getId());
            rs = st.executeQuery();
    
        } catch (SQLException e) {
            System.out.println("Erro no ServicoDAO.retornaEstatisticasTipoPedido");
            e.printStackTrace();
        }
        
        return rs;
    }
    
    
}
