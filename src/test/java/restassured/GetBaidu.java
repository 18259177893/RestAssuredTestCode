package restassured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetBaidu {
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class only run one time");
	}	
	@Before
	public void befor(){
		useRelaxedHTTPSValidation();
	}
	@Test
	public void getBaidu(){
		given()
				.when()
				.get("https://www.baidu.com").prettyPeek()
				.then()
				.statusCode(200);
	}
	
	

}
