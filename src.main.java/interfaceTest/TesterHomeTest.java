package interfaceTest;

import org.junit.Test;
//静态引入方法，以提高使用rest-assured的效率（三个常用的）
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TesterHomeTest {
//	书写测试用例(html验证)
	@Test
	public void testHtml(){
		useRelaxedHTTPSValidation();
		given()
				.queryParam("q", "appium")
		.when()
				.get("https://testerhome.com/search").prettyPeek()
		.then()
			   .statusCode(200)
			   .body("html.head.title", equalTo("appium · 搜索结果 · TesterHome"))
	    ;
	
	}
	@Test
	public void  testTesterHomeJson(){
		given().when().get("https://testerhome.com/api/v3/topics.json").prettyPeek()
		;
		
	}

	public static void main(String[] args) {
		

	}

}
