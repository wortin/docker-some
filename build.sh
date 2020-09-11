#!/bin/bash

mvn clean package -Dxjar.password=hpcpltSEC202O
GOOS=linux GOARCH=amd64 go build -o target/booter target/xjar.go
docker build -t wortin/docker-some .