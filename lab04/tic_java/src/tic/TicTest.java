package tic;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTest {
	
	Tic obj = new Tic();
	
	@Test
	public void test_Default_Sea() {
		/* test if default_Sea can create a 5x5 matrix
		 _ _ _ _ _
		 _ _ _ _ _
		 _ _ _ _ _
		 _ _ _ _ _
		 _ _ _ _ _
		 
		 */
		
		/*
		String[][] sea = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
		assertEquals(true,Arrays.deepEquals(sea,obj.Default_Sea()));
		
		String[][] sea = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
		assertEquals(false,Arrays.deepEquals(sea,obj.Default_Sea()));
		
		
		String[][] sea1 = {
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"}};
		assertEquals(false,Arrays.deepEquals(sea1,obj.Default_Sea()));
		 */
		
		
		String[][] sea1 = {
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"}};
		assertEquals(true,Arrays.deepEquals(sea1,obj.Default_Sea()));
		

	}
	
	@Test
	public void test_New_Sea() {
		/* test if default_Sea can create a Custom definition matrix, but need at least a 2x2 matrix.
		 _ _
		 _ _
		 
		 */

		/*
		String[][] sea0 = {{"_","_"}};
		assertEquals(true,Arrays.deepEquals(sea0,obj.New_Sea(1,2)));
		*/
		
		
		String[][] sea = {{"_","_"},{"_","_"}};
		assertEquals(true,Arrays.deepEquals(sea,obj.New_Sea(1,1)));
		
		String[][] sea1 = {{"_","_","_"},{"_","_","_"}};
		assertEquals(true,Arrays.deepEquals(sea1,obj.New_Sea(1,3)));
		
		String[][] sea2 = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
		assertEquals(true,Arrays.deepEquals(sea2,obj.New_Sea(3,3)));
		 
	}
	
	@Test
	public void test_Sea_Size() {
		/*
		 test the size of the sea
		 */
		
		/*
		String[][] sea0 =  obj.New_Sea(2,3);
		assertEquals(5,Sea_Size(sea0));
		*/
		
		String[][] sea = {{"_","_","_"},{"_","_","_"}};
		assertEquals(6,obj.Sea_Size(sea));
		
		String[][] sea1 =  obj.New_Sea(3,3);
		assertEquals(9,obj.Sea_Size(sea1));
		
		String[][] sea2 =  obj.New_Sea(5,4);
		assertEquals(20,obj.Sea_Size(sea2));
	}
	
	@Test
	public void test_Set_Block() {
		/* Test to set block
		 _ _ _ _ _
		 _ _ _ _ _
		 _ B B _ _
		 _ _ _ _ _
		 _ _ _ _ _
		           B
		 */
		
		String[][] sea =  obj.New_Sea(5,5);
		/*
		assertEquals("_",obj.Set_Block(sea0, 2, 1));
		*/

		assertEquals("B",obj.Set_Block(sea, 2, 1));
		/*
		assertEquals("B",obj.Set_Block(sea, 2, 1));
		*/

		
		assertEquals("already a block",obj.Set_Block(sea, 2, 1));
		assertEquals("B",obj.Set_Block(sea, 2, 2));
		
		/*
		assertEquals("B",obj.Set_Block(sea, 6, 6));
		*/
		assertEquals("invaild position",obj.Set_Block(sea, 6, 6));
		
	}
	
	@Test
	public void test_Set_BattleShips() {
		/* test to set player T and N
		 _ _ _ B _
		 _ _ _ _ _
		 _ B B _ _
		 T _ _ _ _
		 _ _ _ _ _
		 
		 _ _ _ B F
		 _ _ _ _ _
		 _ B B _ _
		 T _ _ _ _
		 _ _ _ _ _
		 */
		
		String[][] sea =  obj.New_Sea(5,5);
		obj.Set_Block(sea, 0, 3);
		obj.Set_Block(sea, 2, 1);
		obj.Set_Block(sea, 2, 2);

		/*
		assertEquals("F",obj.Set_BattleShips(sea, 3, 0,true));
		*/
		assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
		/*
		assertEquals("T",obj.Set_BattleShips(sea, 0, 4,false));
		*/
		assertEquals("F",obj.Set_BattleShips(sea, 0, 4,false));
		/*
		assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
		*/
		assertEquals("invaild position",obj.Set_BattleShips(sea, 3, 0,true));
		/*
		assertEquals("F",obj.Set_BattleShips(sea, 0, 3,true));
		*/
		assertEquals("invaild position",obj.Set_BattleShips(sea, 0, 3,true));
		
	}
	
	@Test
	public void test_Reset_BattleShips() {
		/* test to reset Battle ships so there only be 1 T and 1 N in a sea map.
		 _ _ _ F _
		 _ _ _ _ _
		 _ _ _ _ _
		 T _ _ _ _
		 _ _ _ _ _
		 
		 _ _ _ _ F
		 _ _ _ _ _
		 _ _ _ _ _
		 _ _ _ _ _
		 T _ _ _ _
		 
		 _ _ _ F _
		 _ _ _ _ _
		 _ _ _ _ _
		 T _ _ _ _
		 _ _ _ _ _
		 */
		
		String[][] sea =  obj.New_Sea(5,5);
		
		assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
		assertEquals("T",obj.Set_BattleShips(sea, 4, 0,true));
		/*
		assertEquals("invaild position",obj.Set_BattleShips(sea, 3, 0,true));
		*/
		assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
		
		assertEquals("F",obj.Set_BattleShips(sea, 0, 3,false));
		assertEquals("F",obj.Set_BattleShips(sea, 0, 4,false));
		/*
		assertEquals("invaild position",obj.Set_BattleShips(sea, 0, 3,false));
		*/
		assertEquals("F",obj.Set_BattleShips(sea, 0, 3,false));
	}
	
	
	
	@Test
	public void test_Fire() {
		/* test fire, if we pick a position, F -> f, _ -> X, B -> B, T -> t, X -> X
		 _ _ _ B F
		 _ _ _ _ _
		 _ B B _ _
		 T _ _ _ _
		 _ _ _ _ _
		*/
		String[][] sea = {
				{"_","_","_","B","F"},
				{"_","_","_","_","_"},
				{"_","B","B","_","_"},
				{"T","_","_","_","_"},
				{"_","_","_","_","_"}};
		/*
		assertEquals("B",obj.Fire(sea, 6, 6));
		*/
		assertEquals("invaild position",obj.Fire(sea, 6, 6));
		
		/*
		assertEquals("_",obj.Fire(sea, 4, 0));
		*/
		assertEquals("X",obj.Fire(sea, 4, 0));
		
		/*
		assertEquals("X",obj.Fire(sea, 0, 3));
		*/
		assertEquals("B",obj.Fire(sea, 0, 3));
		
		/*
		assertEquals("F",obj.Fire(sea, 0, 4));
		assertEquals("T",obj.Fire(sea, 3, 0));
		assertEquals("_",obj.Fire(sea, 4, 0));
		*/
		
		
		
		assertEquals("f",obj.Fire(sea, 0, 4));
		assertEquals("t",obj.Fire(sea, 3, 0));
		assertEquals("X",obj.Fire(sea, 4, 0));

		
	}
	
	@Test
	public void test_Winner() {
		/* test Winner, if there is f (fired),then player T win, if there is t, then player F win, if no f no t, game is not over
		 _ _ _ B F
		 _ _ _ _ _
		 _ B B _ _
		 t _ _ _ _
		 _ _ _ _ _
		*/
		String[][] sea = {
				{"_","_","_","B","F"},
				{"_","_","_","_","_"},
				{"_","B","B","_","_"},
				{"t","_","_","_","_"},
				{"_","_","_","_","_"}};
		
		String[][] sea1 = {
				{"_","_","_","B","f"},
				{"_","_","_","_","_"},
				{"_","B","B","_","_"},
				{"T","_","_","_","_"},
				{"_","_","_","_","_"}};
		
		String[][] sea2 = {
				{"_","_","_","B","T"},
				{"_","_","_","_","_"},
				{"_","B","B","_","_"},
				{"T","_","_","_","_"},
				{"_","_","_","_","_"}};
		
		
		/*
		assertEquals("T",obj.Winner(sea));
		*/
		assertEquals("F",obj.Winner(sea));
		
		/*
		assertEquals("F",obj.Winner(sea1));
		*/
		assertEquals("T",obj.Winner(sea1));
		
		/*
		assertEquals("T",obj.Winner(sea2));
		assertEquals("F",obj.Winner(sea2));
		*/
		assertEquals("No winner so far",obj.Winner(sea2));
		
	}
	
}
