/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 *
 */
package tw.teddysoft.gof.Adapter.ans;

import java.util.List;

public interface AgentModelContext {
    void setAgent(Agent agent);

    Agent getAgent();

    void addAcceptor(Acceptor acceptor);

    Acceptor getAcceptor(String key);

    List<Acceptor> getAcceptors();
}