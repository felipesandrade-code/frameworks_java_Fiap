import br.com.fiap.contatos.dao.CategoriaDao;
import br.com.fiap.contatos.dao.ProdutoraDao;
import br.com.fiap.contatos.model.Categoria;
import br.com.fiap.contatos.model.Produtora;
import br.com.fiap.contatos.utils.Conexao;
import br.com.fiap.contatos.dao.GameDao;
import br.com.fiap.contatos.model.Game;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Conexao.getEntityManager();
//        cadastrar(em);
//        atualizar(em);
//        excluir(em);
//        consultarContatoPorId(em);
//        listarTodosOsGames(em);
//        listarGamesPorId(em);
//        listarGamesPorProdutora(em);
//        listarGamesPorLancamento(em);
//        listarGamesPorStatus(em);
//        consultarCategoriaPeloId(em);
//        consultarProdutoraPeloId(em);
//        listarProdutoraPorNome(em);
    }

    public static void listarProdutoraPorNome(EntityManager em){
//      Criar uma instância do Dao;
        ProdutoraDao produtoraDao = new ProdutoraDao(em);

        List<Produtora> produtoras = produtoraDao.buscarProdutoraPeloNome("Santa Monica Studio");

        for (Produtora produtora : produtoras){
            System.out.println("------------------------------");
            System.out.println(produtoras.toString());
            System.out.println("------------------------------");
        }

        System.out.println("Fim dos registros.....");
    }

    private static void consultarCategoriaPeloId(EntityManager em) {
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Categoria categoriaBuscada = new Categoria();
        categoriaBuscada.setId(3L);

        Categoria categoriaEncontrada = new Categoria();
        categoriaEncontrada = categoriaDao.buscarCategoriaPeloId(categoriaBuscada);

        System.out.println(categoriaEncontrada.getNomeCategoria());
        System.out.println(categoriaEncontrada.getGames());

    }


    public static void listarGamesPorStatus(EntityManager em){
//      Criar uma instância do Dao;
        GameDao gameDao = new GameDao(em);

        List<Game> games = gameDao.listarGamesPorStatus(true);

        if(games.isEmpty()){
            System.out.println("Não possuímos games que não foram finalizados....");
        } else{
            for (Game game : games){
                System.out.println("------------------------------");
                System.out.println(game.toString());
                System.out.println("------------------------------");
            }
        }

        System.out.println("Fim dos registros.....");
    }

    public static void listarGamesPorLancamento(EntityManager em){
//      Criar uma instância do Dao;
        GameDao gameDao = new GameDao(em);

        List<Game> games = gameDao.listarGamesPorLancamento(LocalDate.of(1994, 1, 1), LocalDate.of(2025, 10, 20));

        for (Game game : games){
            System.out.println("------------------------------");
            System.out.println(game.toString());
            System.out.println("------------------------------");
        }

        System.out.println("Fim dos registros.....");
    }


    public static void listarGamesPorProdutora(EntityManager em){
//      Criar uma instância do Dao;
        GameDao gameDao = new GameDao(em);

        List<Game> games = gameDao.listarGamesPorProdutora("Rockstar Games");

        for (Game game : games){
            System.out.println("------------------------------");
            System.out.println(game.toString());
            System.out.println("------------------------------");
        }

        System.out.println("Fim dos registros.....");
    }


    public static void listarGamesPorId(EntityManager em){
//      Criar uma instância do Dao;
        GameDao gameDao = new GameDao(em);

        List<Game> games = gameDao.listarGamesPorId(3L);

        for (Game game : games){
            System.out.println("------------------------------");
            System.out.println(game.toString());
            System.out.println("------------------------------");
        }

        System.out.println("Fim dos registros.....");
    }


    public static void listarTodosOsGames(EntityManager em){
//      Criar uma instância do Dao;
        GameDao gameDao = new GameDao(em);

        List<Game> games = gameDao.listarTodosOsGames();

        for (Game game : games){
            System.out.println("------------------------------");
            System.out.println(game.toString());
            System.out.println("------------------------------");
        }

        System.out.println("Fim dos registros.....");
    }

    public static void cadastrar(EntityManager em){
        Produtora produtora = new Produtora();
        produtora.setNomeProdutora("Santa Monica Studio");
        produtora.setCidadeProdutora("Los Angeles");

        ProdutoraDao produtoraDao = new ProdutoraDao(em);
        em.getTransaction().begin();

        produtoraDao.salvar(produtora);


        Categoria categoria = new Categoria();
        categoria.setNomeCategoria("Ação");

        CategoriaDao categoriaDao = new CategoriaDao(em);

        categoriaDao.salvar(categoria);

        Game game1 = new Game();
        game1.setTitulo("God Of War II");
        game1.setDataLancamento(LocalDate.of(2007,3, 13));
        game1.setFinalizado(true);
        game1.setProdutora(produtora);
        game1.setValor(250.00);
        game1.setCategoria(categoria);


        GameDao gameDao = new GameDao(em);

        gameDao.salvar(game1);

        em.getTransaction().commit();
    }

    public static void atualizar(EntityManager em){
        Produtora produtora = new Produtora();
        produtora.setNomeProdutora("EA");
        produtora.setCidadeProdutora("Montreuil");

        ProdutoraDao produtoraDao = new ProdutoraDao(em);
        produtoraDao.salvar(produtora);

        Categoria categoria = new Categoria();
        categoria.setNomeCategoria("Ação");


        Game game1 = new Game();
        game1.setId(2L);
        game1.setTitulo("Farcry 4");
        game1.setDataLancamento(LocalDate.of(2014, 6, 10));
        game1.setFinalizado(true);
        game1.setProdutora(produtora);
        game1.setValor(200.00);
        game1.setCategoria(categoria);
        GameDao gameDao = new GameDao(em);

        em.getTransaction().begin();
        gameDao.atualizar(game1);
        em.getTransaction().commit();
    }


    public static void excluir(EntityManager em){
        Game game1 = new Game();
        game1.setId(21L);

        GameDao gameDao = new GameDao(em);

        em.getTransaction().begin();
        gameDao.excluir(game1);
        em.getTransaction().commit();
    }

    public static void consultarGamePorId(EntityManager em){
        GameDao gameDao = new GameDao(em);

        em.getTransaction().begin();
        gameDao.consultaId(2L);
        em.getTransaction().commit();
    }


    public static void consultarProdutoraPeloId(EntityManager em){
        ProdutoraDao produtoraDao = new ProdutoraDao(em);
        Produtora produtoraProcurada = new Produtora();
        produtoraProcurada.setId(1L);

        Produtora produtoraEncontrada = new Produtora();
        produtoraEncontrada = produtoraDao.buscarProdutoraPeloId(produtoraProcurada);

        System.out.println(produtoraEncontrada.getId());
        System.out.println(produtoraEncontrada.getGame());
    }
}
