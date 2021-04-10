package com.beach.manager.service.profile;

import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest {

	@InjectMocks
	ProfileService profileService;

	@Test
	public void testGetProfile() {
		assertEquals(profileService.getProfile(), 0);
	}

	// java -jar path/to/your/jarfile.jar fully.qualified.package.Application
}
