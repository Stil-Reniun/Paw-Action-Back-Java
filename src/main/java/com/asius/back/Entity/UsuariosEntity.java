package com.asius.back.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "usuario")
@Data
public class UsuariosEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusurios;

    private String username;
    private String password;
    private String img;
    private String nombuser;
    private String apelliuser;
    private String emailuser;
    private String telefuser;
    private String perfiluser;
    private boolean enable = true;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "usuariorol")
    @JsonIgnore
    private Set<UsuarioRolEntity> usuariorolentity = new HashSet<>();
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autorizacion = new HashSet<>();
        this.usuariorolentity.forEach(usuarioRolEntity -> {
            autorizacion.add(new Authority(usuarioRolEntity.getRolusario().getNombrol()));
        });
        return autorizacion;
    }

    public UsuariosEntity(){

    }


}
