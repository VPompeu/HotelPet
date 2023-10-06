package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Atendimento {
    private Long id;

    private Pet pet;

    private Cliente cliente;

    private Double valorTotal;

    private List<Servico> servicos;

    public Atendimento(Pet pet, Cliente cliente, Double valorTotal) {
        this.pet = pet;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.servicos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + id +
                ", pet=" + pet +
                ", cliente=" + cliente +
                ", valorTotal=" + valorTotal +
                ", servicos=" + servicos +
                '}';
    }

    public void adicionarServico(Servico servico){
        this.servicos.add(servico);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendimento that = (Atendimento) o;
        return Objects.equals(id, that.id) && Objects.equals(pet, that.pet) && Objects.equals(cliente, that.cliente) && Objects.equals(valorTotal, that.valorTotal) && Objects.equals(servicos, that.servicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pet, cliente, valorTotal, servicos);
    }
}
