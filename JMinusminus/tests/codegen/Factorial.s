# tests\codegen\Factorial.s
# Source file: Factorial.java
# Compiled: Sat May 21 20:44:27 PDT 2016

.text

pass/Factorial.<clinit>:
    subu    $sp,$sp,12 	 # Stack frame is 12 bytes long
    sw      $ra,8($sp) 	 # Save return address
    sw      $fp,4($sp) 	 # Save frame pointer
    sw      $t0,0($sp) 	 # Save register $t0
    addiu   $fp,$sp,8 	 # Save frame pointer

pass/Factorial.<clinit>.0:

pass/Factorial.<clinit>.1:
    li $t0,5
    NLIRPutField.toSpim() not yet implemented!
    j pass/Factorial.<clinit>.restore

pass/Factorial.<clinit>.restore:
    lw      $ra,8($sp) 	 # Restore return address
    lw      $fp,4($sp) 	 # Restore frame pointer
    lw      $t0,0($sp) 	 # Restore register $t0
    addiu   $sp,$sp,12 	 # Pop stack
    jr      $ra 	 # Return to caller



.text

main:
    subu    $sp,$sp,28 	 # Stack frame is 28 bytes long
    sw      $ra,24($sp) 	 # Save return address
    sw      $fp,20($sp) 	 # Save frame pointer
    sw      $t0,16($sp) 	 # Save register $t0
    sw      $t1,12($sp) 	 # Save register $t1
    sw      $t2,8($sp) 	 # Save register $t2
    sw      $t3,4($sp) 	 # Save register $t3
    sw      $t4,0($sp) 	 # Save register $t4
    addiu   $fp,$sp,24 	 # Save frame pointer

main.0:

main.1:
    NLIRGetField.toSpim() not yet implemented!
    NLIRGetField.toSpim() not yet implemented!
    jal java.lang.StringBuilder.__init__
    la $t2,Constant..String0+12
    move $t3,$a0
    move $a0,$t0
    jal pass.Factorial.factorial
    move $t4,$v0
    move $a0,$t3
    j main.restore

main.restore:
    lw      $ra,24($sp) 	 # Restore return address
    lw      $fp,20($sp) 	 # Restore frame pointer
    lw      $t0,16($sp) 	 # Restore register $t0
    lw      $t1,12($sp) 	 # Restore register $t1
    lw      $t2,8($sp) 	 # Restore register $t2
    lw      $t3,4($sp) 	 # Restore register $t3
    lw      $t4,0($sp) 	 # Restore register $t4
    addiu   $sp,$sp,28 	 # Pop stack
    jr      $ra 	 # Return to caller

.data

Constant..String0:
    .word 2 # Tag 2 indicates a string
    .word 20 # Size of object in bytes
    .word 4 # String length (not including null terminator)
    .asciiz "! = " # String terminated by null character 0
    .align 3 # Next object is on a word boundary


.text

pass/Factorial.factorial:
    subu    $sp,$sp,36 	 # Stack frame is 36 bytes long
    sw      $ra,32($sp) 	 # Save return address
    sw      $fp,28($sp) 	 # Save frame pointer
    sw      $t0,24($sp) 	 # Save register $t0
    sw      $t1,20($sp) 	 # Save register $t1
    sw      $t2,16($sp) 	 # Save register $t2
    sw      $t3,12($sp) 	 # Save register $t3
    sw      $t4,8($sp) 	 # Save register $t4
    sw      $t5,4($sp) 	 # Save register $t5
    sw      $t6,0($sp) 	 # Save register $t6
    addiu   $fp,$sp,32 	 # Save frame pointer

pass/Factorial.factorial.0:

pass/Factorial.factorial.1:
    li $t0,0
    bgt $a0,$t0,pass/Factorial.factorial.4
    j pass/Factorial.factorial.2

pass/Factorial.factorial.2:
    li $t1,1
    move $v0,$t1
    j pass/Factorial.factorial.restore

pass/Factorial.factorial.4:
    li $t2,1
    sub $t3,$a0,$t2
    move $t4,$a0
    move $a0,$t3
    jal pass.Factorial.factorial
    move $t5,$v0
    move $a0,$t4
    mul $t6,$a0,$t5
    move $v0,$t6
    j pass/Factorial.factorial.restore

pass/Factorial.factorial.restore:
    lw      $ra,32($sp) 	 # Restore return address
    lw      $fp,28($sp) 	 # Restore frame pointer
    lw      $t0,24($sp) 	 # Restore register $t0
    lw      $t1,20($sp) 	 # Restore register $t1
    lw      $t2,16($sp) 	 # Restore register $t2
    lw      $t3,12($sp) 	 # Restore register $t3
    lw      $t4,8($sp) 	 # Restore register $t4
    lw      $t5,4($sp) 	 # Restore register $t5
    lw      $t6,0($sp) 	 # Restore register $t6
    addiu   $sp,$sp,36 	 # Pop stack
    jr      $ra 	 # Return to caller



# SPIM Runtime

# Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

# SPIM.s 

.text

# Print the integer value passed as parameter.

spim.SPIM.printInt:

    subu $sp,$sp,32     # Stack frame is 32 bytes long
    sw $fp,28($sp)      # Save frame pointer
    addu $fp,$sp,3      # Set up frame pointer

    li $v0,1            # Syscall code to print an integer
    syscall	        # Prints the arg value

    lw $fp,28($sp)      # Restore frame pointer
    addiu $sp,$sp,32    # Restore the stack pointer
    jr $ra              # Return to caller

# Print the float value passed as parameter.

spim.SPIM.printFloat:

    subu $sp,$sp,32     # Stack frame is 32 bytes long
    sw $fp,28($sp)      # Save frame pointer
    addu $fp,$sp,32     # Set up frame pointer

    li $v0,2            # Syscall code to print a float
    syscall             # Prints the arg value

    lw $fp,28($sp)      # Restore frame pointer
    addiu $sp,$sp,32    # Restore the stack pointer
    jr $ra              # Return to caller

# Print the double value passed as parameter.
	
spim.SPIM.printDouble:
    subu $sp,$sp,32    # Stack frame is 32 bytes long
    sw $fp,28($sp)     # Save frame pointer
    addu $fp,$sp,32    # Set up frame pointer

    li $v0,3           # Syscall code to print a double
    syscall            # Prints the arg value

    lw $fp,28($sp)     # Restore frame pointer
    addiu $sp,$sp,32   # restore the stack pointer
    jr $ra             # Return to caller

# Print the string value passed as parameter.

spim.SPIM.printString:
    subu $sp,$sp,32    # Stack frame is 32 bytes long
    sw $fp,28($sp)     # Save frame pointer
    addu $fp,$sp,32    # Set up frame pointer

    li $v0,4           # Syscall code to print a string
    syscall            # Print the string value

    lw $fp,28($sp)     # Restore frame pointer
    addiu $sp,$sp,32   # Restore the stack pointer
    jr $ra             # Return to caller

# Print the char value passed as parameter.

spim.SPIM.printChar:
	subu $sp,$sp,32	   # Stack frame is 32 bytes long
	sw $fp,28($sp)     # Save frame pointer
	addu $fp,$sp,32    # Set up frame pointer


	li $v0,11          # Syscall code to print a char
	syscall            # Print the char value

	lw $fp,28($sp)     # Restore frame pointer
	addiu $sp,$sp,32   # Restore the stack pointer
	jr $ra             # Return to caller

# Read the integer value from the user through console.

spim.SPIM.readInt:
	subu $sp,$sp,32	        # Stack frame is 32 bytes long
	sw $fp,28($sp)          # Save frame pointer
	addu $fp,$sp,32         # Set up frame pointer

	li $v0,5                # Syscall code to read an integer
	syscall                 # Load the integer value read from console into $v0

	lw $fp,28($sp)          # Restore frame pointer
	addiu $sp,$sp,32        # Restore the stack pointer
	jr $ra                  # Return to caller

# Read the float value from the user through console.
	
spim.SPIM.readFloat:
	subu $sp,$sp,32	        # Stack frame is 32 bytes long
	sw $fp,28($sp)          # Save frame pointer
	addu $fp,$sp,32	        # Set up frame pointer

	li $v0,6                # Syscall code to read a float
	syscall	                # Load the float value read from console into $f0

	lw $fp,28($sp)          # Restore frame pointer
	addiu $sp,$sp,32        # Restore the stack pointer
	jr $ra                  # Return to caller

# Read the double value from the user through console.

spim.SPIM.readDouble:
	subu $sp,$sp,32	        # Stack frame is 32 bytes long
	sw $fp,28($sp)          # Save frame pointer
	addu $fp,$sp,32	        # Set up frame pointer

	li $v0,7                # Syscall code to read a double
	syscall	                # Load the float value read from console into $f0

	lw $fp,28($sp)          # Restore frame pointer
	addiu $sp,$sp,32        # Restore the stack pointer
	jr $ra                  # Return to caller
   
# Read the string value from the user through console.

spim.SPIM.readString:
	subu $sp,$sp,32		# Stack frame is 32 bytes long
	sw $fp,28($sp)		# Save frame pointer
	addu $fp,$sp,32		# Set up frame pointer

	li $v0,8		# Syscall code to read a string
	syscall			# Load the string value; $a0 = buffer, $a1 = length

	lw $fp,28($sp)          # Restore frame pointer
	addiu $sp,$sp,32	# Restore the stack pointer
	jr $ra 			# Return to caller

# Read the char value from the user through console.

spim.SPIM.readChar:
	subu $sp,$sp,32	        # Stack frame is 32 bytes long
	sw $fp,28($sp)          # Save frame pointer
	addu $fp,$sp,32	        # Set up frame pointer

	li $v0,12               # Syscall code to read a char
	syscall	                # Load the char value read from console into $a0

	lw $fp,28($sp)          # Restore frame pointer
	addiu $sp,$sp,32        # Restore the stack pointer
	jr $ra                  # Return to caller
	
# Opens a file. This operation uses two arguments:
# $a0 = the address of the file name to open
# $a1 = flags  (0: read only, 1: write only, 2: read and write, 
#               100: create file, 8: append data)
# These registers are assumed to be set by the caller before calling this procedure

spim.SPIM.open:
	subu $sp,$sp,32         # Stack frame is 32 bytes long
	sw $fp,28($sp)          # Save frame pointer
	addu $fp,$sp,32         # Set up frame pointer

	li $v0,13       	# System call code for open file
  	syscall          	# Open a file (file descriptor returned in $v0)

	lw $fp,28($sp)          # Restore frame pointer
	addiu $sp,$sp,32        # Restore the stack pointer
	jr $ra                  # Return to caller

# Reads from a file. This operation uses three arguments:
# $a0 = file descriptor
# $a1 = the address of input buffer
# $a2 = the length of bytes to read
# These registers are assumed to be set by the caller before calling this procedure

spim.SPIM.read:
	subu $sp,$sp,32         # Stack frame is 32 bytes long
	sw $fp,28($sp)          # Save frame pointer
	addu $fp,$sp,32         # Set up frame pointer

	li $v0,14               # System call code for read file
  	syscall                 # Read from file ($a0 contains file descriptor, $v0 contains 
  	                        # number of character read)

	lw $fp,28($sp)          # Restore frame pointer
	addiu $sp,$sp,32        # Restore the stack pointer
	jr $ra                  # Return to caller

# Writes to a file. This operation uses three arguments:
# $a0 = file descriptor
# $a1 = the address of output buffer
# $a2 = the length of bytes to write
# These registers are assumed to be set by the caller before calling this procedure

spim.SPIM.write:
	subu $sp,$sp,32     # Stack frame is 32 bytes long
	sw $fp,28($sp)      # Save frame pointer
	addu $fp,$sp,32     # Set up frame pointer

 	li $v0,15           # System call for write to file
  	syscall             # Write to file  ($a0 contains file descriptor)

	lw $fp,28($sp)      # Restore frame pointer
	addiu $sp,$sp,32    # Restore the stack pointer
	jr $ra              # Return to caller

# Close a file ($a0 contains file descriptor).

spim.SPIM.close:
	subu $sp,$sp,32	    # Stack frame is 32 bytes long
	sw $fp,28($sp)      # Save frame pointer
	addu $fp,$sp,32     # Set up frame pointer

	li $v0,16           # System call code for close
  	syscall		    # Close file

	lw $fp,28($sp) 	    # Restore frame pointer
	addiu $sp,$sp,32    # Restore the stack pointer
	jr $ra              # Return to caller

# Exit SPIM.
	
spim.SPIM.exit:
    li $v0,10        # Syscall code to exit
    syscall

# Exit SPIM with a specified code (in $a0).
	
spim.SPIM.exit2:
    li $v0,17        # Syscall code to exit2
    syscall
	
