package idrok.net.ngPrime.service.vm;
import java.util.List;
import java.util.Optional;

public interface GeneralServiceUser <Entity ,IdType> {

    /**
     * @return All Entity
     * */
    List<Entity> getAll();
    Optional<Entity> getById(IdType id);
    Entity create(Entity entity);
    Entity update(Entity entity);
    void delete(Entity entity);
    void deleteById(IdType id);

}
