package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Categoria;
import br.com.fiap.contatos.model.Game;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDao {

    private EntityManager em;

    //  Construtor recebendo um EntityManager.
    public CategoriaDao(EntityManager em){
        this.em = em;
    }

    //  Realizando a persistência (salvamento) de uma categoria no banco de dados.
    public void salvar(Categoria categoria){
        em.persist(categoria);
    }

    // Realizar a busca da categoria pelo Id.
    public Categoria buscarCategoriaPeloId(Categoria categoria){
        return em.find(Categoria.class, categoria.getId());
    }
}
