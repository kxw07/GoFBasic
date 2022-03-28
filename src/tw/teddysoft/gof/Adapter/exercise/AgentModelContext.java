package tw.teddysoft.gof.Adapter.exercise;

import java.util.Collection;

public interface AgentModelContext {
    void addAcceptor(Acceptor acceptor);

    Collection<Acceptor> getAcceptors();

    void setAgent(Agent agent);

    Agent getAgent();
}
