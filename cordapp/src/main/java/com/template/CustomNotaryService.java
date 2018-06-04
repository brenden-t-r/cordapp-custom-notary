package com.template;


import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.FlowSession;
import net.corda.core.node.AppServiceHub;
import net.corda.core.node.services.CordaService;
import net.corda.core.node.services.TrustedAuthorityNotaryService;
import net.corda.core.node.services.UniquenessProvider;
import net.corda.node.services.transactions.PersistentUniquenessProvider;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;

@CordaService
public class CustomNotaryService extends TrustedAuthorityNotaryService {

    AppServiceHub services;
    PublicKey notaryIdentityKey;

    UniquenessProvider uniquenessProvider = new PersistentUniquenessProvider();

    public CustomNotaryService(AppServiceHub services, PublicKey notaryIdentityKey) {
        super();
        this.services = services;
        this.notaryIdentityKey = notaryIdentityKey;
    }

    public void start() {}

    public void stop() {}

    public FlowLogic<Void> createServiceFlow(FlowSession flowSession) {
        return null;
    }

    @NotNull
    @Override
    public AppServiceHub getServices() {
        return services;
    }

    @NotNull
    @Override
    public PublicKey getNotaryIdentityKey() {
        return notaryIdentityKey;
    }

    @NotNull
    @Override
    public UniquenessProvider getUniquenessProvider() {
        return uniquenessProvider;
    }


}
