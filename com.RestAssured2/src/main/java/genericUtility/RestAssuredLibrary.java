package genericUtility;

import io.restassured.response.Response;


public class RestAssuredLibrary {

	public String getJsonData(Response resp, String path) {
		String jsonPath=resp.jsonPath().get(path);
		return jsonPath;
	}
}
