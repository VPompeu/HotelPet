package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private Integer idade;
    private String telefone;
    private List<Pet> pets;

    public Cliente(String nome, Integer idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.pets = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", pets=" + pets +
                '}';
    }

    public void adicionarPet(Pet pet){
        this.pets.add(pet);
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
