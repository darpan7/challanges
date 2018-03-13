package Challenges;
/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 13, 2018 4:24:56 PM
* }
*/
/* Problem:
 * =======
Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

Input: p[] = {40, 20, 30, 10, 30}   
Output: Optimal parenthesization is  ((A(BC))D)
There are 4 matrices of dimensions 40x20, 
20x30, 30x10 and 10x30. Let the input 4 
matrices be A, B, C and D.  The minimum 
number of multiplications are obtained 
by putting parenthesis in following way
(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

Input:
The first line of the input contains an integer T, denoting the number of test cases. Then T test case follows. The first line of each test case contains an integer N, denoting the number of elements in the array.
Then next line contains N space separated integers denoting the values of the element in the array.

Output:
For each test case the print the minimum number of operations needed to multiply the chain.

Constraints:
1<=T<=100
2<=N<=27
1<=A[]<=500

Example:
Input:
2
5
1 2 3 4 5
3
3 3 3
Output:
(((AB)C)D)
(AB)

 */
public class Challenge1 {

}
