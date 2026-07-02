package repositories;

import models.Potion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotionRepository extends JpaRepository <Potion, Integer> {

};
