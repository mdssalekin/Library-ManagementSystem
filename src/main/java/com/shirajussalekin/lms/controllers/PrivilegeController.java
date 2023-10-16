package com.shirajussalekin.lms.controllers;

import com.shirajussalekin.lms.dto.AuthorDto;
import com.shirajussalekin.lms.dto.PrivilegeDto;
import com.shirajussalekin.lms.services.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/privileges")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping("/add")
    public ResponseEntity<PrivilegeDto> createPrivilege(@RequestBody PrivilegeDto privilegeDto){
        return new ResponseEntity<>(privilegeService.createPrivilege(privilegeDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PrivilegeDto> getPrivilegeById(@PathVariable("id") Long privilegeId) {
        return ResponseEntity.ok(privilegeService.getPrivilegeById(privilegeId));
    }

    @GetMapping
    public ResponseEntity<List<PrivilegeDto>> getAllAuthors(){
        return ResponseEntity.ok(privilegeService.getAllPrivileges());
    }

    @PutMapping("{id}")
    public ResponseEntity<PrivilegeDto> updatePrivilege(
            @PathVariable("id") long privilegeId,
            @RequestBody PrivilegeDto updatedPrivilege){
        return ResponseEntity.ok(privilegeService.updatePrivilege(privilegeId, updatedPrivilege));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePrivilege(
            @PathVariable("id") Long privilegeId
    ) {
        privilegeService.deletePrivilege(privilegeId);
        return ResponseEntity.ok("The Privilege has been deleted successfully!");
    }

}
