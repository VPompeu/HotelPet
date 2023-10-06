package utilitario;

import dominio.Cliente;
import servicos.ClienteServico;
import servicos.PetServico;
import dominio.Pet;

import java.util.List;
import java.util.Scanner;

public class MenuClienteOpcoes {

    private final ClienteServico clienteServico;
    private final PetServico petServico;

    public MenuClienteOpcoes(ClienteServico clienteServico, PetServico petServico) {
        this.clienteServico = clienteServico;
        this.petServico = petServico;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarCliente() {
        System.out.println("------ CADASTRO DE CLIENTE ------");

        System.out.println("Informe o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Informe a idade do cliente: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o telefone do cliente: ");
        String telefone = scanner.nextLine();

        Cliente cliente = clienteServico.cadastrarCliente(nome, idade, telefone);
        System.out.println("SUCESSO! Cliente " + cliente.getNome() + " está cadastrado");
    }

    public void buscarPeloId() {
        System.out.println("------ BUSCAR CLIENTE PELO ID ------");
        System.out.println("Informe o ID do cliente: ");
        Long id = Long.parseLong(scanner.nextLine());
        Cliente cliente = clienteServico.buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("CLIENTE NÃO ENCONTRADO");
        } else {
            mostrarCliente(cliente);
        }
    }

    public void listarTodos() {
        List<Cliente> clientes = clienteServico.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("NÃO HÁ CLIENTES CADASTRADOS");
        } else {
            System.out.println("------ CLIENTES CADASTRADOS ------");
            for (Cliente cliente : clientes) {
                mostrarCliente(cliente);
            }
        }
    }

    private void mostrarCliente(Cliente cliente) {
        List<Pet> pets = cliente.getPets();

        if (!pets.isEmpty() || cliente.getId() != null) {
            System.out.printf("| %-4s | %-12s | %-5s | %-9s |%n",
                    "ID",
                    "NOME",
                    "IDADE",
                    "TELEFONE");
            System.out.printf("| %-4s | %-12s | %-5s | %-9s |%n",
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getIdade(),
                    cliente.getTelefone());

            if (!pets.isEmpty()) {
                System.out.println("Pets do cliente " + cliente.getNome());
                for (Pet pet : pets) {
                    System.out.println(
                            "ID: " + pet.getId() +
                                    " | Nome: " + pet.getNome() +
                                    " | Idade: " + pet.getIdade() +
                                    " | Peso: " + pet.getPeso() +
                                    " | Especie: " + pet.getEspecie());
                }
                System.out.println();
            } else {
                System.out.println("NÃO HÁ PETS CADASTRADOS PARA ESSE CLIENTE");
                System.out.println();
            }
        }
    }

    private void gerarCabecalho() {
        System.out.printf("| %-4s | %-12s | %-5s | %-9s |%n", "ID", "NOME", "IDADE", "TELEFONE");
    }

    public void atribuirPetAoCliente() {
        List<Pet> pets = petServico.listarPets();
        List<Cliente> clientes = clienteServico.listarClientes();

        if (pets.isEmpty() || clientes.isEmpty()) {
            System.out.println("NÃO HÁ PETS OU CLIENTES CADASTRADOS");
        } else {
            System.out.println("Escolha o cliente pelo seu ID");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome());
            }
            System.out.println("Digite o ID desejado: ");
            Long id = Long.parseLong(scanner.nextLine());

            System.out.println("Escolha o pet pelo seu ID");
            for (Pet pet : pets) {
                System.out.println("ID: " + pet.getId() + " | Nome: " + pet.getNome());
            }
            System.out.println("Digite o ID desejado: ");
            Long opcaoIdPet = Long.parseLong(scanner.nextLine());
            Pet pet = petServico.buscarPetPorId(opcaoIdPet);

            clienteServico.cadastrarPetParaOCliente(id, pet);
            System.out.println("SUCESSO! O cliente " + clienteServico.buscarClientePorId(id).getNome() + " é dono do pet " + pet.getNome());
        }
    }
}
