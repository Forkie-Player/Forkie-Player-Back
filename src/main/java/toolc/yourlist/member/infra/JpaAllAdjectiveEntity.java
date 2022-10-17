package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaAllAdjectiveEntity extends JpaRepository<AdjectiveEntity, Long> {
  @Query("select a.content from AdjectiveEntity a")
  List<String> findAllContent();
}
