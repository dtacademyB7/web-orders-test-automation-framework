#!/bin/bash
mvn test -DxmlFile=smoke_test_suite.xml -Dbrowser=edge
mvn test -DxmlFile=smoke_test_suite.xml -Dbrowser=chrome
mvn test -DxmlFile=smoke_test_suite.xml -Dbrowser=firefox