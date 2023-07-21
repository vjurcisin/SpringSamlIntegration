package sk.jurcisin.config;

import org.springframework.security.saml.provider.service.config.SamlServiceProviderSecurityConfiguration;
import org.springframework.security.saml.provider.service.config.SamlServiceProviderServerBeanConfiguration;

import static org.springframework.security.saml.provider.service.config.SamlServiceProviderSecurityDsl.serviceProvider;

@EnableWebSecurity
@Configuration
@Order(1)
public class WebSecurity extends SamlServiceProviderSecurityConfiguration {

    private SamlAppConfig samlAppConfig;

    public SamlWebSecurityConfiguration(
            SamlServiceProviderServerBeanConfiguration configuration, @Qualifier("samlAppConfig") SamlAppConfig samlAppConfig) {
        super("/saml/sp/",configuration);
        this.samlAppConfig = samlAppConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.apply(serviceProvider()).configure(samlAppConfig);
    }
}
