package com.eep.wo.config;

import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.eep.wo.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(com.eep.wo.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.Supplier.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.Address.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.Customer.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.Product.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.Material.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.RawComponent.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.BOM.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.BOMMaterialLine.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.BOMComponentLine.class.getName(), jcacheConfiguration);
            cm.createCache(com.eep.wo.domain.Product.class.getName() + ".productBOMS", jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
