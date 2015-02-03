package array;

public class JoinWord {
	
	public static String joinWords(String[] words){
		String sentence = "";
		for(String w: words){
			sentence = sentence + w;
		}
		return sentence;
	}
	
	public static String joinWords2(String words[]){
		StringBuffer sentence = new StringBuffer();
		for(String w: words){
			sentence.append(w);
		}
		return sentence.toString();
	}

	public static void main(String[] args) {
		int n =10000000;
		String[] words = {"ab","cd","ef"};
		long start = System.currentTimeMillis();
		
		for(int i = 0;i<n; i++){
		String newwords = joinWords(words);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		for(int i = 0;i<n; i++){
		String newwords2 = joinWords2(words);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
