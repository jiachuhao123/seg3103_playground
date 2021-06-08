# SEG3103

| Outline | Value |
| --- | --- |
| Course | SEG 3103 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | n.bayati, n.bayati@uottawa.ca |
| Team | Chuhao jia 8794959<br>Keng Li 7847075 |

## Deliverables

* [https://github.com/jiachuhao123/seg3103_playground/tree/main/lab04](https://github.com/jiachuhao123/seg3103_playground/tree/main/lab04)
* Shared repo above with TA and Professors

### System

Windows 10

### Java

I am running Java openjdk 16

```bash
java --version
java 16.0.1 2021-04-20
Java(TM) SE Runtime Environment (build 16.0.1+9-24)
Java HotSpot(TM) 64-Bit Server VM (build 16.0.1+9-24, mixed mode, sharing)
```

### Project
Include 
Tic.java
TicTest.java
We have 8 public tests in total, please see the code for detailed information.

### About commit
We do the lab together and for some test, we test the function in different way so for one test, there might be more than one commit.

### Commit 1 - test_Default_Sea()
We want to see if the function of Default_Sea() if work. It will create a 5x5 2D array with all elements are "_".

We first create a 3x3 2D array with all element, it shoulde a fail test.

```bash
String[][] sea = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
assertEquals(true,Arrays.deepEquals(sea,obj.Default_Sea()));
```
Failure occurs Because our default sea should be 5x5.
Then we change true to false and see if it can return false when the 2D array is not 5x5.

```bash
String[][] sea = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
assertEquals(false,Arrays.deepEquals(sea,obj.Default_Sea()));
```
The test pass. 

### Commit 2 - test_Default_Sea()
We know how to check if Default_Sea doesn't work, now we want to check if it can work correctly.
We create a 5x5 2D array with _ as its input and this should satisfy our requirement. We expect it a false, so this should be fail.
```bash
String[][] sea1 = {
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"}};
		assertEquals(false,Arrays.deepEquals(sea1,obj.Default_Sea()));
```
Failure occurs as we thought..
Then we change false to ture.

```bash
String[][] sea1 = {
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"},
				{"_","_","_","_","_"}};
		assertEquals(true,Arrays.deepEquals(sea1,obj.Default_Sea()));
```
The test pass. 

### Commit 3 - test_New_Sea()
New_Sea will allow user to creat a Custom 2D array (map), but if the length or width less than 2, it will auto change to 2 since we requir
at least 2x2 map for our project.

We first create a 1x2 map , and expect it true when we run New_Sea(1,2). Since we know it will then create a 2x2 auto, this test should be failed.

In addition, considering the problems in the video, that the exact same map is not equal for some reason, we use deepEquals function by Arrays to
help the test. if the content of two 2D array are the same, deepEquals(a,b) shoulde return true.

```bash
String[][] sea0 = {{"_","_"}};
assertEquals(true,Arrays.deepEquals(sea0,obj.New_Sea(1,2)));
```
The test fail.
Now we try use New_Sea(1,1) and expect true to see if it can create a 2x2 map.

```bash
String[][] sea = {{"_","_"},{"_","_"}};
assertEquals(true,Arrays.deepEquals(sea,obj.New_Sea(1,1)));
```
The test pass.
We then try if the l and w more than 2.

```bash
String[][] sea1 = {{"_","_","_"},{"_","_","_"}};
assertEquals(true,Arrays.deepEquals(sea1,obj.New_Sea(1,3)));
		
String[][] sea2 = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
assertEquals(true,Arrays.deepEquals(sea2,obj.New_Sea(3,3)));
```
All tests pass.

### Commit 4 - test_Sea_Size()
Sea_Size will return the size of the map. We will need to input Sea as it parameters instead of just input two numbers.
We first create a 2x3 map, by the function of New_Sea, and expect it return 5, it should return 6, so the test should be failed.

```bash
String[][] sea0 =  obj.New_Sea(2,3);
assertEquals(5,Sea_Size(sea0));
```
Then we try 6 as it output, but this time we don't use New_Sea.
```bash
String[][] sea = {{"_","_","_"},{"_","_","_"}};
assertEquals(6,obj.Sea_Size(sea));
```
Test pass. Now we try more to aviod potential problems.

```bash
String[][] sea1 =  obj.New_Sea(3,3);
assertEquals(9,obj.Sea_Size(sea1));
		
String[][] sea2 =  obj.New_Sea(5,4);
assertEquals(20,obj.Sea_Size(sea2));
```

All tests pass.

### Commit 5 - test_Set_Block()
Set_Block can change Sea[i][j] to B if Sea[i][j] is _ . Otherwise don't do any change. And then return B if change successful, or already a block when we 
try to change B to B. If i and j bigger than the length of Sea[][], it will return invaild position.

We first create a 5x5 sea.
```bash
String[][] sea =  obj.New_Sea(5,5);
```

We try set sea(2,1) to a block and expect it return _ . So the test shoulde be failed.
```bash
assertEquals("_",obj.Set_Block(sea0, 2, 1));
```
Test fail as we wish, then we change it to B
```bash
assertEquals("B",obj.Set_Block(sea0, 2, 1));
```
Test pass. 

### Commit 6 - test_Set_Block()
We want to test if it we cannot set block in a position that already been blocked, and check if the input will out of the range of sea.

We continue the commit 4. Repeat set sea[2][1] to a block, and expect it return B, it should be failed.
```bash
assertEquals("B",obj.Set_Block(sea, 2, 1));
```
Test fail, then we change it to already a block.

```bash
assertEquals("already a block",obj.Set_Block(sea, 2, 1));
```
Test pass, Then we test for the range.

```bash
assertEquals("B",obj.Set_Block(sea, 6, 6));
assertEquals("invaild position",obj.Set_Block(sea, 6, 6));
```
the first fail and the second pass. 

### Commit 7 - test_Set_BattleShips()
Set_battleShips will set player (T and F) to the sea ( _ -> T,F) , T and F can only occur in one place in a single map. if we set T or F twice, then
the first place of T and F will be reset. We cannot put player in a block.


We first create a 5x5 sea, and put three blocks.
```bash
String[][] sea =  obj.New_Sea(5,5);
obj.Set_Block(sea, 0, 3);
obj.Set_Block(sea, 2, 1);
obj.Set_Block(sea, 2, 2);
```
The map should now be like the following type.
_ _ _ B _
_ _ _ _ _
_ B B _ _
_ _ _ _ _
_ _ _ _ _

We put player T to 3,0, and expect it return F, so the test will fail, we  do the same thing to player F.
```bash
assertEquals("F",obj.Set_BattleShips(sea, 3, 0,true));
assertEquals("T",obj.Set_BattleShips(sea, 0, 4,false));
```
Both fail. We change the first F to T, second T to F.

```bash
assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
assertEquals("F",obj.Set_BattleShips(sea, 0, 4,false));
```
Test pass.

### Commit 8 - test_Set_BattleShips()
We then want to test if player cannot set their ship on a block or a place that already be signed as player.
We try to set battleship on 3,0 and 0,3. then first one is player, second one is block.
We first want two fail tests. Both should return invaild position, so here we expect they return T and F.

```bash
assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
assertEquals("F",obj.Set_BattleShips(sea, 0, 3,true));
```
Tests fail. We then change it to the correct one to see the result.
```bash
assertEquals("invaild position",obj.Set_BattleShips(sea, 3, 0,true));
assertEquals("invaild position",obj.Set_BattleShips(sea, 0, 3,true));
```
Tests pass.

### Commit 9 - test_Reset_BattleShips()
This test is a addition part for test_Set_BattleShips, so we when put a player(T,F) twice, the first position will be reset,
but we only test if the second position is not the same place as the first one because we test this situation in test_Set_BattleShips.

We first create a 5x5 sea
```bash
String[][] sea =  obj.New_Sea(5,5);
```

We try player T first. So we plan to put it in 3,0. then put it in 4,0. and put it in 3,0. If the code working. 
It will not show invaild position when we run the third code.

```bash
assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
assertEquals("T",obj.Set_BattleShips(sea, 4, 0,true));
```
The first two step tests pass. We try the thrid one, but we want a fail test, so we expect it invaild position.
```bash
assertEquals("invaild position",obj.Set_BattleShips(sea, 3, 0,true));
```
Test fail. Change it to T.
```bash
assertEquals("T",obj.Set_BattleShips(sea, 3, 0,true));
```
Test pass. We do the same to player N.

```bash
assertEquals("F",obj.Set_BattleShips(sea, 0, 3,false));
assertEquals("F",obj.Set_BattleShips(sea, 0, 4,false));
assertEquals("invaild position",obj.Set_BattleShips(sea, 0, 3,false));
assertEquals("F",obj.Set_BattleShips(sea, 0, 3,false));
```
The results are the same, the first two pass, third one will fail if we expect invaild position and pass if we expect F.

### Commit 10 - test_Fire()
Fire will allow user to choose a position. The position will change as follow:
_ -> X
B -> B
F -> f
T -> t
X -> X
If the position out of range, then return invaild position

We first create a map.

```bash
String[][] sea = {
	{"_","_","_","B","F"},
	{"_","_","_","_","_"},
	{"_","B","B","_","_"},
	{"T","_","_","_","_"},
	{"_","_","_","_","_"}};
```
So the map should be

_ _ _ B F
_ _ _ _ _
_ B B _ _
T _ _ _ _
_ _ _ _ _

We first test the range. we select 6,6, and expect it, like "X". The test should be failed.
```bash
assertEquals("B",obj.Fire(sea, 6, 6));
```
Test fail. We change the expectation to invaild position.
```bash
assertEquals("invaild position",obj.Fire(sea, 6, 6));
```
Test pass, we do the same way for the rest of the tests.

For _ -> X
Fail: 
```bash
assertEquals("_",obj.Fire(sea, 4, 0));
```
Pass:
```bash
assertEquals("X",obj.Fire(sea, 4, 0));
```
For B -> B
Fail: 
```bash
assertEquals("X",obj.Fire(sea, 0, 3));
```
Pass:
```bash
assertEquals("B",obj.Fire(sea, 0, 3));
```
For F -> f, T -> t and X -> X
Fail: 
```bash
assertEquals("F",obj.Fire(sea, 0, 4));
assertEquals("T",obj.Fire(sea, 3, 0));
assertEquals("_",obj.Fire(sea, 4, 0));
```
Pass:
```bash
assertEquals("f",obj.Fire(sea, 0, 4));
assertEquals("t",obj.Fire(sea, 3, 0));
assertEquals("X",obj.Fire(sea, 4, 0));
```

### Commit 10 - test_Winner()
Winner will decide which player win the game. 
Player T will win if Player F has been destroyed, so in the map, There should be a T and a f. 
Player F will win if Player T has been destroyed, so in the map, There should be a f and a F. 
If both player are alive, so the there is no t and f but T and F, then game is not over.
t and f cannot occur at the same time since each player can only fire once per turn. So we don't need to test that condition.

So we need create 3 maps.
```bash
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
```
We test the first one. We see there is a F and t. So player F win. So we expect T as result, and test should be failed.
```bash
assertEquals("T",obj.Winner(sea));
```
Test fail, we change T to F.
```bash
assertEquals("F",obj.Winner(sea));
```
Test pass. We repeat it to the rest two.

In map 2, player T should win.
```bash
assertEquals("F",obj.Winner(sea1));
```
Fail, change F to T
```bash
assertEquals("T",obj.Winner(sea1));
```
Pass.

In map 3,  the game is not over.
```bash
assertEquals("T",obj.Winner(sea2));
assertEquals("F",obj.Winner(sea2));
```
Both fail
```bash
assertEquals("No winner so far",obj.Winner(sea2));
```
