package com.asius.back.Repository;



import com.asius.back.Entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuariosEntity,Integer> {

    public UsuariosEntity findByUsername (String username);

}
