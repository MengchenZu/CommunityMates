# CommunityMates
Data Analysis on CommunityMate survey, including data propressing and chi-square test (fisher's test)

Functions:
1. readData:
    This function is used to data processing and transfer the .csv file into matrix according to survey questions.
    
2. readData_bin:
    This function is used to data processing and transfer the .csv file into matrix according to each binary choice (yes or no).

3. count_form:
    This function count the matrix data into 2 * 2 form to chi-square test.
    
4. test_decide:
    Based on a given form, decide to use which test (chi-square test or fisher test).
    Chi-square: the sample form has to be larger than 40 and each part of form has to be larger than 5.
    Fisher test: the form has to be 2 * 2 form. Fishter test can't handle R * S form.

5. calculate_chi_square:
    Calculate the chi-square test from a R * S form. 

6. fisher_test_2_2:
    Calculate the fisher test from a 2 * 2 form.
