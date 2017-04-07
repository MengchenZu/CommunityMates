import java.io.File;
import java.util.List;
import com.parami.utils.CSVUtils;

public class community_mates_classification {
	static int title_length = 2;
	static int N = 200;
	static int M = 60;
	
	public static int readData(String filename, int[][] csvDataMatrix) {
    	int count_line = 0;
    	
		List<String> dataList=CSVUtils.importCsv(new File(filename));
        if(dataList!=null && !dataList.isEmpty()){

            for(String data : dataList){
            	if(count_line >= title_length) {
                	int count_row = 0;
	                String[] parts = data.split(",");

	                //data pre-processing
	                //clear the data not from ANU college
	                if(parts[11].isEmpty()) continue;
	                if(parts[11].charAt(0) - 48 == 0) continue;

	                //clear the test data with status 1
	                if(!parts[6].isEmpty()) if((parts[6].charAt(0) - 48) == 1) continue;
	                
	                //clear the unfinished data
	                if(!parts[9].isEmpty()) if((parts[9].charAt(0) - 48) == 0) continue;
	                
	                if(parts[11].charAt(0) - 48 > 7) continue;
	                
	                // Q5. zxx, Test
	                // Email. dsv, xxx@gmail, wilson
	                
	                
	                //read data and store the data
	                // 1. Which college are you from?
	                csvDataMatrix[count_line-title_length][count_row++] = parts[11].charAt(0) - 48;
	                
	                // 2. Have you been volunteering in any non-for-profit organisations while at University?
	                csvDataMatrix[count_line-title_length][count_row++] = (parts[15].charAt(0) - 49) * (-1) + 1;

	                // 3. When time did the volunteering take place?-Morning/Afternoon/Evening?
	                csvDataMatrix[count_line-title_length][count_row++] = ((parts[16].isEmpty() ? 0:1) * 2 + 
	                		(parts[17].isEmpty() ? 0:1)) * 2 + (parts[18].isEmpty() ? 0:1);
	                
	                // 4. What day did the volunteering take place?-Weekdays/Weekend?
	                csvDataMatrix[count_line-title_length][count_row++] = (parts[19].isEmpty() ? 0:1) * 2 +
	                		(parts[20].isEmpty() ? 0:1);
	                
	                // 5. Why did you participate in volunteering-Making a difference to society?
	                csvDataMatrix[count_line-title_length][count_row++] = (((((parts[21].isEmpty() ? 0:1) * 2 +
	                		(parts[22].isEmpty() ? 0:1)) * 2 + (parts[23].isEmpty() ? 0:1)) * 2 +
	                		(parts[24].isEmpty() ? 0:1)) * 2 + (parts[25].isEmpty() ? 0:1)) * 2 +
	                		(parts[26].isEmpty() ? 0:1);
	                
	                // 6. What cause were you volunteering for?
	                csvDataMatrix[count_line-title_length][count_row] = parts[27].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[28].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[29].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[30].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[31].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[32].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[33].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[34].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[35].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[36].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[37].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[38].isEmpty() ? 0:1);
	                count_row++;
	                
	                // 7. Where did you hear about this organisation?-Advertisements and leaflets?
	                csvDataMatrix[count_line-title_length][count_row] = parts[39].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[40].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[41].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[42].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[43].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[44].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[45].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[46].isEmpty() ? 0:1);
	                count_row++;

	                // 8. Did the volunteering organisation that you joined relate to your academic background?
	                if(parts[47].isEmpty()) csvDataMatrix[count_line-title_length][count_row] = 0;
	                else csvDataMatrix[count_line-title_length][count_row] = (parts[47].charAt(0) - 49) * (-1) + 1;
	                count_row++;
	                
	                // 9. What are the reasons for not volunteering?
	                csvDataMatrix[count_line-title_length][count_row] = parts[48].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[49].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[50].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[51].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[52].isEmpty() ? 0:1);
	                csvDataMatrix[count_line-title_length][count_row] =
	                		csvDataMatrix[count_line-title_length][count_row] * 2 + (parts[53].isEmpty() ? 0:1);
	                count_row++;
	                
	                // 10. Do you want to participate in volunteering in the future?
	                if(parts[54].isEmpty()) csvDataMatrix[count_line-title_length][count_row++] = 0;
	                else csvDataMatrix[count_line-title_length][count_row++] = (parts[54].charAt(0) - 49) * (-1) + 1;

	                // 11. Would you be interested in participating in volunteering that is related to your academic area?
	                if(parts[55].isEmpty()) csvDataMatrix[count_line-title_length][count_row++] = 0;
	                else csvDataMatrix[count_line-title_length][count_row++] = (parts[55].charAt(0) - 49) * (-1) + 1;

	                // 12. CommunityMates or not?
	                if(parts[56].isEmpty()) csvDataMatrix[count_line-title_length][count_row] = 0;
	                else csvDataMatrix[count_line-title_length][count_row] = (parts[56].charAt(0) - 49) * (-1) + 1;
	                count_row++;
            	}
            	count_line++;
            }
        }
        
        return count_line;
	}
	
	public static int readData_bin(String filename, int[][] csvDataMatrix) {
    	int count_line = 0;
    	
		List<String> dataList=CSVUtils.importCsv(new File(filename));
        if(dataList!=null && !dataList.isEmpty()){

            for(String data : dataList){
            	if(count_line >= title_length) {
                	int count_row = 0;
	                String[] parts = data.split(",");

	                //data pre-processing
	                //clear the data not from ANU college
	                if(parts[11].isEmpty()) continue;
	                if(parts[11].charAt(0) - 48 == 0) continue;

	                //clear the test data with status 1
	                if(!parts[6].isEmpty()) if((parts[6].charAt(0) - 48) == 1) continue;
	                
	                //clear the unfinished data
	                if(!parts[9].isEmpty()) if((parts[9].charAt(0) - 48) == 0) continue;
	                
	                if(parts[11].charAt(0) - 48 > 7) continue;
	                
	                // Q5. zxx, Test
	                // Email. dsv, xxx@gmail, wilson
	                
	                
	                //read data and store the data
	                // 1. Which college are you from? 0
	                csvDataMatrix[count_line-title_length][count_row++] = parts[11].charAt(0) - 48;
	                
	                // 2. Have you been volunteering in any non-for-profit organisations while at University? 1
	                csvDataMatrix[count_line-title_length][count_row++] = (parts[15].charAt(0) - 49) * (-1) + 1;

	                // 3. When time did the volunteering take place?-Morning/Afternoon/Evening? 2-4
	                csvDataMatrix[count_line-title_length][count_row++] = parts[16].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[17].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[18].isEmpty() ? 0:1;
	                
	                // 4. What day did the volunteering take place?-Weekdays/Weekend? 5-6
	                csvDataMatrix[count_line-title_length][count_row++] = parts[19].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[20].isEmpty() ? 0:1;
	                
	                // 5. Why did you participate in volunteering-Making a difference to society? 7-12
	                csvDataMatrix[count_line-title_length][count_row++] = parts[21].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[22].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[23].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[24].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[25].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[26].isEmpty() ? 0:1;
	                
	                // 6. What cause were you volunteering for? 13-24
	                csvDataMatrix[count_line-title_length][count_row++] = parts[27].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[28].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[29].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[30].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[31].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[32].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[33].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[34].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[35].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[36].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[37].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[38].isEmpty() ? 0:1;
	                
	                // 7. Where did you hear about this organisation?-Advertisements and leaflets? 25-32
	                csvDataMatrix[count_line-title_length][count_row++] = parts[39].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[40].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[41].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[42].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[43].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[44].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[45].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[46].isEmpty() ? 0:1;

	                // 8. Did the volunteering organisation that you joined relate to your academic background? 33
	                if(parts[47].isEmpty()) csvDataMatrix[count_line-title_length][count_row] = 0;
	                else csvDataMatrix[count_line-title_length][count_row] = (parts[47].charAt(0) - 49) * (-1) + 1;
	                count_row++;
	                
	                // 9. What are the reasons for not volunteering? 34-39
	                csvDataMatrix[count_line-title_length][count_row++] = parts[48].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[49].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[50].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[51].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[52].isEmpty() ? 0:1;
	                csvDataMatrix[count_line-title_length][count_row++] = parts[53].isEmpty() ? 0:1;
	                
	                // 10. Do you want to participate in volunteering in the future? 40
	                if(parts[54].isEmpty()) csvDataMatrix[count_line-title_length][count_row++] = 0;
	                else csvDataMatrix[count_line-title_length][count_row++] = (parts[54].charAt(0) - 49) * (-1) + 1;

	                // 11. Would you be interested in participating in volunteering that is related to your academic area? 41
	                if(parts[55].isEmpty()) csvDataMatrix[count_line-title_length][count_row++] = 0;
	                else csvDataMatrix[count_line-title_length][count_row++] = (parts[55].charAt(0) - 49) * (-1) + 1;

	                // 12. CommunityMates or not? 42
	                if(parts[56].isEmpty()) csvDataMatrix[count_line-title_length][count_row] = 0;
	                else csvDataMatrix[count_line-title_length][count_row] = (parts[56].charAt(0) - 49) * (-1) + 1;
	                count_row++;
            	}
            	count_line++;
            }
        }
        
        return count_line;
	}
	
	public static int[][] count_form(int[][] csvDataMatrix, int m, int n, int count_line) {
		int [][] data_matrix = new int[2][2];
		
		for(int i = 0;i < count_line - title_length; i++) {
			if(csvDataMatrix[i][1] == 0) continue;
			if(csvDataMatrix[i][m] == 0 && csvDataMatrix[i][n] == 0) data_matrix[0][0]++;
			if(csvDataMatrix[i][m] == 0 && csvDataMatrix[i][n] == 1) data_matrix[0][1]++;
			if(csvDataMatrix[i][m] == 1 && csvDataMatrix[i][n] == 0) data_matrix[1][0]++;
			if(csvDataMatrix[i][m] == 1 && csvDataMatrix[i][n] == 1) data_matrix[1][1]++;
		}
		
		/*for(int i = 0;i < 2; i++) {
			for(int j = 0;j < 2; j++) {
				System.out.print(data_matrix[i][j] + " ");
			} System.out.println();
		}*/
		
		return data_matrix;
	}

	public static void main(String args[]) {
		String filename = null;
		//filename = "data/CM ANU Survey_March 8, 2017_01.13.csv";
		filename = "data/CM_ANU_Survey.csv";
		
		int[][] csvDataMatrix = new int[N][M];
		String[] Question = new String[M];
		
		int jishu = 0;
		List<String> dataList=CSVUtils.importCsv(new File(filename));
        if(dataList!=null && !dataList.isEmpty()){

            for(String data : dataList){
            	if(jishu == 1) {
            		int jishu2 = 0;
            		int jishu3 = 15;
	                String[] parts = data.split(",");
	                
	                Question[jishu2++] = parts[11];
	                for(int p = 0;p < 42; p++) {
	                	Question[jishu2++] = parts[jishu3++];
	                }
            	}
                jishu++;
            }
        }
        
        /*for(int p = 0;p < 43; p++) {
        	System.out.println(Question[p]);
        }*/
		
		//output test
		/*System.out.println("Which college are you from?");
		System.out.println("Have you been volunteering in any non-for-profit organisations while at University?");
		System.out.println("When time did the volunteering take place?-Morning/Afternoon/Evening?");
		System.out.println("What day did the volunteering take place?-Weekdays/Weekend?");
		System.out.println("Why did you participate in volunteering-Making a difference to society?");
		System.out.println("What cause were you volunteering for?");
		System.out.println("Where did you hear about this organisation?-Advertisements and leaflets?");
		System.out.println("Did the volunteering organisation that you joined relate to your academic background?");
		System.out.println("What are the reasons for not volunteering?");
		System.out.println("Do you want to participate in volunteering in the future?");
		System.out.println("Would you be interested in participating in volunteering that is related to your academic area?");
		System.out.println("CommunityMates or not?");
		System.out.println();*/
		
		/*int count_line = readData(filename, csvDataMatrix);
		for(int i = 0;i < count_line - title_length; i++) {
			for(int j = 0;j < 12; j++) {
				if(j == 4) System.out.printf("%6s", Integer.toString(csvDataMatrix[i][j], 2));
				else if(j == 5) System.out.printf("%12s", Integer.toString(csvDataMatrix[i][j], 2));
				else if(j == 6) System.out.printf("%8s", Integer.toString(csvDataMatrix[i][j], 2));
				else if(j == 8) System.out.printf("%6s", Integer.toString(csvDataMatrix[i][j], 2));
				else System.out.printf("%3s", Integer.toString(csvDataMatrix[i][j], 2));
				System.out.print(", ");
			}
			System.out.println();
		}*/
		
		int count_line = readData_bin(filename, csvDataMatrix);
		/*for(int i = 0;i < count_line - title_length; i++) {
			for(int j = 0;j < 43; j++) {
				System.out.printf("%1s", csvDataMatrix[i][j]);
				System.out.print(", ");
			}
			System.out.println();
		}*/
		
		
		// chi square test
		/*System.out.println("The first two lines are the two correlated variable:");
		System.out.println("The 2 * 2 matrix is the 2 * 2 chi square table");
		System.out.println("The last number is the chi square result:\nIf the result is larger than 3.84, the two variables are related with each other\n\n\n");
		
		
		for(int i = 1;i < 43; i++) {
			for(int j = i + 1;j < 43; j++) {
				if(i >= 2 && i <= 4 && j >= 2 && j <= 4) continue;
				if(i >= 5 && i <= 6 && j >= 5 && j <= 6) continue;
				if(i >= 7 && i <= 12 && j >= 7 && j <= 12) continue;
				if(i >= 13 && i <= 24 && j >= 13 && j <= 24) continue;
				if(i >= 25 && i <= 32 && j >= 25 && j <= 32) continue;
				if(i >= 34 && i <= 39 && j >= 34 && j <= 39) continue;
				
				int[][] data_matrix = new int [2][2];
				double chi;
				data_matrix = count_form(csvDataMatrix,i,j,count_line);
				chi = chi_square_test.test_decide(data_matrix);
				
				// 0.05 ~ 3.84
				// 0.01 ~ 6.64
				if(chi > 3.84) {
					System.out.println("varible1: " + Question[i]);
					System.out.println("varible2: " + Question[j]);
					//System.out.println("i = " + i);
					//System.out.println("j = " + j);
					System.out.println("2 * 2 chi-square table:");
					for(int p = 0;p < 2; p++) {
						for(int q = 0;q < 2; q++) {
							System.out.print(data_matrix[p][q] + " ");
						} System.out.println();
					}
					System.out.println("Chi-square result: " + chi);
					
					double related1 = 0.0, related2 = 0.0;
					double one = data_matrix[1][1];
					double two = data_matrix[1][0];
					double three = data_matrix[0][1];
					double four = data_matrix[0][0];
					related1 = one/two;
					related2 = three/four;
					System.out.println(related1 + " " + related2);
					if(related1 > related2) System.out.println("Positive");
					else System.out.println("Negative");
					
					System.out.println();
				}
			}
		}*/
		
		/*int[][] college = new int [7][2];
		for(int i = 0;i < count_line - title_length; i++) {
			//System.out.println(csvDataMatrix[i][0] + " " + csvDataMatrix[i][41]);
			if(csvDataMatrix[i][41] == 0) college[--csvDataMatrix[i][0]][0]++;
			if(csvDataMatrix[i][41] == 1) college[--csvDataMatrix[i][0]][1]++;
		}
		for(int i = 1;i >= 0; i--) {
			for(int j = 0;j < 7; j++) {
				//System.out.print(college[j][i] + " ");
				System.out.printf("%3s", college[j][i]);
			} System.out.println();
		}*/
		
		/*int[][] college_kind = new int [8][12];
		for(int i = 0;i < count_line - title_length; i++) {
			for(int j = 13;j <= 24; j++) {
				if(csvDataMatrix[i][j] == 1) {
					college_kind[csvDataMatrix[i][0]][j-13]++;
					//System.out.println(csvDataMatrix[i][0]);
				}
			}
		}
		for(int i = 1;i < 8; i++) {
			for(int j = 0;j < 12; j++) {
				System.out.print(college_kind[i][j] + " ");
			} System.out.println();
		}*/
		
		int[][] college_why_volunteering = new int [8][6];
		for(int i = 0;i < count_line - title_length; i++) {
			for(int j = 7;j <= 12; j++) {
				if(csvDataMatrix[i][j] == 1) {
					college_why_volunteering[csvDataMatrix[i][0]][j-7]++;
					//System.out.println(csvDataMatrix[i][0]);
				}
			}
		}
		for(int i = 1;i < 8; i++) {
			for(int j = 0;j < 6; j++) {
				System.out.print(college_why_volunteering[i][j] + " ");
			} System.out.println();
		}
		
		System.out.println("\n\n\n");
		
		int[][] college_not_volunteering = new int [8][6];
		for(int i = 0;i < count_line - title_length; i++) {
			for(int j = 34;j <= 39; j++) {
				if(csvDataMatrix[i][j] == 1) {
					college_not_volunteering[csvDataMatrix[i][0]][j-34]++;
					//System.out.println(csvDataMatrix[i][0]);
				}
			}
		}
		for(int i = 1;i < 8; i++) {
			for(int j = 0;j < 6; j++) {
				System.out.print(college_not_volunteering[i][j] + " ");
			} System.out.println();
		}
	}
}