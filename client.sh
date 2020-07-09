#!/bin/bash

adress=localhost:8080
ID=1
answer=y
read -p "localhost:8080 ?" answer
case $answer in
    n|N|no|NO) echo "Server adress:";read adress
esac
read -p "Type a name or id of Pokemon:" ID
curl ${adress}/base/${ID}