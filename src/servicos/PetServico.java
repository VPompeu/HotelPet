package servicos;

import dominio.Especie;
import dominio.Pet;
import repositorio.PetRepositorio;

import java.util.List;

public class PetServico {
    private final PetRepositorio petRepositorio;

    public PetServico(PetRepositorio petRepositorio) {
        this.petRepositorio = petRepositorio;
    }

    public Pet cadastrarPet(String nome, Integer idade, Double peso, Especie especie){
        Pet pet = new Pet(nome, idade, peso, especie);
        return petRepositorio.adicionar(pet);
    }

    public Pet buscarPetPorId(Long id){
        return petRepositorio.buscarPorId(id);
    }

    public List<Pet> listarPets(){
        return petRepositorio.listarTodos();
    }
}
