package tddProject;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import tddProject.fileIndex;


@DisplayName("This is a Test Class")
class fileIndexTest {

	@Test
	@DisplayName("TEST0: dummy test")
	void dummytest() {}
	
	
	@Test
	@DisplayName("TEST1:  Sum elements of array")
	public void sumarraytest() {
		
		//indextool junit = new indextool();
		
		Integer[] arr = {100,50,100};
		double result = fileIndex.sum_array(arr);
		assertEquals(250,result,0.001);
		
	}
	
	@Test
	@DisplayName("TEST2: calculation of score(string1, string2)")
	public void scoreTest() {
		
		
		String s1 = "factu";
		String s2 = "facturations_mars";
		double result = fileIndex.score(s1, s2);
		assertEquals(344.44444444,result, 0.001);
	}

	@Test
	@DisplayName("TEST3: Test if directory is empty ")
	public void dirisemptyTest() {
		//sample
		File dir = new File("/home/hdpu00/adevinta_test");
		Boolean result = fileIndex.directory_is_empty(dir);
		//expected;
		Boolean exp = true;
		//test
		assertEquals(exp,result);
	}
	
}
