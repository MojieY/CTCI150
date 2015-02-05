package recursionDynamic;

import java.util.ArrayList;

public class RobotMove {
	
	private static class point{
		int x;
		int y;
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isfree(int x, int y){
		if(x>=0 && y>=0){
			return true;
		} else{
			return false;
		}
	}
	public static boolean getPath(int x, int y, ArrayList<point> path){
		point p = new point(x, y);
		path.add(p);
		if(x == 0 && y == 0){
			return true;
		}
		boolean success = false;
		if(!success && x>=1 && isfree(x-1, y)){
			success = getPath(x-1, y, path);
		}
		if(!success && y>=1 && isfree(x, y-1)){
			success = getPath(x, y-1, path);
		}
		if(!success){
			path.remove(p);
		}
		return success;
		
	}
	public static void main(String[] args) {
		int x = 5;
		int y = 5;
		ArrayList<point> path = new ArrayList<point>();
		getPath(x, y, path);
		for(int i = 0; i< path.size(); i++){
			System.out.println(path.get(i).x+" "+path.get(i).y);
		}
	}

}
