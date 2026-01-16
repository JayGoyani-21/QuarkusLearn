package org.acme.service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AppStartupService {

    private static final Logger LOG = Logger.getLogger(AppStartupService.class);

    @PostConstruct
    void onStart() {
        LOG.info("🚀 Task Manager application started successfully");
    }
}
