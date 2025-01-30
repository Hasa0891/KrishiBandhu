package com.mahmudul.krishibandhuapi.user.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.AdminDTO;

import jakarta.validation.Valid;

import java.net.URI;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users/admins")
@Validated
public class AdminController {
    
    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody AdminDTO adminDto) {
        
        Admin admin = adminService.createAdmin(adminDto.toAdminEntity());
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(admin.getId())
                        .toUri();

        return ResponseEntity.created(location).body(admin);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<?> getAdmin(@PathVariable("adminId") Long adminId) {
        Optional<Admin> admin = adminService.getAdmin(adminId);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody AdminDTO adminDto, @PathVariable Long adminId) {
        Optional<Admin> admin = adminService.modifyAdmin(adminId, adminDto.toAdminEntity());
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) {
        Boolean deleted = adminService.deleteAdmin(adminId);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
