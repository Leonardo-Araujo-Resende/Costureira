package Model;

/**
 * Classe responsavel pela estrutura de dados Tipo de Servico oferecidos por uma costureira
 * @author Léo
 */
public class TipoServico {
    private String tipo;
    private double valor;
    private String observacao;
    private Costureira costureira;

    public TipoServico(String tipo, double valor, String observacao, Costureira costureira) {
        this.tipo = tipo;
        this.valor = valor;
        this.observacao = observacao;
        this.costureira = costureira;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Costureira getCostureira() {
        return costureira;
    }

    public void setCostureira(Costureira costureira) {
        this.costureira = costureira;
    }
    
    public boolean equals(TipoServico tipoServico){
        return getTipo().equals( tipoServico.getTipo() ) && getObservacao().equals(tipoServico.getObservacao()) &&
                getValor() == tipoServico.getValor() && getCostureira().equals(tipoServico.getCostureira());
    }
}
