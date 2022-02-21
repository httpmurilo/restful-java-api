package io.murilo.user.model;

import javax.persistence.*;

@Entity
@Table
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private String numero;
    //muitos telefones para um usuário
    @org.hibernate.annotations.ForeignKey(name = "usuario_id")
    @ManyToOne
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
