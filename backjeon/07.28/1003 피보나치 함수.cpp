#include <iostream>

using namespace std;


int fiboZero[42];
int fiboOne[42];
int test[42];
 
int main(){
	fiboZero[0] = 1;
	fiboZero[1] = 0;
	fiboZero[2] = 1;
	
	fiboOne[0] = 0;
	fiboOne[1] = 1;
	fiboOne[2] = 1;
	
	for(int i=3; i<41; i++)
	{
		fiboZero[i] = fiboZero[i-1] + fiboZero[i-2];
		fiboOne[i] = fiboOne[i-1] + fiboOne[i-2];
	}
	
	int num;
	cin >> num;
	for(int i=0; i<num; i++)
	{
		int ans;
		cin >> test[i];
	}
	
	for(int i=0; i<num; i++)
	{
		cout << fiboZero[test[i]] << " " << fiboOne[test[i]] << endl;
	}
	return 0;
		
}
