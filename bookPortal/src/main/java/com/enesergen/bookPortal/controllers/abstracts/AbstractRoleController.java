package com.enesergen.bookPortal.controllers.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Role;
import com.enesergen.bookPortal.entities.dtos.RoleDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface AbstractRoleController {
    Result createRole(RoleDTO roleDTO);
    Result removeRole(long id);
    Result updateRole(long id,RoleDTO roleDTO);
    DataResult<Role> getOneRole(long id);
    DataResult<List<Role>>getAllRoles();



}
