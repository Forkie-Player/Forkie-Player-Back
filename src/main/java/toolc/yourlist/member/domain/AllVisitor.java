package toolc.yourlist.member.domain;

public interface AllVisitor {
  boolean isNotExistByUUID(String uuid);

  boolean isNotExistById(Long id);

  void registerVisitor(String uuid);

  Long findIdByUUID(String uuid);
}
