package cleanTest;

import factoryRequest.CRequestFactory;
import factoryRequest.CRequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.CAPIConfiguration;

import static org.hamcrest.Matchers.equalTo;

public class CProjectTest {

    Response response;
    JSONObject body = new JSONObject();
    CRequestInfo requestInfo = new CRequestInfo();
    int pIntIdProject;

    @BeforeEach
    public void init() {

        /// CREATE PROJECT
        body.put("Content", "TEST_API_PROJECT");
        body.put("Icon", 1);
        requestInfo.setUrl(CAPIConfiguration.CREATE_PROJECT);
        requestInfo.setBody(body.toString());
        response = CRequestFactory.make("post").send(requestInfo);
        response.then().body("Content", equalTo(body.get("Content"))).statusCode(200);
        pIntIdProject = response.then().extract().path("Id");
    }

    @Test
    public void verifyCrudItem() {

        /// CREATE ITEM
        body.put("Content", "TEST_ITEM_CONTENT");
        body.put("ProjectId", pIntIdProject);
        body.put("Priority", 1);
        requestInfo.setUrl(CAPIConfiguration.CREATE_ITEM);
        requestInfo.setBody(body.toString());
        response = CRequestFactory.make("post").send(requestInfo);
        response.then().body(
          "Content", 
          equalTo(body.get("Content"))
        ).statusCode(200);
        int vIntIdItem = response.then().extract().path("Id");

        /// UPDATE ITEM
        body.put("Content", "TEST_ITEM_CONTENT_UPDATED");
        body.put("Priority", 2);
        body.put("Checked", true);
        requestInfo.setUrl(String.format(CAPIConfiguration.UPDATE_ITEM, vIntIdItem));
        requestInfo.setBody(body.toString());
        response = CRequestFactory.make("put").send(requestInfo);
        response.then().body(
          "Content", 
          equalTo(body.get("Content"))
        ).statusCode(200);

        /// READ ITEM
        requestInfo.setUrl(String.format(CAPIConfiguration.READ_ITEM, vIntIdItem));
        requestInfo.setBody(body.toString());
        response = CRequestFactory.make("get").send(requestInfo);
        response.then().body(
          "Content", 
          equalTo(body.get("Content"))
        ).statusCode(200);

        /// DELETE ITEM
        requestInfo.setUrl(String.format(CAPIConfiguration.DELETE_ITEM, vIntIdItem));
        requestInfo.setBody(body.toString());
        response = CRequestFactory.make("delete").send(requestInfo);
        response.then().body(
          "Content", 
          equalTo(body.get("Content"))
        ).statusCode(200);
    }
}
