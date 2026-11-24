@echo off
cd /d "%~dp0"
if exist out rmdir /s /q out
mkdir out
cd src
if exist ..\sources.txt del ..\sources.txt
for %%f in (model\*.java dao\*.java service\*.java controller\*.java view\*.java app\*.java) do echo %%f>> ..\sources.txt
javac -cp ..\lib\gson.jar -d ..\out @..\sources.txt
cd ..
if not exist lib\gson.jar echo ERREUR : lib\gson.jar est introuvable
java -cp "out;lib\gson.jar" app.Main
pause
