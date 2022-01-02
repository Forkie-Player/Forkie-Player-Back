package toolc.yourlist.auth.domain;

public interface AllNonMember {
  NonMember findByDeviceId(String deviceId);
  boolean exist(String deviceId);
  NonMember save(NonMember nonMember);
}
