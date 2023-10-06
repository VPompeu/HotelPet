package servicos;

import dominio.Atendimento;
import dominio.Cliente;
import dominio.Pet;
import dominio.Servico;
import repositorio.AtendimentoRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AtendimentoServico {

    private final AtendimentoRepositorio atendimentoRepositorio;

    public AtendimentoServico(AtendimentoRepositorio atendimentoRepositorio) {
        this.atendimentoRepositorio = atendimentoRepositorio;
    }

    public Atendimento cadastrarAtendimento(Atendimento atendimento) {
        return atendimentoRepositorio.adicionar(atendimento);
    }

    public List<Atendimento> listarAtendimentos() {
        return atendimentoRepositorio.listarTodos();
    }

    public Atendimento buscarAtendimentoPorId(Long id) {
        return atendimentoRepositorio.buscarPorId(id);
    }

    public Atendimento realizarAtendimento(Pet pet, Cliente cliente, List<Servico> servicos) {
        double valorTotal = calcularValorTotal(servicos);

        Atendimento atendimento = new Atendimento(pet, cliente, valorTotal);

        for (Servico servico : servicos) {
            atendimento.adicionarServico(servico);
        }
        atendimentoRepositorio.adicionar(atendimento);
        return atendimento;
    }

    private double calcularValorTotal(List<Servico> servicos) {
        double valorTotal = 0.00;

        for (Servico servico : servicos) {
            valorTotal += servico.getValor();
        }
        return valorTotal;
    }

    public List<Atendimento> listarAtendimentoPorCliente(Long idCliente) {
        List<Atendimento> atendimentosCliente = new ArrayList<>();

        for (Atendimento atendimento : atendimentoRepositorio.listarTodos()) {
            if (Objects.equals(atendimento.getCliente().getId(), idCliente)) {
                atendimentosCliente.add(atendimento);
            }
        }
        return atendimentosCliente;
    }
}
