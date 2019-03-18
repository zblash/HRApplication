package com.yusufcancelik.demo.Services.Concrete;

import com.yusufcancelik.demo.Models.Role;
import com.yusufcancelik.demo.Repositories.RoleRepository;
import com.yusufcancelik.demo.Services.Abstract.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Role Create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role Update(Role role, Role updatedRole) {
        return null;
    }

    @Override
    public void Delete(Role job) {

    }
}
