#!/usr/bin/env zsh

kill $(pgrep -f microservices)
kill $(pgrep -f gateway)
kill $(pgrep -f eureka)
kill $(pgrep -f config-server)