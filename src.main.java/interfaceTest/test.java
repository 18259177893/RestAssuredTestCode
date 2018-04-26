package interfaceTest;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;




//静态引入方法，以提高使用rest-assured的效率
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class test {
	@BeforeClass
	public static void setSSL() {
		//设置默认跳过ssl验证
		RestAssured.useRelaxedHTTPSValidation();
	}
	@Test
	public void getTest(){
		get("https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived").prettyPeek();
	}
	@Test
	public void getTest1(){
//		https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("limit", 2);
		map.put("offset", 0);
		map.put("type", "last_actived");		
		System.out.println("打印-------");
		given().params(map).get("https://testerhome.com/api/v3/topics.json").prettyPeek();
	}
	public void getTest2(){
//		https://testerhome.com/topics/12972
		Map<String,Object> map = new HashMap<>();
		map.put("topics", "topics");
		map.put("topicid", 12972);
		get("https://testerhome.com/{topics}/{topicid}",map).prettyPeek();
		
		
	}
	public void getTest3(){
//		https://testerhome.com/topics/12972		
		get("https://testerhome.com/{topics}/{topicid}","topics",12972).prettyPeek();
		
		
		
	}
	
	
	@Test
	public void testTesterHomeJson(){
		given().when().get("https://testerhome.com/api/v3/topics.json").prettyPeek()
		.then()
			.statusCode(200)
			.body("topics.title", hasItems("优质招聘汇总"))
			.body("topics.title[1]",equalTo("优质招聘汇总"))
			;
		
		
	}
	
	@Test
	public void testJsonPost(){
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("id", 1040);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
