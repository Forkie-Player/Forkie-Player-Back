package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllVisitor;

@RequiredArgsConstructor
public class JpaAllVisitor implements AllVisitor {

  private final JpaAllVisitorEntity jpaAllVisitorEntity;
  private final VisitorEntityToDomainAdapter adapter;

  @Override
  public boolean isExistByUUID(String uuid) {
    return jpaAllVisitorEntity.findByUuid(uuid).isPresent();
  }

  @Override
  public boolean isNotExistByUUID(String uuid) {
    return jpaAllVisitorEntity.findByUuid(uuid).isEmpty();
  }

  @Override
  public boolean isNotExistById(Long id) {
    return jpaAllVisitorEntity.findById(id).isEmpty();
  }

  @Override
  public void registerVisitor(String uuid) {
    jpaAllVisitorEntity.save(new VisitorEntity(uuid));
  }

  @Override
  public Long findIdByUUID(String uuid) {
    return jpaAllVisitorEntity.findByUuid(uuid).get().id();
  }

  @Override
  public void deleteByUUID(String uuid) {
    jpaAllVisitorEntity.deleteByUuid(uuid);
  }

}
