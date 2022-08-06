package com.enesergen.bookPortal.service.concretes;

import com.enesergen.bookPortal.core.utilities.results.*;
import com.enesergen.bookPortal.dal.abstratcs.UserDAL;
import com.enesergen.bookPortal.entities.concretes.User;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import com.enesergen.bookPortal.service.abstracts.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {
    private final UserDAL userDAL;

    public UserManager(UserDAL userDAL) {
        this.userDAL = userDAL;
    }
    private static final Logger LOGGER= LoggerFactory.getLogger(UserManager.class);

    @Override
    public Result save(UserDTO userDTO) {
        if (!this.userDAL.existsByUsername(userDTO.getUsername())) {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setBooks(null);
            user.setFavoriteBooks(null);
            user = this.userDAL.save(user);
            if (this.userDAL.existsById(user.getId())) {
                LOGGER.info("Operation:Create User; Username:{} - Password:{}",user.getUsername(),user.getPassword());
                return new SuccessResult("User adding operation is successful.");
            } else {
                return new ErrorResult("The user could not be added.");
            }
        } else {
            return new ErrorResult("The username has been used");
        }

    }

    @Override
    public Result remove(UserDTO userDTO) {
        if (this.userDAL.existsByUsername(userDTO.getUsername())) {
            User user = this.userDAL.getByUsername(userDTO.getUsername());
            user.setActive(false);
            user = this.userDAL.save(user);
            if (!user.isActive()) {
                LOGGER.info("User's Active Attribute is changed to FALSE");
                return new SuccessResult("User removing operation is successful.");
            } else {
                return new ErrorResult("User could not be deleted");
            }
        } else {
            return new ErrorResult("User could not be found.");
        }
    }

    @Override
    public Result update(UserDTO userDTO) {
        if (this.userDAL.existsByUsername(userDTO.getUsername())) {
            User user = this.userDAL.getByUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            this.userDAL.save(user);
            LOGGER.info("User password changed, new password:{}",user.getPassword());

            return new SuccessResult("Password changing is successful");
        } else {
            return new ErrorResult("User could not be found");
        }
    }

    @Override
    public DataResult<User> getOne(long id) {
        Optional<User> user = this.userDAL.findById(id);
        if (user.isPresent()) {
            LOGGER.info("Get One User method called.Username:{}",user.get().getUsername());
            return new SuccessDataResult<>(user.get(), "Get one user operation is successful");
        } else {
            return new ErrorDataResult<>("User could not be found.");
        }

    }

    @Override
    public DataResult<List<User>> getAll() {
        List<User> users = this.userDAL.findAll();
        if (!users.isEmpty()) {
            LOGGER.info("Get All User method called.");
            return new SuccessDataResult<>(users, "Get users operation is successful");
        } else {
            return new ErrorDataResult<>("Users  could not be found");
        }

    }
}
