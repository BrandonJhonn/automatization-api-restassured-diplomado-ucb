package factoryRequest;

import io.restassured.response.Response;
import util.CGetProperties;

import static io.restassured.RestAssured.given;

public class CRequestPost implements IRequest{
    @Override
    public Response send(CRequestInfo requestInfo) {

        Response response = given()
                .auth()
                .preemptive()
                .basic(CGetProperties.getInstance().getpStrUser(), CGetProperties.getInstance().getpStrPwd())
                .body(requestInfo.getBody())
                .log().all()
                .when()
                .post(requestInfo.getUrl());

        response.then().log().all();

        return response;
    }
}
