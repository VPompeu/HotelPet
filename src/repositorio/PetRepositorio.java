package repositorio;

import dominio.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetRepositorio implements RepositorioDAO<Pet> {

    private static Long ID_ATUAL = 1L;
    private final List<Pet> petsCadastrados = new ArrayList<>();

    @Override
    public Pet buscarPorId(Long id) {
        for (Pet pet : petsCadastrados) {
            if (pet.getId().equals(id)) {
                return pet;
            }
        }
        return null;
    }

    @Override
    public List<Pet> listarTodos() {
        return petsCadastrados;
    }

    @Override
    public Pet adicionar(Pet pet) {
        pet.setId(ID_ATUAL++);
        petsCadastrados.add(pet);
        return pet;
    }
}
