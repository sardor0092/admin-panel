package idrok.net.ngPrime.service;

import idrok.net.ngPrime.entity.User;
import idrok.net.ngPrime.service.dto.UserDto;
import idrok.net.ngPrime.service.vm.UserPasswordVM;

import java.util.List;
import java.util.Optional;

public interface UserService {


    public Optional<User> getByIdEntity(Long id);

    public List<UserDto> getAll();

    UserDto update(User user);

    public Optional<UserDto> getById(Long id);

    UserDto create(User user);

    User getCurrentUserEntity();

    public void deleteById(Long id);

    public void changePassword(UserPasswordVM userParolVM);

    UserDto getCurrentUser();

    Optional<User> getByLogin(String login);

    public String getCurrentLogin();
}
