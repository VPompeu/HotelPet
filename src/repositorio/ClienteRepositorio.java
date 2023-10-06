package repositorio;

import dominio.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements RepositorioDAO<Cliente> {

    private static Long ID_ATUAL = 1L;
    private final List<Cliente> clientesCadastrados = new ArrayList<>();
    @Override
    public Cliente buscarPorId(Long id) {
        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return clientesCadastrados;
    }


    @Override
    public Cliente adicionar(Cliente cliente) {
        cliente.setId(ID_ATUAL++);
        clientesCadastrados.add(cliente);
        return cliente;
    }
}
