package br.com.fiap.contatos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tbl_produtora")
public class Produtora {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_PRODUTORA_SEQ"
    )
    @SequenceGenerator(
            name = "TB_PRODUTORA_SEQ",
            sequenceName = "TB_PRODUTORA_SEQ",
            allocationSize = 1)
    private Long id;

    @Column (name = "nm_produtora")
    private String nomeProdutora;

    @Column(name = "cd_produtora")
    private String cidadeProdutora;

    @OneToMany(mappedBy = "produtora")
    private List<Game> game;

    //    Getters and Setters
    public String getNomeProdutora() {
        return nomeProdutora;
    }

    public void setNomeProdutora(String nomeProdutora) {
        this.nomeProdutora = nomeProdutora;
    }

    public String getCidadeProdutora() {
        return cidadeProdutora;
    }

    public void setCidadeProdutora(String cidadeProdutora) {
        this.cidadeProdutora = cidadeProdutora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Game> getGame() {
        return game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Produtora{" +
                "id=" + id +
                ", nomeProdutora='" + nomeProdutora + '\'' +
                ", cidadeProdutora='" + cidadeProdutora + '\'' +
                ", game=" + game +
                '}';
    }
}
