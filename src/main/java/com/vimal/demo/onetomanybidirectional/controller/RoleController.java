package com.vimal.demo.onetomanybidirectional.controller;

import com.vimal.demo.onetomanybidirectional.model.Role;
import com.vimal.demo.onetomanybidirectional.repository.RoleRepository;
import com.vimal.demo.onetomanybidirectional.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    private RoleService roleService;
    private RoleRepository roleRepository;

    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return  roleService.addRole(role);
    }

    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

    @GetMapping("/role/details/{id}")
    public Role getRole(@PathVariable Long id) {
        if(roleRepository.findById(id).isPresent())
            return roleRepository.findById(id).get();
        else
            return null;
    }

    @GetMapping("/role/all")
    public List<Role> getRoles() {
        return (List<Role>)roleRepository.findAll();

    }

}
