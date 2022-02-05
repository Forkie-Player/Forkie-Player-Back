package toolc.yourlist.member.infra;

import toolc.yourlist.member.domain.Visitor;

public class VisitorDomainAdapter {
  Visitor toDomainVisitor(VisitorEntity entity) {
    return new Visitor(entity.uuid());
  }
}
