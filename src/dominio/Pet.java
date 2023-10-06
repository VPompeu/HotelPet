package dominio;

import java.util.Objects;

public class Pet {
    private Long id;
    private String nome;
    private Integer idade;
    private Double peso;
    private Especie especie;

    public Pet(String nome, Integer idade, Double peso, Especie especie) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", especie=" + especie +
                '}';
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) && Objects.equals(nome, pet.nome) && Objects.equals(idade, pet.idade) && Objects.equals(peso, pet.peso) && especie == pet.especie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade, peso, especie);
    }
}
