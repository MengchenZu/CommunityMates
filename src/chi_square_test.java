public class chi_square_test {
	public static double test_decide(int[][] data_matrix) {
		int n = data_matrix.length, m = data_matrix[0].length;
		
		double[] sum1 = new double[n];
		double[] sum2 = new double[m];
		
		for(int i = 0;i < n; i++) {
			for(int j = 0;j < m; j++) {
				sum1[i] = sum1[i] + data_matrix[i][j];
			}
		}
		for(int i = 0;i < m; i++) {
			for(int j = 0;j < n; j++) {
				sum2[i] = sum2[i] + data_matrix[j][i];
			}
		}
		
		double total = 0;
		for(int i = 0;i < m; i++) {
			total += sum1[i];
		}
		
		double[][] expect_data = new double [n][m];
		
		for(int i = 0;i < n; i++) {
			for(int j = 0;j < m; j++) {
				expect_data[i][j] = sum1[i] * sum2[j] / total;
				//System.out.print(expect_data[i][j] + " ");
			}
			//System.out.println();
		}
		
		//decide using pearson chi-square test or fisher test
		boolean flag = false;
		for(int i = 0;i < n; i++) {
			for(int j = 0;j < m; j++) {
				if(expect_data[i][j] <= 5) {
					//System.out.println("too less data (less than 5) in one of parts\n"
					//		+ "using fisher's test");
					flag = true;
				}
			}
		}
		if(total < 41) {
			//System.out.println("too less sample data (less than 40)\n"
			//		+ "using fisher's test");
			flag = true;
		}
		
		if(!flag) {
			//System.out.println("using chi square test");
		}
		
		double test = 0.0;
		if(!flag) test = calculate_chi_square(data_matrix);
		else test = fisher_test_2_2.fisher_test(data_matrix);
		
		return test;
	}
	
	
	public static double calculate_chi_square(int[][] data_matrix) {
		int n = data_matrix.length, m = data_matrix[0].length;
		
		double[] sum1 = new double[n];
		double[] sum2 = new double[m];
		
		for(int i = 0;i < n; i++) {
			for(int j = 0;j < m; j++) {
				sum1[i] = sum1[i] + data_matrix[i][j];
			}
		}
		for(int i = 0;i < m; i++) {
			for(int j = 0;j < n; j++) {
				sum2[i] = sum2[i] + data_matrix[j][i];
			}
		}
		
		double total = 0;
		for(int i = 0;i < m; i++) {
			total += sum1[i];
		}
		
		double[][] expect_data = new double [n][m];
		
		for(int i = 0;i < n; i++) {
			for(int j = 0;j < m; j++) {
				expect_data[i][j] = sum1[i] * sum2[j] / total;
				//System.out.print(expect_data[i][j] + " ");
			}
			//System.out.println();
		}
		
		double chi_square = 0.0;
		for(int i = 0;i < n; i++) {
			for(int j = 0;j < m; j++) {
				chi_square += ((expect_data[i][j] - data_matrix[i][j]) *
						(expect_data[i][j] - data_matrix[i][j])) / expect_data[i][j];
				//System.out.print(((expect_data[i][j] - data_matrix[i][j]) *
				//		(expect_data[i][j] - data_matrix[i][j])) + "   ");
			}
			//System.out.println();
		}
		
		//System.out.println(chi_square);
		return chi_square;
	}
	
	public static void compare_correlated_or_not(double chi_square) {
		
	}
	
	public static void main(String[] args) {
		int[][] data_matrix = new int[2][2];
		data_matrix[0][0] = 250;
		data_matrix[0][1] = 200;
		data_matrix[1][0] = 50;
		data_matrix[1][1] = 1000;
		
		int[][] further_test = new int[3][3];
		further_test[0][0] = 100;
		further_test[0][1] = 200;
		further_test[0][2] = 300;
		further_test[1][0] = 200;
		further_test[1][1] = 400;
		further_test[1][2] = 500;
		further_test[2][0] = 300;
		further_test[2][1] = 500;
		further_test[2][2] = 600;
		
		int[][] CM = new int [5][2];
		CM[0][0] = 22;
		CM[1][0] = 25;
		CM[2][0] = 17;
		CM[3][0] = 5;
		CM[4][0] = 15;
		CM[0][1] = 16;
		CM[1][1] = 11;
		CM[2][1] = 5;
		CM[3][1] = 5;
		CM[4][1] = 5;
		
		int[][] facebook = new int [2][2];
		facebook[0][0] = 23;
		facebook[0][1] = 4;
		facebook[1][0] = 84;
		facebook[1][1] = 16;
		
		double chi_square = 0.0;
		chi_square = calculate_chi_square(facebook);
		System.out.println(test_decide(facebook));
		System.out.println(chi_square);
		
		//System.out.println(calculate_chi_square(CM));
	}
}