package suite;

import junitdemo.Test1;
import junitdemo.Test2;
import junitdemo.Test3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//导入runwith ，以suite.class 的形式运行
@RunWith(Suite.class)
@Suite.SuiteClasses({
	Test1.class,
	Test2.class,
	Test3.class
	
	
})

public class DemoSuite {

}
