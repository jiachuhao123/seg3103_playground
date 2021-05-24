import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class DateNextDateExceptionTest
{	

	
	private static Object[] values() {
		return new Object[][] {
			{1500,2,31},
			{1500,2,29},
			{-1,10,20}
		};
	}
	
	@ParameterizedTest(name = "{index} - Test pass when exception found with the test date agrs = {0} - {1} - {2}")
	@MethodSource("values")
	void DateNextDateExceptionTest(int year, int month, int day) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Date(year,month,day));
	}
	
}