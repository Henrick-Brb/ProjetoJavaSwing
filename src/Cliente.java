public class Cliente {
    private int codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private Long numeroTelefone;
    private Long numeroCEP;
    private String obs;

    public Cliente(int codigo, String nome, String endereco, String bairro, String cidade, String estado, Long numeroTelefone, Long numeroCEP, String obs) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numeroTelefone = numeroTelefone;
        this.numeroCEP = numeroCEP;
        this.obs = obs;
    }

    public int getCodigo() { return codigo; }

    public String getnome() { return nome; }

    public String getEndereco() { return endereco; }

    public String getBairro() { return bairro; }

    public String getCidade() { return cidade; }

    public String getEstado() { return estado; }

    public Long getNumeroTelefone() { return numeroTelefone; }

    public Long getNumeroCEP() { return numeroCEP; }

    public String getObs() { return obs; }
}
