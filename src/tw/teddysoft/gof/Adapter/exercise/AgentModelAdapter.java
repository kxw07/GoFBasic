package tw.teddysoft.gof.Adapter.exercise;

import java.util.Collection;

public class AgentModelAdapter {
    private final ConfigContext configContext;

    public AgentModelAdapter(ConfigContext configContext) {
        this.configContext = configContext;
    }


    public void addAcceptor(Acceptor acceptor) {
        this.configContext.add(acceptor);
    }

    public Collection<ConfigObject> getAcceptors() {
        return this.configContext.getAllObjects();
    }

    public void setAgent(Agent agent) {
        this.configContext.add(agent);
    }

    public ConfigObject getAgent(Agent agent) {
        ConfigObject configObject = this.configContext.get(agent.getKey());
        if (configObject == null) {
            throw new RuntimeException("No Agent found.");
        }

        return configObject;
    }
}
