/**
 * assignment1.c
 * by: Jennifer Nguyen
 */  
#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

void convertToInt(char *);
void copy(char *, char*);
void convertToFloat(char *);
void convertToUpperCase(char *);
void revString(char *);
void palindrome(char *);

int main(int argc, char *argv[])
{
  char *instruction = *(argv + 2);
  char *input = *(argv + 1);

switch(*instruction)
    {
    case '1':
     convertToInt(input);
      break;
    case '2':
        convertToFloat(input);
      break;
    case '3':
        convertToUpperCase(input);
      break;
    case '4':
        revString(input);
      break;
    case '5':
        palindrome(input);
      break;
    default:
      printf("Error: \"%s\" was an invalid input.\n", argv[2]);
    }

  return 0;
}

void convertToInt(char *str)
{
  int i, sign;
  int result = 0;
  
  if (str[0] == '-')
    sign = 1;
  else
    sign = 0;
  
  for (i = sign; i < strlen(str); i++)
    {
      if (!isdigit(str[i]))
	{
	  printf("Error: \"%s\" is not a valid integer.\n", str);
	  return;
	} 
      else 
	result = result * 10 + (str[i] - '0');      
    }
  
  if (sign == 1)
    result = -result;
  
  printf("%d %d\n", result, result * 2);  
}

void convertToFloat(char *str)
{
  int i, sign, pos;
  double result = 0.0;
  int dot = 0;
  
  if (str[0] == '-')
    sign = 1;
  else
    sign = 0;
  
  for (i = sign; i < strlen(str); i++)
    {
      if(str[i] == '.')
        {
	  pos = strlen(str) - i - 1;
	  dot++;
          
	  if (dot > 1)
            {
	      printf("Error: \"%s\" is not a valid float.\n", str);
	      return;
            }
        }
      else if (!isdigit(str[i]))
        {
	  printf("Error: \"%s\" is not a valid float.\n", str);
	  return;
        } 
      else 
	result = result * 10.0 + (str[i] - '0');                     
    }
  
  if (dot == 1)
    {
      while(pos--)
        {
	  result /= 10.0;
        }
    }
  if (sign == 1)
    result = -result;
  
  printf("%g %g\n", result, result * 2);
}

void convertToUpperCase(char *str)
{
  int i;
  
  for (i = 0; i < strlen(str); i++)
    {
      if (!isalpha(str[i]))
	str[i] = '0';
      else
	str[i] = toupper(str[i]);
    }
  
  printf("%s\n", str);
}

void revString(char *str)
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
}

void palindrome(char *str)
{
  int i = strlen(str) - 1;
  int j = 0; 
  char *copy = malloc(sizeof(str));
  
  while (i >= 0)
    {
      copy[j] = str[i];
      i--; j++;
    }
  
  copy[j] = 0;
  
  if (strcasecmp(copy, str) == 0)
    printf("true\n");
  else
    printf("false\n");
}
