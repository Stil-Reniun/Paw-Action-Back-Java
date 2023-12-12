package com.asius.back.Controllers;
import com.asius.back.Entity.RolEntity;
import com.asius.back.Entity.UsuarioRolEntity;
import com.asius.back.Entity.UsuariosEntity;
import com.asius.back.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioServices userService;

    @GetMapping (value = "/{username}")
    public UsuariosEntity obtenerUsuario (@PathVariable("username") String username){
        UsuariosEntity userlocal = new UsuariosEntity();
        userlocal = userService.obtenerUsuarioService(username);
        return userlocal;
    }


    @PostMapping("/registrarUsuario")
    public UsuariosEntity agregarUsuario (@RequestBody UsuariosEntity userJsonEntity) throws Exception{
         Set<UsuarioRolEntity> userRolController =  new HashSet<>();
         RolEntity rol = new RolEntity();
         rol.setIdrol(1);
         rol.setNombrol("Usuario");
         UsuarioRolEntity userrol = new UsuarioRolEntity();
         userrol.setUsuariorol(userJsonEntity);
         userrol.setRolusario(rol);
        userRolController.add(userrol);
        return userService.guardarUsuarioService(userJsonEntity,userRolController);
    }


    @GetMapping("/listar")
    public ResponseEntity<List<UsuariosEntity>> listarUsuarios() {
        List<UsuariosEntity> usuarios = userService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

}
