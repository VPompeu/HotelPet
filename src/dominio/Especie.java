package dominio;

public enum Especie {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    NAO_INFORMADO("Nao informado");

    private String descricao;

    Especie(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
