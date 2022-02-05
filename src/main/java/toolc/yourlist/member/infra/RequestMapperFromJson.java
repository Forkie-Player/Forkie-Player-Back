package toolc.yourlist.member.infra;

public class RequestMapperFromJson {

  String mapper(JsonVisitorSignUpRequest jsonRequest) {
    return jsonRequest.uuid();
  }
}
