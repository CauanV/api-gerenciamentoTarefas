package com.toDo.projetoDeGerenciamentoDeTarefas.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.toDo.projetoDeGerenciamentoDeTarefas.user.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> { //primeiro parametro o tipo da entidade da tabela,ou seja,UserModel e tipo da chave primaria
    /*
    * Isso dá a você vários métodos prontos, como:
    save(obj) → salva ou atualiza no banco
    findById(id) → busca por ID
    findAll() → busca todos
    delete(obj) → remove
    existsById(id) → verifica se existe
    *
    *O Spring vê que sua interface estende
    * JpaRepository e automaticamente gera a implementação em tempo de execução
    * */

    UserModel findByEmail(String email);
}
