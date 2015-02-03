package bit;

public class DemicalBinary {

	public static void main(String[] args) {
		double num = 0.5;
		StringBuilder string = new StringBuilder();
		
		string.append("0.");
		while(num>0){
			if(string.length()>32){
				System.out.println("error");
				return;
			}
			num = num*2;
			if(num>=1){
				string.append(1);
				num = num-1;
			}
			else{
				string.append(0);
			}
		}
		System.out.println(string.toString());

	}

}
