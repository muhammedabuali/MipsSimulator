package eg.edu.guc.utils;

public class ALUControl {
	//perform ALU operation based on the aluop , if aluop == 7 , the output represents the zero wire
	//else 
	public static int perform(int data1,int data2,int aluop){
		switch(aluop){
		case 0:
			return data1&data2;	
		case 1:
			return data1|data2;
		case 2:
			return data1+data2;
		case 6:
			return data1-data2;
		case 7:
			return (data1<data2?1:0);
		case 12:
			return (~(data1|data2));
		}
		throw new RuntimeException("invalid aluop");
	}
	public static int generateAluop(int aluop,int function){
		switch(aluop){
		case 0:
			return 2;
		case 1:
			return 6;
		case 2:
			switch(function){
			case 32:
				return 2;
			case 34:
				return 6;
			case 36:
				return 0;
			case 37:
				return 1;
			case 42:
				return 7;
			case 39:
				return 12;
			}
		}
		throw new RuntimeException("invalid aluop or function");
	}
}
