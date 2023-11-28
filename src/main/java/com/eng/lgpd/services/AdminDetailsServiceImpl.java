package com.eng.lgpd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eng.lgpd.dtos.AdminDTO;
import com.eng.lgpd.repositories.AdminRepository;
import com.eng.lgpd.security.UserSS;

@Primary
@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AdminDTO> admin = adminRepository.findByEmail(email);
        if (admin.isPresent()) {
            return new UserSS(admin.get().getId(), admin.get().getEmail(), admin.get().getPassword(), admin.get().getProfiles());
        }
        throw new UsernameNotFoundException(email);
    }
}