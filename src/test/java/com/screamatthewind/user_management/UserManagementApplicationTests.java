package com.screamatthewind.user_management;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.preemptive;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserManagementApplication.class }, webEnvironment = RANDOM_PORT)
public class UserManagementApplicationTests {

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setUp() {
		System.out.println("Authenticating");
		RestAssured.authentication = preemptive().basic("user", "pass1");
		System.out.println("Authentication Done");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	@Test
	public void shouldSayUsername() {
		System.out.println("Running test: shouldSayUsername");
		get("http://localhost:" + port + "/user/test").then().assertThat().statusCode(200)
				.body("firstname", Matchers.equalTo("Bob")).and().body("lastname", Matchers.equalTo("Lawson"));
	}
}