package toolc.yourlist.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAllVisitorEntity extends JpaRepository<VisitorEntity, Long> {
  Optional<VisitorEntity> findByUuid(String uuid);
  Optional<VisitorEntity> findById(Long id);
  VisitorEntity save(VisitorEntity visitorEntity);
}
