package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Categoria;
import br.com.fiap.contatos.model.Produtora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProdutoraDao {
    private EntityManager em;

    public ProdutoraDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Produtora produtora){
        em.persist(produtora);
    }

    public Produtora buscarProdutoraPeloId(Produtora produtora){
        return em.find(Produtora.class, produtora.getId());
    }
    public List<Produtora> buscarProdutoraPeloNome(String nome){
        String Jpql = "SELECT p FROM Produtora p WHERE LOWER(p.nomeProdutora) LIKE LOWER (:nome)";

        return em.createQuery(Jpql)
                .setParameter("nome", nome)
                .getResultList();
    }


}
