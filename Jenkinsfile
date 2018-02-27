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

   stage ('Build Container for Server with latest build') {
       dir ('server') {
            sh 'chmod +x mvnw'
            sh './mvnw install dockerfile:build'
       }
       
   }

   stage ('Run new container') {
       sh 'docker run -d -p 8000:8000 --name cerebrum-app cerebrumovh/cerebrum-app'
   }

   stage ('Install npm for UI') {
       dir ('ui') {
           sh 'npm install'
       }
   }

   stage ('Build UI dist') {
       dir ('ui') {
           sh 'ng build'
       }
   }

   stage ('Build Container for UI with latest build') {
       dir ('ui') {
           sh 'docker build -t cerebrum/cerebrum-ui .'
       }
   }
}


