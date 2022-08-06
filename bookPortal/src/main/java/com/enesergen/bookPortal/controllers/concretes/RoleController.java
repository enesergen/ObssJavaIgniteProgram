package com.enesergen.bookPortal.controllers.concretes;

import com.enesergen.bookPortal.controllers.abstracts.AbstractRoleController;
import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Role;
import com.enesergen.bookPortal.entities.dtos.RoleDTO;
import com.enesergen.bookPortal.service.abstracts.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController implements AbstractRoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("")
    @Override
    public Result createRole(@Valid @RequestBody RoleDTO roleDTO) {
        return this.roleService.save(roleDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public Result removeRole(@Valid @PathVariable long id) {
        return this.roleService.remove(id);
    }
    @PutMapping("/{id}")
    @Override
    public Result updateRole(@PathVariable long id,@Valid @RequestBody RoleDTO roleDTO) {
        return this.roleService.update(id,roleDTO);
    }
    @GetMapping("/{id}")
    @Override
    public DataResult<Role> getOneRole(@PathVariable long id) {
        return this.roleService.getOne(id);
    }
    @GetMapping("")
    @Override
    public DataResult<List<Role>> getAllRoles() {
        return this.roleService.getAll();
    }
}
