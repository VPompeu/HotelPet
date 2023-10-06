package utilitario;

import dominio.Especie;
import dominio.Pet;
import servicos.PetServico;

import java.util.List;
import java.util.Scanner;

public class MenuPetOpcoes {

    private final PetServico petServico;

    public MenuPetOpcoes(PetServico petServico) {
        this.petServico = petServico;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarPet() {
        System.out.println("------ CADASTRO DE PET ------");

        System.out.println("Informe o nome do pet: ");
        String nome = scanner.nextLine();

        System.out.println("Informe a idade do pet: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o peso do pet: ");
        double peso = Double.parseDouble(scanner.nextLine());

        Especie especie = informarEspecie();
        Pet pet = petServico.cadastrarPet(nome, idade, peso, especie);
        System.out.println("Pet cadastrado com sucesso. ID = " + pet.getId());
    }

    public void buscarPeloId() {
        System.out.println("------ BUSCAR PET PELO ID ------");
        System.out.println("Informe o ID do pet: ");
        Long id = Long.parseLong(scanner.nextLine());
        Pet pet = petServico.buscarPetPorId(id);

        if (pet == null) {
            System.out.println("PET NÃO ENCONTRADO");
        } else {
            gerarCabecalho();
            mostrarPet(pet);
        }
    }

    public void listarTodos() {
        List<Pet> pets = petServico.listarPets();

        if (pets.isEmpty()) {
            System.out.println("NÃO HÁ PETS CADASTRADOS!");
        } else {
            System.out.println("------ PETS CADASTRADOS ------");
            gerarCabecalho();
            for (Pet pet : pets) {
                mostrarPet(pet);
            }
        }
    }

    private void mostrarPet(Pet pet) {
        System.out.printf("| %-4s | %-12s | %-5s | %-7s | %-8s |%n",
                pet.getId(),
                pet.getNome(),
                pet.getIdade(),
                pet.getPeso() + "kg",
                pet.getEspecie().getDescricao());
    }

    private void gerarCabecalho() {
        System.out.printf("| %-4s | %-12s | %-5s | %-7s | %-8s |%n", "ID", "NOME", "IDADE", "PESO", "ESPECIE");
    }

    private Especie informarEspecie() {
        System.out.println("Informe a especie do pet: 1 - Cachorro, 2 - Gato: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        return switch (opcao) {
            case 1 -> Especie.CACHORRO;
            case 2 -> Especie.GATO;
            default -> Especie.NAO_INFORMADO;
        };
    }
}
