package idrok.net.ngPrime.service.serviceImpl;

import idrok.net.ngPrime.entity.Roles;
import idrok.net.ngPrime.entity.User;
import idrok.net.ngPrime.repository.UserRepository;
import idrok.net.ngPrime.service.UserService;
import idrok.net.ngPrime.service.dto.UserDto;
import idrok.net.ngPrime.service.vm.UserPasswordVM;
import jdk.internal.dynalink.support.NameCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }



    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }



    @Override
    public Optional<User> getByIdEntity(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAllByRolesContains(Roles.MANAGER)
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(User user) {
        return new UserDto(userRepository.save(user));
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return userRepository.findById(id).map(UserDto::new);
    }

    @Override
    public UserDto create(User user) {

        user.setPassword(NameCodec.encode(user.getPassword()));
        HashSet<Roles> hs = new HashSet<>();
        hs.add(Roles.MANAGER);
        user.setRoles(hs);
        return new UserDto(userRepository.save(user));
    }

    @Override
    public User getCurrentUserEntity() {
        String username= getPrincipal();
        if (username !=null)
            return userRepository.findByLogin(username).orElse(null);
        return null;
    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void changePassword(UserPasswordVM userParolVM) {
        Optional<User> user = userRepository.findByLogin(userParolVM.getLogin());
        if(user.isPresent() && user.get().getPassword().equals(userParolVM.getOldPassword())){
            user.get().setPassword(userParolVM.getNewPassword());
            userRepository.save(user.get());
        } else {
            throw new RuntimeException(" an error occurred ");
        }

    }

    @Override
    public UserDto getCurrentUser() {
        String username = getPrincipal();
        if (username != null)
            return userRepository.findByLogin(username).map(UserDto::new).orElse(null);
        return null;
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public String getCurrentLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
