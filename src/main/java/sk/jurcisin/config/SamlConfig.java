package sk.jurcisin.config;

import org.springframework.security.saml.provider.SamlServerConfiguration;
import org.springframework.security.saml.provider.service.config.SamlServiceProviderServerBeanConfiguration;

@Configuration
public class SamlConfig extends SamlServiceProviderServerBeanConfiguration {

    private final SamlAppConfig samlAppConfig;

    public SamlConfig(SamlAppConfig samlAppConfig){
        this.samlAppConfig = samlAppConfig;
    }

    @Override
    protected SamlServerConfiguration getDefaultHostSamlServerConfiguration() {
        return samlAppConfig;
    }
}
