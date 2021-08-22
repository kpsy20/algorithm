#include <iostream>
#include <cstdio>

using namespace std;

int main(){
	char s[100001];
	
	scanf("%s", s);
	
	int sum = 0;
	int count[128];
	
	for(int i=0; s[i]; i++)
	{
		sum += s[i] - '0';
		count[s[i]]++;
	}	
	if(sum % 3 != 0 || count['0'] == 0)
	{
		printf("-1");
		return 0;
	}
	
	for(int i='9'; i>='0'; i--)
	{
		for(int j=0; j<count[i]; j++)
		{
			printf("%c", i);
		}
	}
}
