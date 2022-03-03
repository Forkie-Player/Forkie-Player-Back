package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface JpaAllVisitorEntity extends JpaRepository<VisitorEntity, Long> {
  Optional<VisitorEntity> findByUuid(String uuid);
  Optional<VisitorEntity> findById(Long id);
  VisitorEntity save(VisitorEntity visitorEntity);

  @Transactional
  void deleteByUuid(String uuid);
}
