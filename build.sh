#!/bin/bash

mvn clean package
docker build -t wortin/docker-some .