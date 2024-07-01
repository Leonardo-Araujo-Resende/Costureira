
package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsavel pela estrutura de dados do Servico
 * @author Léo
 */
public class Servico{

    private int id;
    private String tipo;
    private Costureira costureira;
    private Cliente cliente;
    private double valor;
    private double custoPecas;
    private String dataPedido;
    private String dataEntrega;
    private StatusServico status;
    private String observacao;
    
    
    public Servico(int id, String tipo, Costureira costureira, Cliente cliente, double valor, double custoPecas, String dataPedido, String dataEntrega, String observacao, StatusServico status) {
        this.id = id;
        this.tipo = tipo;
        this.costureira = costureira;
        this.cliente = cliente;
        this.valor = valor;
        this.custoPecas = custoPecas;
        
        if("".equals(dataPedido)){
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            this.dataPedido = agora.format(formatter);
        }else{
            this.dataPedido = dataPedido;
        }
         
        this.dataEntrega = dataEntrega;
        this.observacao = observacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Costureira getCostureira() {
        return costureira;
    }

    public void setCostureira(Costureira costureira) {
        this.costureira = costureira;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public void setServicoEntregue(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataEntrega = agora.format(formatter);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(StatusServico status) {
        this.status = status;
    }

    public double getCustoPecas() {
        return custoPecas;
    }

    public void setCustoPecas(double custoPecas) {
        this.custoPecas = custoPecas;
    }
    
    public boolean equals(Servico servico){
        return getId() == servico.getId() && getTipo().equals(servico.getTipo()) && getCostureira().equals(servico.getCostureira()) &&
                getCliente().equals(servico.getCliente()) && getValor() == servico.getValor() && getCustoPecas() == servico.getCustoPecas()&&
                getDataPedido().equals(servico.getDataPedido()) && getDataEntrega().equals(servico.getDataEntrega()) && 
                getObservacao().equals(servico.getObservacao()) && getStatus().equals(servico.getStatus());
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", tipo=" + tipo + ", costureira=" + costureira.getNome()+ ", cliente=" + cliente.getNome() + ", valor=" + valor + ", custoPecas=" + custoPecas + ", dataPedido=" + dataPedido + ", dataEntrega=" + dataEntrega + ", status=" + status + ", observacao=" + observacao + '}';
    }
    
    
}
