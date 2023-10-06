package utilitario;

import dominio.Atendimento;
import dominio.Cliente;
import dominio.Pet;
import dominio.Servico;
import servicos.AtendimentoServico;
import servicos.ClienteServico;
import servicos.PetServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MenuAtendimentoOpcoes {

    private final ClienteServico clienteServico;

    private final PetServico petServico;

    private final AtendimentoServico atendimentoServico;

    private final DecimalFormat decimalFormat;

    private final Scanner scanner = new Scanner(System.in);

    public MenuAtendimentoOpcoes(ClienteServico clienteServico, PetServico petServico, AtendimentoServico atendimentoServico) {
        this.clienteServico = clienteServico;
        this.petServico = petServico;
        this.atendimentoServico = atendimentoServico;
        this.decimalFormat = new DecimalFormat("#.00");
    }

    public void listarOpcoesServicos() {
        System.out.println("------ MENU DE SERVICOS ------");
        System.out.println("Escolha um ou mais servicos abaixo");
        for (Servico servico : Servico.values()) {
            // System.out.println(servico.getId() + " - " + servico.getDescricao() + " - Valor: R$ " + decimalFormat.format(servico.getValor()));
            System.out.printf("%d - %s - Valor: R$ %s\n", servico.getId(), servico.getDescricao(), decimalFormat.format(servico.getValor()));
        }
    }

    public void cadastrarAtendimento() {
        if (clienteServico.listarClientes().isEmpty()) {
            System.out.println("NAO HA CLIENTES CADASTRADOS");
            return;
        }
        System.out.println("------ CADASTRO DE ATENDIMENTO ------");
        System.out.println();
        System.out.println("------ CLIENTES CADASTRADOS ------");
        for (Cliente cliente : clienteServico.listarClientes()) {
            System.out.println(cliente.getId() + " - " + cliente.getNome());
        }
        System.out.println("Informe o ID do cliente: ");
        Long idCliente = Long.parseLong(scanner.nextLine());

        Cliente cliente = clienteServico.buscarClientePorId(idCliente);

        if (cliente.getPets().isEmpty()) {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR O ATENDIMENTO");
            return;
        }

        System.out.println("PETS DO CLIENTE: " + cliente.getNome());
        for (Pet pet : cliente.getPets()) {
            System.out.println(pet.getId() + " - " + pet.getNome());
        }
        System.out.println("Informe o ID do pet: ");
        Long idPet = Long.parseLong(scanner.nextLine());

        Pet pet = petServico.buscarPetPorId(idPet);

        List<Servico> servicos = new ArrayList<>();
        boolean encerrar = false;

        while (!encerrar) {
            listarOpcoesServicos();
            System.out.println("0 - Finalizar");

            System.out.println("Informe o ID do servico: ");
            Long idServico = Long.parseLong(scanner.nextLine());

            if (idServico == 0) {
                encerrar = true;
            } else {
                for (Servico servico : Servico.values()) {
                    if (Objects.equals(servico.getId(), idServico)) {
                        servicos.add(servico);
                        break;
                    }
                }
            }
        }
        Atendimento atendimento = atendimentoServico.realizarAtendimento(pet, cliente, servicos);
        System.out.println("ATENDIMENTO REALIZADO COM SUCESSO - ID do atendimento: " + atendimento.getId());
        System.out.println();
    }

    public void listarAtendimentos() {
        List<Atendimento> atendimentos = atendimentoServico.listarAtendimentos();

        if (atendimentos.isEmpty()) {
            System.out.println("NENHUM ATENDIMENTO CADASTRADO");
            return;
        }

        System.out.println("------ ATENDIMENTOS CADASTRADOS ------");

        for (Atendimento atendimento : atendimentos) {
            System.out.println("ID: " + atendimento.getId() +
                    " | Cliente: " + atendimento.getCliente().getNome() +
                    " | Pet: " + atendimento.getPet().getNome());
            System.out.println("Servicos escolhidos:");

            List<Servico> servicos = atendimento.getServicos();
            for (Servico servico : servicos) {
                System.out.println("- " + servico.getDescricao() +
                        " (R$ " + decimalFormat.format(servico.getValor()) + ")");
            }
            System.out.println("Valor total: R$ " + decimalFormat.format((atendimento.getValorTotal())));
            System.out.println();
        }
    }

    public void buscarAtendimentosPorId() {
        System.out.println("------ BUSCAR ATENDIMENTO PELO ID ------");
        System.out.println("Informe o ID do atendimento: ");

        Long id = Long.parseLong(scanner.nextLine());

        Atendimento atendimento = atendimentoServico.buscarAtendimentoPorId(id);

        if (atendimento == null) {
            System.out.println("ATENDIMENTO NAO ENCONTRADO");
        } else {
            mostrarAtendimento(atendimento);
        }
    }

    public void mostrarAtendimento(Atendimento atendimento) {
        System.out.printf("Cliente: %s | Pet: %s\n",
                atendimento.getCliente().getNome(),
                atendimento.getPet().getNome());

        System.out.println("Servicos:");
        for (Servico servico : atendimento.getServicos()) {
            System.out.println("- " + servico.getDescricao() +
                    " (R$ " + decimalFormat.format(servico.getValor()) + ")");
        }
        System.out.println("Valor total: R$ " + decimalFormat.format((atendimento.getValorTotal())));
        System.out.println();
    }
}
