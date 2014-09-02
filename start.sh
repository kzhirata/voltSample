#!/bin/sh

voltdb compile --classpath target/classes -o voltSample.jar ddl.sql 
voltdb create voltSample.jar -H localhost -d deployment.xml &

