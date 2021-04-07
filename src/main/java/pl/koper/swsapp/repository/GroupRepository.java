package pl.koper.swsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koper.swsapp.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {

    Group findByName(String name);
}
