package idrok.net.ngPrime.repository;

import idrok.net.ngPrime.entity.Roles;
import idrok.net.ngPrime.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User ,Long> {

  Optional <User> findByLogin(String login);
  List<User> findAllByRolesContains(Roles roles);



}
