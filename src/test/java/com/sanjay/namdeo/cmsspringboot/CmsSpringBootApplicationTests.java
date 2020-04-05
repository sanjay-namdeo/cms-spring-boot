package com.sanjay.namdeo.cmsspringboot;

import com.sanjay.namdeo.cmsspringboot.api.CustomerResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsSpringBootApplicationTests {
	@Autowired
	private CustomerResource customerResource;

	@Test
	public void contextLoads() throws Exception {
		assert customerResource != null;
	}
}
