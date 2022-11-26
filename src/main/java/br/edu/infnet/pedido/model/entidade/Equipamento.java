package br.edu.infnet.pedido.model.entidade;

public class Equipamento {

    private Long id;
    private String nome;
    private float mensalidade;

    public Equipamento(){

    }

    public Equipamento(Long id){
        super();
        this.id = id;
    }

    public Equipamento(String nome, Float mensalidade) {
        super();
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public Equipamento(String nome, Float mensalidade, Long id) {
        super();
        this.id = id;
        this.nome = nome;
        this.mensalidade = mensalidade;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public String toString() {
        return "Equipamento [id=" + id + ", nome=" + nome + ", mensalidade=" + mensalidade + "]";
    }
}
