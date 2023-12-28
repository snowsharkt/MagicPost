package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Admin;

import java.util.List;

public interface AdminServices {
    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    Admin createAdmin(Admin admin);

    Admin updateAdmin(Admin admin);

    void deleteAdminById(Long id);
}
