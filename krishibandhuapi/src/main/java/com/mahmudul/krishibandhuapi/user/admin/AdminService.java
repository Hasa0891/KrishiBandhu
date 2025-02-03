package com.mahmudul.krishibandhuapi.user.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.exceptions.user.admin.AdminNotFoundException;

@Service
public class AdminService {
    
    private AdminRepository adminRepository;
    private PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder){
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin createAdmin(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public Admin getAdmin(Long adminId){
        return adminRepository.findById(adminId)
        .orElseThrow(() -> new AdminNotFoundException("Admin Not Found with Id : " + adminId));
    }

    public Admin modifyAdmin(Long adminId, Admin newAdmin){
        return adminRepository.findById(adminId)
        .map(admin -> {
            admin.setDob(newAdmin.getDob());
            admin.setPhone(newAdmin.getPhone());
            admin.setResponsibility(newAdmin.getResponsibility());
            return adminRepository.save(admin);
        })
        .orElseThrow(() -> new AdminNotFoundException("Admin Not Found with Id : " + adminId));
    }

    public void deleteAdmin(Long adminId){
        if(!adminRepository.existsById(adminId)){
            throw new AdminNotFoundException("Admin Not Found with Id : " + adminId);
        }
        adminRepository.deleteById(adminId);
    }
}
