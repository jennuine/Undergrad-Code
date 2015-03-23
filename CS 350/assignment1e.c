/* *
 * assignment1e.c
 * by: Jennifer Nguyen
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void revWords(char *);
void subCheck(char *, char *);
void partCopy(char *, char *);

int main(int argc, char *argv[]) {

    
    char *input = *(argv + 1);
    char *instruction = *(argv + 3);
    char *input2 = *(argv + 2);
        
    if (argv[3] == '\0')
        instruction = input2;
   
    //printf("instruction: %s\n",instruction);
    //printf("input 1: %s\n",input);
    //printf("input 2: %s\n\n",input2);
    
    
    switch (*instruction)
    {
        case '1':
            revWords(input);
            break;
        case '2':
            subCheck(input, input2);
            break;
        case '3':
            partCopy(input, input2);
            break;       
        default:
            printf("Error: \"%s\" was an invalid input.\n", argv[2]);
    }
    
    
    return (0);
}

void revWords(char *str)
{
  int i, pos;
  int j = 0;
  char *revStr = malloc(sizeof(str));
  
  for (i = strlen(str) - 1; i >= 0; i--)
    {           
      if (isspace(str[i]) || i == 0)
        {     
	  pos = i + 1;
          
	  if (i == 0)
	    pos = 0;
	  
	  while (isalnum(str[pos]))
            {
	      revStr[j] = str[pos];
	      pos++; j++;    
            }
	  
	  if (i != 0)
            {
	      revStr[j] = ' ';
	      j++; 
            }
	  revStr[j] = 0;            
        }   
    }
  printf("%s\n", revStr);
  
  free(revStr);
}

void subCheck(char *str1, char *str2)
{    
    int i, num;
    char *cpy = malloc(sizeof(str2) + 1);
    int j = 0;
    
    for (i = 0; i < strlen(str1); i++)
    {
        if (str1[i] == str2[j])
        {
            num = i;
                  
            while (j < strlen(str2)) 
            {
                cpy[j] = str1[num];
                num++; j++;
            }
            cpy[j] = 0;
                   
            if (strcmp(cpy, str2) == 0)
                break;
            else 
                j = 0;
                  
        }
    }    
    if (strcmp(cpy, str2) == 0)
         printf("true\n");
    else
        printf("false\n");
    
    free(cpy);
}

void partCopy(char *str1, char *str2)
{
    if (strlen(str2) > 1)
        printf("Error: %s is an invalid input", str2);
    
    int i;
    char ch = str2[0];
    int start, j = 0;
    
    char *partCopy = malloc(sizeof(str1));
   
    
    for (i = 0; i < strlen(str1); i++)
    {
        if (isspace(str1[i]))
            start = i + 1;
        
        if (str1[i] == ch)
        {   
            while (!isspace(str1[start]) && str1[start] != '\0')
            {
                partCopy[j] = str1[start];
                j++; start++;
            }
             break;        
        }  
    }
    printf("%s\n", partCopy);    
    
    free(partCopy);
}

