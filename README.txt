RadioCare - model + DAO + services (conflits) + controllers + menu console
Gson requis : lib/gson.jar

PowerShell, depuis le dossier qui contient src et lib :
  Remove-Item out -Recurse -Force -ErrorAction SilentlyContinue
  mkdir out
  javac -cp lib\gson.jar -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object FullName)
  java -cp "out;lib\gson.jar" app.Main
