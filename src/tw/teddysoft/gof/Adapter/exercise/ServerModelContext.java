package tw.teddysoft.gof.Adapter.exercise;

import java.util.List;

public interface ServerModelContext {
    void addHost(Host aObj);

    Host getHost(String key);

    List<Host> getHosts();

    void addContact(Contact aObj);

    Contact getContact(String key);

    List<Contact> getContacts();
}
