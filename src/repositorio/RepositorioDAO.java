package repositorio;

import java.util.List;

public interface RepositorioDAO<T> {

    T buscarPorId(Long id);

    List<T> listarTodos();

    T adicionar(T objeto);
}
