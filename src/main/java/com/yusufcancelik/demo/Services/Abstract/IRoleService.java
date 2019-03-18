package com.yusufcancelik.demo.Services.Abstract;

import com.yusufcancelik.demo.Models.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

    Role findById(Long id);

    Role Create(Role role);

    Role Update(Role role,Role updatedRole);

    void Delete(Role role);
}
