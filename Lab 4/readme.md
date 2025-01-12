### Deploy mule app to mule standalone server:
1. Install/Download mule standalone server from mulesoft homepage
2. In $MULE_HOME/app create directory with your project name
3. Copy project flow description( from your_project/src/mule) to $MULE_HOME/app/{your_project}
4. Copy all your target/* content to $MULE_HOME/app/{your_project}
5. Export mule project to .jar:
   5.1 Right click to your project on Package Explorer -> Export
   5.2 Mule -> Anypoint Studio Project to Mule Deployable Archive
   5.3 Name your JAR file, tick Attach project source ad Include project ...
   5.4 Finish
 6. Run Mule standalone mode by  run $MULE_HOME/bin/mule(.bat)
