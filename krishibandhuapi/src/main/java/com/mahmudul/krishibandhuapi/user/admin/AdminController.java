package com.mahmudul.krishibandhuapi.user.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.AdminDTO;

import jakarta.validation.Valid;

import java.net.URI;

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
    public ResponseEntity<Admin> getAdmin(@PathVariable("adminId") Long adminId) {
        Admin admin = adminService.getAdmin(adminId);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody AdminDTO adminDto, @PathVariable Long adminId) {
        Admin admin = adminService.modifyAdmin(adminId, adminDto.toAdminEntity());
        return ResponseEntity.ok(admin);
    }
    
    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long adminId) {
        adminService.deleteAdmin(adminId);
        return ResponseEntity.notFound().build();
    }
}
