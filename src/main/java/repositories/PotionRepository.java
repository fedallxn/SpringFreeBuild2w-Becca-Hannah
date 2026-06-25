package repositories;

import models.Potion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface potionRepository extends JpaRepository <Potion, Integer> {

};
