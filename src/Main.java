import repositorio.AtendimentoRepositorio;
import repositorio.ClienteRepositorio;
import repositorio.PetRepositorio;
import servicos.AtendimentoServico;
import servicos.ClienteServico;
import servicos.PetServico;
import utilitario.Menu;
import utilitario.MenuAtendimentoOpcoes;

public class Main {

    public static void main(String[] args) {
        PetRepositorio petRepositorio = new PetRepositorio();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        AtendimentoRepositorio atendimentoRepositorio = new AtendimentoRepositorio();

        PetServico petServico = new PetServico(petRepositorio);
        ClienteServico clienteServico = new ClienteServico(clienteRepositorio);
        AtendimentoServico atendimentoServico = new AtendimentoServico(atendimentoRepositorio);

        Menu menu = new Menu(petServico, clienteServico, atendimentoServico);

        menu.menuPrincipal();
    }
}