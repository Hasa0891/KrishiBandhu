package com.mahmudul.krishibandhuapi.user.admin;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdmin(Long adminId){
        return adminRepository.findById(adminId);
    }

    public Optional<Admin> modifyAdmin(Long id, Admin newAdmin){
        Optional<Admin> adminFound = adminRepository.findById(id);
        
        if(adminFound.isPresent()){
            Admin admin = adminFound.get();
            admin.setDob(newAdmin.getDob());
            admin.setPhone(newAdmin.getPhone());
            admin.setResponsibility(newAdmin.getResponsibility());
            return Optional.of(adminRepository.save(admin));
        }

        return adminFound;
    }

    public Boolean deleteAdmin(Long id){
        if(adminRepository.existsById(id)){
            adminRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
