package repositorio;

import dominio.Atendimento;
import dominio.Atendimento;

import java.util.ArrayList;
import java.util.List;

public class AtendimentoRepositorio implements RepositorioDAO<Atendimento> {

    private static Long ID_ATUAL = 1L;
    private final List<Atendimento> atendimentosCadastrados = new ArrayList<>();

    @Override
    public Atendimento buscarPorId(Long id) {
        for (Atendimento atendimento : atendimentosCadastrados) {
            if (atendimento.getId().equals(id)) {
                return atendimento;
            }
        }
        return null;
    }

    @Override
    public List<Atendimento> listarTodos() {
        return atendimentosCadastrados;
    }

    @Override
    public Atendimento adicionar(Atendimento atendimento) {
        atendimento.setId(ID_ATUAL++);
        atendimentosCadastrados.add(atendimento);
        return atendimento;
    }
}
