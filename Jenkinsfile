#!/usr/bin/env groovy

node {
   checkout scm
   echo "Build number: ${BUILD_ID}"
   
   stage ('Removing old container') {
       try {
        sh 'docker stop cerebrumovh/cerebrum-app'
        sh 'docker rm cerebrumovh/cerebrum-app'
       } catch (err) {
           echo err.toString()
       }
   }

   stage ('Build Container with latest build') {
       sh 'ls -la'
       sh 'cd server'
       sh 'ls -la'
       sh 'chmod +x mvnw'
       sh './mvnw install dockerfile:build'
       sh 'cd ..'
   }

   stage ('Run new container') {
       sh 'docker run -p 8000:8000 -t cerebrumovh/cerebrum-app'
   }
}


