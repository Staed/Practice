@echo off

set tgt="target\classes"
set loc="src\main\java\us\staed"

javac -d %tgt% %loc%\AddTwoDigits.java
javac -d %tgt% %loc%\LargestNumber.java
javac -d %tgt% %loc%\LateRide.java
javac -d %tgt% %loc%\PhoneCall.java
