package com.shirajussalekin.lms.controllers;

import com.shirajussalekin.lms.dto.RoleDto;
import com.shirajussalekin.lms.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping("/add")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleService.createRole(roleDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Long roleId) {
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PutMapping("{id}")
    public ResponseEntity<RoleDto> updateRole(
            @PathVariable("id") long roleId,
            @RequestBody RoleDto updatedRole){
        return ResponseEntity.ok(roleService.updateRole(roleId, updatedRole));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(
            @PathVariable("id") Long roleId
    ) {
        roleService.deleteRole(roleId);
        return ResponseEntity.ok("The Role has been deleted successfully!");
    }

}
