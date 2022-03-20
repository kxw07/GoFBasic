package tw.teddysoft.gof.Singleton.lazy.exercise;
import static org.junit.Assert.*;
import org.junit.Test;
import tw.teddysoft.gof.Singleton.standard.ans.AppConfig;

public class AppConfigTest {
	@Test
	public void default_instance_is_not_null() {
		assertNotNull(AppConfig.getInstance());
	}

	@Test
	public void call_getInstance_twice_gets_the_same_instance() {
		assertEquals(AppConfig.getInstance(), AppConfig.getInstance());
	}

	@Test (expected = IllegalAccessException.class) 
	public void cannot_call_the_default_constructor() throws Exception {
		   String className = "tw.teddysoft.gof.Singleton.lazy.exercise.AppConfig";
		   Class<?> c =  Class.forName(className);
		   assertNotNull((AppConfig) c.newInstance());
	}
}

