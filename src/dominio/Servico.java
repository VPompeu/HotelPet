package dominio;

public enum Servico {
    BANHO(1L, "Banho", 50.99),
    TOSA(2L, "Tosa", 89.99),
    HOSPEDAGEM(3L, "Hospedagem", 195.99),
    PETCURE(4L, "Petcure", 35.99),
    PASSEIO(5L, "Passeio", 165.99),
    VACINA(6L, "Vacina", 80.99);

    private final Long id;
    private final String descricao;

    private final Double valor;

    Servico(Long id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Long getId() {
        return id;
    }
}
