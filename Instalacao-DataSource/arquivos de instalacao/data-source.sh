#!/bin/bash

cp projeto-datasource-1.0-SNAPSHOT-jar-with-dependencies.jar  /usr/lib
cp data* /usr/lib
cd /usr/lib
chmod +x data* 
java -jar projeto-datasource-1.0-SNAPSHOT-jar-with-dependencies.jar




