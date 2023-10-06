package servicos;

import dominio.Cliente;
import dominio.Pet;
import repositorio.ClienteRepositorio;

import java.util.List;

public class ClienteServico {
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente cadastrarCliente(String nome, Integer idade, String telefone){
        Cliente cliente = new Cliente(nome, idade, telefone);
        return clienteRepositorio.adicionar(cliente);
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepositorio.buscarPorId(id);
    }

    public Cliente cadastrarPetParaOCliente(Long id, Pet pet){
       Cliente cliente = clienteRepositorio.buscarPorId(id);
       cliente.adicionarPet(pet);
       return cliente;
    }

    public List<Cliente> listarClientes(){
        return clienteRepositorio.listarTodos();
    }
}
