package tic;

public class Tic {
		
	static String [][] def_Sea = new String[5][5];
	static String [][] Sea;
	
	public static String[][] Default_Sea(){
		
		for (int i = 0; i < 5; i++) 
		{
			for(int j = 0; j < 5; j++)
			{
				Tic.def_Sea[i][j]= "_";
			}
		}
		return Tic.def_Sea;
	}
	
	public static String[][] New_Sea(int length , int width){
		
		if (length < 2) {
			
			length = 2;
		}
		if (width < 2) {
			
			width = 2;
		}
		
		Tic.Sea = new String[length][width];
		
		for (int i = 0; i < length; i++) 
		{
			for(int j = 0; j < width; j++)
			{
				Tic.Sea[i][j]= "_";
			}
		}
		
		return Tic.Sea;
		
	}

	
	public static int Sea_Size(String sea [][]){

		return (sea.length)*(sea[0].length);
	}
	
	public static String Set_Block(String sea [][],int length,int width){
		
		Tic.Sea = sea;
		
		if (length > Tic.Sea.length) {
			
			return "invaild position";
		}
		else if (width > Tic.Sea[0].length) {
			
			return "invaild position";
		}
		else {
			
			if(Tic.Sea[length][width]=="B") {
				return "already a block";
			}
			else {
				Tic.Sea[length][width]="B";
			return Tic.Sea[length][width];
			}
		}
		
	}
	
	
	
	public static String Set_BattleShips(String sea [][],int length,int width,boolean player){
			
		Tic.Sea = sea;
		if (length > Tic.Sea.length) {
			
			return "invaild position";
		}
		else if (width > Tic.Sea[0].length) {
			
			return "invaild position";
		}
		else {
			
			if(Tic.Sea[length][width]=="B" || Tic.Sea[length][width]=="T" || Tic.Sea[length][width]=="F") {
				return "invaild position";
			}
			else {
				if(player) {
					
					Reset_BattleShips(Tic.Sea,true);
					Tic.Sea[length][width]="T";
					return Tic.Sea[length][width];
				}
				else {
					
					Reset_BattleShips(Tic.Sea,false);
					Tic.Sea[length][width]="F";
					return Tic.Sea[length][width];
				} 
				
			}
		}
		
	}
	
	public static String Reset_BattleShips(String sea [][], boolean player){
		
		Tic.Sea = sea;
		
		boolean BB = false;
		if (player) {
			BB = true;
		}
		for(int i=0;i<Tic.Sea.length;i++) {
			for(int j=0;j<Tic.Sea[0].length;j++) {
				if(Tic.Sea[i][j]=="T" && BB) {
					Tic.Sea[i][j] = "_";
				}
				else if(Tic.Sea[i][j]=="F" && !BB) {
					Tic.Sea[i][j] = "_";
				}
			}
		}
		
		return "Reset End";
	}
	
	public static String Fire(String sea [][], int length,int width){
		
		Tic.Sea = sea;
		if (length > Tic.Sea.length) {
			
			return "invaild position";
		}
		else if (width > Tic.Sea[0].length) {
			
			return "invaild position";
		}
		
		else {
			if (Tic.Sea[length][width] == "_") {
				Tic.Sea[length][width] = "X";
				return Tic.Sea[length][width];
			}
			else if(Tic.Sea[length][width] == "T") {
				Tic.Sea[length][width] = "t";
				return Tic.Sea[length][width];
			}
			else if(Tic.Sea[length][width] == "F") {
				Tic.Sea[length][width] = "f";
				return Tic.Sea[length][width];
			}
			else if(Tic.Sea[length][width] == "B") {
				Tic.Sea[length][width] = "B";
				return Tic.Sea[length][width];
			}
			else if(Tic.Sea[length][width] == "X") {
				Tic.Sea[length][width] = "X";
				return Tic.Sea[length][width];
			}
		}
		return "";

	}
	public static String Winner(String sea [][]){
		
		Tic.Sea = sea;
		
		for(int i=0;i<Tic.Sea.length;i++) {
			for(int j=0;j<Tic.Sea[0].length;j++) {
				if(Tic.Sea[i][j]=="t") {
					return "F";
				}
				else if(Tic.Sea[i][j]=="f") {
					return "T";
				}
			}
		}
		return "No winner so far";
		
	}
	
}
