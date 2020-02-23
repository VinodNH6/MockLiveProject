package vinwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("vinwork.service")
public class RestTemplateConfig {

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
//		MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
//		converter.setObjectMapper(new ObjectMapper());
//		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}
}