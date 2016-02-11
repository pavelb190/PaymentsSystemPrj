package by.it.academy.my.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

public class AppFileAccessingTest {
	
	@Ignore
	@Test
	public void testReadPropertyFileFromClassPath() throws IOException {
		
		final String propFileName = "db.properties";
		
		Properties properties = new Properties();
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if (inputStream != null) {
			
			properties.load(inputStream);
			
			assertEquals( "Property file is not empty!", true, !properties.isEmpty() );
			
			System.out.println(properties.getProperty("dbname"));
			
		} else {
			
			throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath!");
		}
	}
	
}
