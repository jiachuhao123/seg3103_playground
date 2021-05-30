import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_tc01() {
    Date today = new Date(1700, 6, 20);
    Date expectedTomorrow = new Date(1700, 6, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc02() {
    Date today = new Date(2005, 4, 15);
    Date expectedTomorrow = new Date(2005, 4, 16);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc03() {
    Date today = new Date(1901, 7, 20);
    Date expectedTomorrow = new Date(1901, 7, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc04() {
    Date today = new Date(3456, 3, 27);
    Date expectedTomorrow = new Date(3456, 3, 28);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc05() {
    Date today = new Date(1500, 2, 17);
    Date expectedTomorrow = new Date(1500, 2, 18);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc06() {
    Date today = new Date(1700, 6, 29);
    Date expectedTomorrow = new Date(1700, 6, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc07() {
    Date today = new Date(1800, 11, 29);
    Date expectedTomorrow = new Date(1800, 11, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc08() {
    Date today = new Date(3453, 1, 29);
    Date expectedTomorrow = new Date(3453, 1, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc09() {
    Date today = new Date(444, 2, 29);
    Date expectedTomorrow = new Date(444, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc10() {
    Date today = new Date(2005, 4, 30);
    Date expectedTomorrow = new Date(2005, 5, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc11() {
    Date today = new Date(3453, 1, 30);
    Date expectedTomorrow = new Date(3453, 1, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc12() {
    Date today = new Date(3456, 3, 30);
    Date expectedTomorrow = new Date(3456, 3, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc13() {
    Date today = new Date(1901, 7, 31);
    Date expectedTomorrow = new Date(1901, 8, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc14() {
    Date today = new Date(3453, 1, 31);
    Date expectedTomorrow = new Date(3453, 2, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc15() {
    Date today = new Date(3456, 12, 31);
    Date expectedTomorrow = new Date(3457, 1, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_invalid_tc16() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 31)
    );
  }

  @Test
  void nextDate_invalid_tc17() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 29)
    );
  }

  @Test
  void nextDate_invalid_tc18() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(-1, 10, 20)
    );
  }

  @Test
  void nextDate_invalid_tc19() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1458, 15, 12)
    );
  }

  @Test
  void nextDate_invalid_tc20() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 6, -50)
    );
  }
  
  @Test
  void nextDate_invalid_tc21() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 6, 35)
    );
  }
  
  @Test
  void nextDate_invalid_tc22() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2021, 4, 31)
    );
  }
  
  @Test
  void nextDate_invalid_tc23() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2020, 2, 30)
    );
  }
  
  @Test
  void nextDate_invalid_tc24() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2020, 13, 30)
    );
  }
  
  @Test
  void nextDate_invalid_tc25() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2020, 0, 30)
    );
  }
  
  @Test
  void nextDate_tc26() {
    Date today = new Date(2000, 2, 28);
    Date expectedTomorrow = new Date(2000, 2, 29);
    assertEquals(expectedTomorrow, today.nextDate());
  }
  
  @Test
  void nextDate_tc27() {
    Date today = new Date(2000, 2, 29);
    Date expectedTomorrow = new Date(2000, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }
  
  @Test
  void nextDate_tc28() {
    Date today = new Date(2021, 9, 28);
    Date expectedTomorrow = new Date(2021, 9, 29);
    assertEquals(expectedTomorrow, today.nextDate());
  }
  
  @Test
  void nextDate_tc29() {
    Date today = new Date(2021, 11, 28);
    Date expectedTomorrow = new Date(2021, 11, 29);
    assertEquals(expectedTomorrow, today.nextDate());
  }
  
  @Test
  void nextDate_tc30() {
    Date today = new Date(2021, 11, 28);
    Date another = new Date(2021, 11, 28);
    assertEquals(true, today.equals(another));
  }
  
  @Test
  void nextDate_tc31() {
    Date today = new Date(2021, 11, 28);
    Date another = new Date(2021, 11, 29);
    assertEquals(false, today.equals(another));
  }
  
  @Test
  void nextDate_tc32() {
    Date today = new Date(2021, 11, 28);
    int another = 10;
    assertEquals(false, today.equals(another));
  }
  
  @Test
  void nextDate_tc33() {
    Date today = new Date(2021, 11, 28);
    String str = "2021/November/28";
    assertEquals(str, today.toString());
  }
  
  @Test
  void nextDate_tc34() {
    Date today = new Date(2001, 2, 28);
    Date expectedTomorrow = new Date(2001, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }
  
  @Test
  void nextDate_invalid_tc35() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2001, 2, 29)
    );
  }
  
  @Test
  void nextDate_tc36() {
    Date today = new Date(2000, 2, 29);
    Date expectedTomorrow = new Date(2000, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }
  
  @Test
  void nextDate_tc37() {
    Date today = new Date(2021, 11, 28);
    Date another = new Date(2021, 12, 28);
    assertEquals(false, today.equals(another));
  }
  
  @Test
  void nextDate_tc38() {
    Date today = new Date(2021, 11, 28);
    Date another = new Date(2022, 11, 28);
    assertEquals(false, today.equals(another));
  }
  
  @Test
  void nextDate_invalid_tc39() {
    assertThrows(
      IllegalArgumentException.class,
      () -> (new Date(2001, 2, 29)).nextDate()
    );
  }

}