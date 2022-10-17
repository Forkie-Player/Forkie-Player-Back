package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaAllNounEntity extends JpaRepository<NounEntity, Long> {
  @Query("select n.content from NounEntity n")
  List<String> findAllContent();
}
