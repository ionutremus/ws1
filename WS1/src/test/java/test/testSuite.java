package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.junit.features.search.CSVDataDrivenSearchOnImdbTest;
import test.junit.features.search.DataDrivenSearchOnImdbTest;



@RunWith(Suite.class)
@SuiteClasses({ 
	CSVDataDrivenSearchOnImdbTest.class,
	DataDrivenSearchOnImdbTest.class
        })
public class testSuite {

}
