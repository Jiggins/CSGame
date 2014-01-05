echo Compiling..
javac -d bin -sourcepath src -classpath lib\jars\lwjgl.jar;lib\jars\lwjgl_util.jar;lib\jars\LeapJava.jar;lib\jars\slick-util.jar src\main\CSGame.java 
cd bin
echo Launching Game..
java -cp ;..\lib\jars\LeapJava.jar;..\lib\jars\lwjgl.jar;..\lib\jars\lwjgl_util.jar;..\lib\jars\slick-util.jar -Djava.library.path=..\lib\natives\lwjgl;..\lib\natives\Leap main.CSGame
