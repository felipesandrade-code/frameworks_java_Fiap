package br.com.fiap.contatos.dao;

import br.com.fiap.contatos.model.Game;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class GameDao {

    private EntityManager em;

//  Construtor recebendo um EntityManager.
    public GameDao(EntityManager em){
        this.em = em;
    }

//  Realizando a persistência (salvamento) de um jogo/game no banco de dados.
    public void salvar(Game game){
        em.persist(game);
    }

//  Realizando a atualização de um game já existente.
    public void atualizar(Game game){
        em.merge(game);
    }
//  Realizando a exclusão do de um game já existente.
    public void excluir(Game game){
        em.find(Game.class, game.getId());
        em.remove(game);
    }

    public void consultaId(Long id){
        Game gameConsultado = em.find(Game.class, id);
        if (gameConsultado == null){
            System.out.println("Game não encontrado");
        }else{
            System.out.println("-----------------------");
            System.out.println(gameConsultado.toString());
            System.out.println("-----------------------");
        }
    }

    public List<Game> listarTodosOsGames(){
        //SELECT * FROM tbl_games ORDER BY nome ASC

        //JPQL
        String consulta = "SELECT g FROM Game g ORDER BY id ASC";

        return em.createQuery(consulta).getResultList();
    }

    public List<Game> listarGamesPorId(long idProcurado){
        //SELECT g FROM Game g WHERE ID = ????
        String consulta = "SELECT g FROM Game g WHERE id = :id";

        return em.createQuery(consulta, Game.class)
                .setParameter("id", idProcurado)
                .getResultList();
    }

    public List<Game> listarGamesPorProdutora(String produtoraProcurada){
        //SELECT g from Game g WHERE produtora = ?????
        String consulta = "SELECT g FROM Game g WHERE produtora = :produtora";

        return em.createQuery(consulta,Game.class)
                .setParameter("produtora", produtoraProcurada)
                .getResultList();
    }

    public List<Game> listarGamesPorLancamento(LocalDate dataInicial, LocalDate dataFinal){
        //SELECT g from Game g WHERE g.dataLancamento BETWEEN :dataInicial AND :dataFinal ORDER BT g.titulo ASC
        String consulta = "SELECT g from Game g WHERE g.dataLancamento BETWEEN :dataInicial AND :dataFinal ORDER BY g.titulo ASC";
        return em.createQuery(consulta,Game.class)
                .setParameter("dataInicial",dataInicial)
                .setParameter("dataFinal", dataFinal)
                .getResultList();
    }

    public List<Game> listarGamesPorStatus(Boolean finalizado){
        String consulta = "SELECT g from Game g WHERE g.finalizado = :finalizado ORDER BY g.titulo";
        return em.createQuery(consulta,Game.class)
                .setParameter("finalizado", finalizado)
                .getResultList();
    }
}
