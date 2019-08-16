package com.wipro.MongoGamification;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes = MongoGamificationApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
public class RandomPortTest {

  @LocalServerPort
  int randomServerPort;
   
 @Test
  public void testGetEmployeeListSuccess() throws URISyntaxException
  {
      RestTemplate restTemplate = new RestTemplate();
       
      final String baseUrl = "ec2-13-234-225-9.ap-south-1.compute.amazonaws.com";
      URI uri = new URI(baseUrl);
   
     
      ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
       
      //Verify request succeed
      Assert.assertEquals(200, result.getStatusCodeValue());
      
  }
}