import java.math.BigDecimal;

public class fisher_test_2_2 {
	public static double fisher_test(int[][] data_matrix) {
		double P0 = 0.0;
		int D0 = 0;
		int a = data_matrix[0][0];
		int b = data_matrix[0][1];
		int c = data_matrix[1][0];
		int d = data_matrix[1][1];
		int s = a + b;
		int t = c + d;
		int p = a + c;
		int q = b + d;
		int n = a + b + c + d;
		
		int change_deg = min(min(s,t),min(p,q)) + 1;
		int[] D = new int[change_deg];
		double[] P = new double[change_deg];
		
		D0 = cal_D(a,b,c,d);
		P0 = cal_P(a,b,c,d);
		//System.out.println("D* " + D0);
		//System.out.println("P* " + P0);
		
		int new_a = 0, new_b = 0, new_c = 0, new_d = 0;
		if(s == change_deg - 1 || p == change_deg - 1) {
			for(int i = 0;i < change_deg; i++) {
				new_a = i;
				new_b = s - i;
				new_c = p - i;
				new_d = q - new_b;
				
				D[i] = cal_D(new_a,new_b,new_c,new_d);
				P[i] = cal_P(new_a,new_b,new_c,new_d);
				
				//System.out.println(i + ". " + new_a + " " + new_b + " " + new_c + " " + new_d + " " +
				//		D[i] + " " + P[i]);
			}
		}
		else {
			for(int i = 0;i < change_deg; i++) {
				new_d = i;
				new_b = q - i;
				new_c = t - i;
				new_a = s - new_b;
				
				D[i] = cal_D(new_a,new_b,new_c,new_d);
				P[i] = cal_P(new_a,new_b,new_c,new_d);
				
				//System.out.println((i + 1) + ". " + new_a + " " + new_b + " " + new_c + " " + new_d + " " +
				//		D[i] + " " + P[i]);
			}
		}
		
		double fisher = 0.0;
		
		for(int i = 0;i < change_deg; i++) {
			if(Math.abs(D0) <= Math.abs(D[i]) && P[i] <= P0) {
				fisher += P[i];
			}
		}
		
		return fisher;
	}
	
	public static int cal_D(int a, int b, int c, int d) {
		return a * d - b * c;
	}
	
	public static double cal_P(int a, int b, int c, int d) {
		int s = a + b;
		int t = c + d;
		int p = a + c;
		int q = b + d;
		int n = a + b + c + d;
		
		double P = 0.0;
		P = fact(s) / fact(a) / fact(b) * fact(t) / fact(c) / fact(d) *fact(p) / fact(n) * fact(q);
		
		return P;
	}
	
	public static int min(int a, int b) {
		if(a > b) return b;
		else return a;
	}
	
	public static double fact(int n){  
        double bd1 = 1.0;//1
        if(n < 0) {
        	System.out.println("ERROR!!!");
        	return 0.0;
        }
        if(n == 0 || n == 1){  
            return bd1;
        }  
        else  
            return n*fact(n-1);//n*f(n-1)  
    }
	
	public static BigDecimal factorial(int n){   
        BigDecimal result = new BigDecimal(1);  
        BigDecimal a;  
        for(int i = 2; i <= n; i++){  
            a = new BigDecimal(i);//将i转换为BigDecimal类型  
            result = result.multiply(a);//不用result*a，因为BigDecimal类型没有定义*操作</span><span>  
        }  
        return result;  
    }
	
	public static void main(String[] args) {
		int[][] data_matrix = new int[2][2];
		/*data_matrix[0][0] = 4;
		data_matrix[0][1] = 18;
		data_matrix[1][0] = 5;
		data_matrix[1][1] = 6;*/
		
		data_matrix[0][0] = 23;
		data_matrix[0][1] = 4;
		data_matrix[1][0] = 84;
		data_matrix[1][1] = 16;
		
		double fisher = 0.0;
		fisher = fisher_test(data_matrix);
		System.out.println(fisher);
		
		//System.out.println(factorial(50).toBigInteger());
	}
}