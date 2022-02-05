package toolc.yourlist.member.infra;

import lombok.RequiredArgsConstructor;
import toolc.yourlist.member.domain.AllVisitor;
import toolc.yourlist.member.domain.Visitor;

@RequiredArgsConstructor
public class JpaAllVisitor implements AllVisitor {

  private final JpaAllVisitorEntity jpaAllVisitorEntity;
  private final VisitorDomainAdapter adapter;

  @Override
  public boolean isNotExistByUUID(String uuid) {
    return jpaAllVisitorEntity.findByUuid(uuid).isEmpty();
  }

  @Override
  public boolean isNotExistById(Long id) {
    return jpaAllVisitorEntity.findById(id).isEmpty();
  }

  @Override
  public Visitor registerVisitor(String uuid) {
    return adapter.toDomainVisitor(jpaAllVisitorEntity.save(new VisitorEntity(uuid)));
  }

  @Override
  public Long findIdByUUID(String uuid) {
    return jpaAllVisitorEntity.findByUuid(uuid).get().id();
  }

}
