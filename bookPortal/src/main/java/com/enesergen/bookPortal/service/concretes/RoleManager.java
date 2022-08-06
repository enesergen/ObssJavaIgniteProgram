package com.enesergen.bookPortal.service.concretes;

import com.enesergen.bookPortal.core.utilities.results.*;
import com.enesergen.bookPortal.dal.abstratcs.RoleDAL;
import com.enesergen.bookPortal.entities.concretes.Role;
import com.enesergen.bookPortal.entities.dtos.RoleDTO;
import com.enesergen.bookPortal.service.abstracts.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleManager implements RoleService {
    private final RoleDAL roleDAL;
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleManager.class);


    public RoleManager(RoleDAL roleDAL) {
        this.roleDAL = roleDAL;
    }

    @Override
    public Result save(RoleDTO roleDTO) {
        Role role = new Role();
        role.setName(roleDTO.getName());
        role = this.roleDAL.save(role);
        if (this.roleDAL.existsById(role.getId())) {
            LOGGER.info("Role saved.Role Name:{}", role.getName());
            return new SuccessResult("Role adding operation is successful.");
        }
        return new ErrorResult("Role could not be added.");
    }

    @Override
    public Result remove(long id) {
        if (this.roleDAL.existsById(id)) {
            var role = this.roleDAL.findById(id);
            if (role.isPresent()) {
                role.get().setActive(false);
                this.roleDAL.save(role.get());
                LOGGER.info("Role's active status is changed to FALSE.Role Name:{}",role.get().getName());
                return new SuccessResult("Role removing is successful.");
            } else {
                return new ErrorResult("The role could not be found");
            }
        } else {
            return new ErrorResult("The role could not be found");

        }

    }

    @Override
    public Result update(long id, RoleDTO roleDTO) {
        if (this.roleDAL.existsById(id)) {
            var role = this.roleDAL.findById(id);
            if (role.isPresent()) {
                String oldName = role.get().getName();
                role.get().setName(roleDTO.getName());
                LOGGER.info("Role name is updated.Old Name:{}, New Name:{} "
                        , oldName, role.get().getName());
                this.roleDAL.save(role.get());
                return new SuccessResult("Role updating is successful.");
            } else {
                return new ErrorResult("The role could not be found");
            }
        } else {
            return new ErrorResult("The role could not be found");

        }

    }

    @Override
    public DataResult<Role> getOne(long id) {
        Optional<Role> role =
                this.roleDAL.findById(id);
        if (role.isPresent()) {
            LOGGER.info("Get one role operation called.Role Name:{} ", role.get().getName());
            return new SuccessDataResult<>(role.get(), "Get One Role operation is successful");

        } else {
            return new ErrorDataResult<>("The role could not be found.");
        }

    }

    @Override
    public DataResult<List<Role>> getAll() {
        List<Role> roles =
                this.roleDAL.findAll();
        if (!roles.isEmpty()) {
            LOGGER.info("Get All roles operation called");

            return new SuccessDataResult<>(roles, "Get roles operations is successful");

        } else {
            return new ErrorDataResult<>("The roles could not be found.");

        }
    }
}
