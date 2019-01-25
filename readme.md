## RPN Calculator

Command-line based RPN calculator

# Introduction
---------------
The calculator waits for user input and expects to receive strings containing 
whitespace separated lists of numbers and operators.

Numbers are pushed on to the stack. Operators operate on numbers that are on the stack.
Available operators are +, -, *, /, sqrt, undo, clear

Operators pop their parameters off the stack, and push their results back onto the stack.

1) The clear operator removes all items from the stack.
2) The undo operator undoes the previous operation. "undo undo" will undo the previous two operations.
3) sqrt performs a square root on the top item from the stack
4) The +, -, *, / operators perform addition, subtraction, multiplication and division respectively
on the top two items from the stack.

After processing an input string, the calculator displays the current contents of the stack as a space-separated list. Numbers are stored on the stack.


# Requirements
Implemented and tested using Java 8
Tests require JUnit and Mockito
Project dependencies and compiling managed by Maven


# Run:
To run the program, execute using mvn spring-boot:run




