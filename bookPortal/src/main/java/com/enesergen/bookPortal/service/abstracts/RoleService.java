package com.enesergen.bookPortal.service.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Role;
import com.enesergen.bookPortal.entities.dtos.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Result save(RoleDTO roleDTO);
    Result remove(long id);
    Result update(long id,RoleDTO roleDTO);
    DataResult<Role> getOne(long id);
    DataResult<List<Role>>getAll();
}
