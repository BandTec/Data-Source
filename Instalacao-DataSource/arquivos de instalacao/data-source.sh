#!/bin/bash

cp projeto-datasource-1.0-SNAPSHOT-jar-with-dependencies.jar  /usr/lib
cp Data* /usr/lib
cp data* /usr/lib
cd /usr/lib
chmod +x data* 
chmod +x Data*
cp data-source.desktop  ~/Desktop
java -jar projeto-datasource-1.0-SNAPSHOT-jar-with-dependencies.jar




