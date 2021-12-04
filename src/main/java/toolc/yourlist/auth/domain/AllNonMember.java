package toolc.yourlist.auth.domain;

public interface AllNonMember {
  NonMember findByDeviceId(String deviceId);
}
