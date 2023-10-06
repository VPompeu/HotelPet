package utilitario;

import java.util.Scanner;

import servicos.AtendimentoServico;
import servicos.ClienteServico;
import servicos.PetServico;

public class Menu {
    private final PetServico petServico;
    private final ClienteServico clienteServico;

    private final AtendimentoServico atendimentoServico;

    public Menu(PetServico petServico, ClienteServico clienteServico, AtendimentoServico atendimentoServico) {
        this.petServico = petServico;
        this.clienteServico = clienteServico;
        this.atendimentoServico = atendimentoServico;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        System.out.println("----------- PET SHOP -----------");
        System.out.println("Operacoes do sistema: ");
        System.out.println("1 - Pets");
        System.out.println("2 - Clientes");
        System.out.println("3 - Atendimentos");
        System.out.println("0 - Sair do sistema");
        System.out.println("--------------------------------");

        System.out.println("Digite a operacao desejada: ");
        int opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1 -> menuPets();
            case 2 -> menuClientes();
            case 3 -> menuAtendimentos();
            default -> {
                System.out.println("Finalizando sistema!");
                scanner.close();
            }
        }
    }

    private void menuPets() {
        MenuPetOpcoes menuPetOpcoes = new MenuPetOpcoes(petServico);
        boolean fecharMenu = false;
        while (!fecharMenu) {
            System.out.println("----------- PET SHOP -----------");
            System.out.println("Operacoes com PETS: ");
            System.out.println("1 - Cadastrar novo pet");
            System.out.println("2 - Buscar pet pelo ID");
            System.out.println("3 - Listar todos os pets");
            System.out.println("0 - Retornar ao menu principal");
            System.out.println("--------------------------------");

            System.out.println("Digite a operacao desejada: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> menuPetOpcoes.cadastrarPet();
                case 2 -> menuPetOpcoes.buscarPeloId();
                case 3 -> menuPetOpcoes.listarTodos();
                default -> {
                    fecharMenu = true;
                    menuPrincipal();
                }
            }
        }
    }

    private void menuClientes() {
        MenuClienteOpcoes menuClienteOpcoes = new MenuClienteOpcoes(clienteServico, petServico);
        boolean fecharMenu = false;
        while (!fecharMenu) {
            System.out.println("----------- PET SHOP -----------");
            System.out.println("Operacoes com CLIENTES: ");
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Buscar cliente pelo ID");
            System.out.println("3 - Listar todos os clientes");
            System.out.println("4 - Atribuir pet à um cliente");
            System.out.println("0 - Retornar ao menu principal");
            System.out.println("--------------------------------");

            System.out.println("Digite a operacao desejada: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> menuClienteOpcoes.cadastrarCliente();
                case 2 -> menuClienteOpcoes.buscarPeloId();
                case 3 -> menuClienteOpcoes.listarTodos();
                case 4 -> menuClienteOpcoes.atribuirPetAoCliente();
                default -> {
                    fecharMenu = true;
                    menuPrincipal();
                }
            }
        }
    }

    private void menuAtendimentos() {
        MenuAtendimentoOpcoes menuAtendimentoOpcoes = new MenuAtendimentoOpcoes(clienteServico, petServico, atendimentoServico);
        boolean fecharMenu = false;
        while (!fecharMenu) {
            System.out.println("----------- PET SHOP -----------");
            System.out.println("Operacoes com ATENDIMENTOS: ");
            System.out.println("1 - Cadastrar novo atendimento");
            System.out.println("2 - Listar todos os atendimentos");
            System.out.println("3 - Buscar atendimento por ID");
            System.out.println("0 - Retornar ao menu principal");
            System.out.println("--------------------------------");

            System.out.println("Digite a operacao desejada: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> menuAtendimentoOpcoes.cadastrarAtendimento();
                case 2 -> menuAtendimentoOpcoes.listarAtendimentos();
                case 3 -> menuAtendimentoOpcoes.buscarAtendimentosPorId();
                default -> {
                    fecharMenu = true;
                    menuPrincipal();
                }
            }
        }
    }
}
