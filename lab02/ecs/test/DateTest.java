import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  @DisplayName("1: Test pass when 1700-6-20's nextDate is as expected")
	  void test01() {
	    Date d = new Date(1700,6,20);
	    assertEquals(new Date(1700,6,21), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("2: Test pass when 2005-4-15's nextDate is as expected")
	  void test02() {
	    Date d = new Date(2005,4,15);
	    assertEquals(new Date(2005,4,16), d.nextDate());
	    
	  }
  
  @Test
  @DisplayName("3: Test pass when 1901-7-20's nextDate is as expected")
	  void test03() {
	    Date d = new Date(1901,7,20);
	    assertEquals(new Date(1901,7,21), d.nextDate());  
      }
	
  @Test
  @DisplayName("4: Test pass when 3456-3-27's nextDate is as expected")
      void test04() {
	    Date d = new Date(3456,3,27);
	    assertEquals(new Date(3456,3,28), d.nextDate());  
      }
  
  @Test
  @DisplayName("5: Test pass when 1500-2-17's nextDate is as expected")
	  void test05() {
	    Date d = new Date(1500,2,17);
	    assertEquals(new Date(1500,2,18), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("6: Test pass when 1700-6-29's nextDate is as expected")
	  void test06() {
	    Date d = new Date(1700,6,29);
	    assertEquals(new Date(1700,6,30), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("7: Test pass when 1800-11-29's nextDate is as expected")
	  void test07() {
	    Date d = new Date(1800,11,29);
	    assertEquals(new Date(1800,11,30), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("8: Test pass when 3453-1-29's nextDate is as expected")
	  void test08() {
	    Date d = new Date(3453,1,29);
	    assertEquals(new Date(3453,1,30), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("9: Test pass when 444-2-29's nextDate is as expected")
	  void test09() {
	    Date d = new Date(444,2,29);
	    assertEquals(new Date(444,3,1), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("10: Test pass when 2005-4-30's nextDate is as expected")
	  void test10() {
	    Date d = new Date(2005,4,30);
	    assertEquals(new Date(2005,5,1), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("11: Test pass when 3453-1-30's nextDate is as expected")
	  void test11() {
	    Date d = new Date(3453,1,30);
	    assertEquals(new Date(3453,1,31), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("12: Test pass when 3456-3-30's nextDate is as expected")
	  void test12() {
	    Date d = new Date(3456,3,30);
	    assertEquals(new Date(3456,3,31), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("13: Test pass when 1901-7-31's nextDate is as expected")
	  void test13(){
	    Date d = new Date(1901,7,31);
	    assertEquals(new Date(1901,8,1), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("14: Test pass when 3453-1-31's nextDate is as expected")
	  void test14(){
	    Date d = new Date(3453,1,31);
	    assertEquals(new Date(3453,2,1), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("15: Test pass when 3456-12-31's nextDate is as expected")
	  void test15(){
	    Date d = new Date(3456,12,31);
	    assertEquals(new Date(3457,1,1), d.nextDate());
	    
	  }
	
	@Test
	@DisplayName("16: Test pass when 1500-2-31 has IllegalArgumentException")
	  void test16(){
		//Date d = new Date(1500,2,31);
	    Assertions.assertThrows(IllegalArgumentException.class, () -> new Date(1500,2,31));
	    
	  }
	
	@Test
	@DisplayName("17: Test pass when 1500-2-29 has IllegalArgumentException")
	  void test17(){
	    //Date d = new Date(1500,2,29);
		 Assertions.assertThrows(IllegalArgumentException.class, () -> new Date(1500,2,29));
	    
	  }
	
	@Test
	@DisplayName("18: Test pass when -1-10-20 has IllegalArgumentException")
	  void test18(){
	    //Date d = new Date(-1,10,20);
		 Assertions.assertThrows(IllegalArgumentException.class, () -> new Date(-1,10,20));
	    
	  }
  
}