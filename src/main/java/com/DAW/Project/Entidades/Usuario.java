package com.DAW.Project.Entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ismael on 15/05/2017.
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String usuario;
    private String pass;
    private String email;
    private String tipo;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> roles;

    public Usuario() {
    }

    public Usuario(String usuario, String pass, String email, List<GrantedAuthority> roles) {
        this.usuario = usuario;
        this.pass = new BCryptPasswordEncoder().encode(pass);
        this.email = email;
        this.roles = roles;
        setTipo("");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            this.tipo = "Administrador";
        else
            this.tipo = "Usuario";
    }
}
