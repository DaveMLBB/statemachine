package co.develhope.statemachine;

import co.develhope.statemachine.security.JwtAuthenticationFilter;
import co.develhope.statemachine.services.UserService;
import co.develhope.statemachine.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.convert.Jsr310Converters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = { StatemachineApplication.class, Jsr310Converters.class })
public class StatemachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatemachineApplication.class, args);
	}


	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
