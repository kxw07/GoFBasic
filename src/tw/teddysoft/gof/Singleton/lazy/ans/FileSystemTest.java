package tw.teddysoft.gof.Singleton.lazy.ans;
import static org.junit.Assert.*;
import org.junit.Test;

public class FileSystemTest {
	@Test
	public void default_instance_is_not_null() {
		AppConfig fs1 = AppConfig.getInstance();
		assertNotNull(fs1);
	}
	@Test
	public void call_getInstance_twice_get_the_smae_instance() {
		assertEquals(AppConfig.getInstance(), AppConfig.getInstance());
	}
	@Test (expected = IllegalAccessException.class) 
	public void cannot_call_the_default_constructor() 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		  String className = "tw.teddysoft.gof.Singleton.lazy.ans.AppConfig";
		   Class c = Class.forName(className);
		   AppConfig fs = (AppConfig) c.newInstance();
	}
}
