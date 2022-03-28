package tw.teddysoft.gof.Adapter.exercise;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AgentModelAdapter implements AgentModelContext {
    private final ConfigContext configContext;

    public AgentModelAdapter(ConfigContext configContext) {
        this.configContext = configContext;
    }

    @Override
    public void addAcceptor(Acceptor acceptor) {
        this.configContext.add(acceptor);
    }

    @Override
    public Collection<Acceptor> getAcceptors() {
        final List<Acceptor> list = new ArrayList();

        final List<ConfigObject> allObjects = this.configContext.getAllObjects();

        for (ConfigObject configObject : allObjects) {
            if (configObject instanceof Acceptor) {
                list.add((Acceptor)configObject);
            }
        }

        return list;
    }

    @Override
    public void setAgent(Agent agent) {
        this.configContext.add(agent);
    }

    @Override
    public Agent getAgent() {
        final List<ConfigObject> allObjects = this.configContext.getAllObjects();
        for (ConfigObject configObject : allObjects) {
            if (configObject instanceof Agent) {
                return (Agent) configObject;
            }
        }

        throw new RuntimeException("No Agent found.");
    }
}
