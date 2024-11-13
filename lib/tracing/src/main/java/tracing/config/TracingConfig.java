package tracing.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@AutoConfiguration
@PropertySource(value = "classpath:tracing.properties")
public class TracingConfig {
}
