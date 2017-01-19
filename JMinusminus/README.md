#### About

This is the biggest source I have ever worked on in college. The source code is a light version of a Java Compiler called [J--](http://www.cs.umb.edu/j--/download.html) developed by Bill Campbell, Swami Iyer, Bahar Akbal-Delibaş at University of Massachusetts in Boston.

Although it is a light version, the compiler can only scan, parse, and generate codes for limited number of Java statements. My job was to add additional features to it. The tasks are outlined in file **TCSS 421 Project.pdf**. 

#### How to Run

- Import the project into your IDE. Files and folders you will need:
  - src
  - tests (where all my tests and premade tests are)
  - build
  - grammar (the Java language grammar. Learn more at the [Java Language Specification] (https://docs.oracle.com/javase/specs/jls/se8/html/jls-19.html) )
  - lexical grammar
  
- Build the project 
  - (At this step I got exception from Intelli J so I fixed some of the original codes that I submited to my instructor. It should work fine now.)
- To run, you will need to create new Run Configuration:

	<options> <source file>

	Options are:
  - -t Only tokenize input and print tokens to console.
  - -p Only parse input and print AST to console.
  - -pa Only parse and pre-analyze input and print Abstract Syntax Tree (AST) to console.
  - -a Only parse, pre-analyze, and analyze input and print AST to console.
  - -s <naive|linear|graph> Generate machine code (instructions that make bytecode)
  - -r <num> Max. physical registers (1-18) available for allocation; default = 8
  - -d <dir> Specify where to place output files; default = .
    - if you use this option for generate code, you will have to use a [Java class file disassembler](http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javap.html) (built into Java SDK) to view the .class file generated (my test files are in tests/codegen). Specifically, javap -c <source> is the one you need.
