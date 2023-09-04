package kh.spring.gaji.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siot.IamportRestClient.IamportClient;


@Configuration
public class ResourceConfig {
	
	@Value("${rest.key}")
	    private String restKey;
	    
	@Value("${restsecret.key}")
	private String restSecretKey;
		
    @Bean
    public IamportClient api() { 
        return new IamportClient(restKey,restSecretKey);
    }
}
