ECHO Compiling..
javac -d bin -sourcepath src -classpath lib/jars/lwjgl-2.9.0.jar:lib/jars/LeapJava.jar:lib/jars/slick-util.jar src/CSGame.java 
cd bin
ECHO Launching Game..
java -cp :../lib/jars/LeapJava.jar:../lib/jars/lwjgl-2.9.0.jar:../lib/jars/slick-util.jar -Djava.library.path=../lib/natives/ CSGame
