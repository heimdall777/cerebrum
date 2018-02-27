#!/usr/bin/env groovy

node {
   checkout scm
   echo "Build number: ${BUILD_ID}"
   
   stage ('Removing old container') {
       try {
        sh 'docker stop cerebrum-app'
        sh 'docker rm cerebrum-app'
       } catch (err) {
           echo err.toString()
       }
   }

   stage ('Build Container with latest build') {
       sh 'cd server/ && chmod +x mvnw && ./mvnw install dockerfile:build'
   }

   stage ('Run new container') {
       sh 'docker run -d -p 8000:8000 --name cerebrum-app cerebrumovh/cerebrum-app'
   }
}


