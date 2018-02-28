#!/usr/bin/env groovy

node {
   def nodeHome = tool name: 'node-8.9.4', type: 'jenkins.plugins.nodejs.tools.NodeJSInstallation'
   env.PATH = "${nodeHome}/bin:${env.PATH}" 
   echo "Build number: ${BUILD_ID}"


    stage('check tools') {
        sh 'java -version'
        sh "node -v"
        sh "npm -v"
    }

    stage('checkout') {
        checkout scm
    }
   
    stage ('Removing old container') {
       try {
        sh 'docker stop cerebrum-app'
        sh 'docker rm cerebrum-app'
        sh 'docker stop cerebrum-ui'
        sh 'docker rm cerebrum-ui'
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

    stage ('Deploy Server container') {
       sh 'docker run -d -p 8000:8000 --name cerebrum-app cerebrumovh/cerebrum-app'
    }

    stage ('npm install') {
       dir ('ui') {
           sh 'npm install'
       }
    }

    stage ('Build UI') {
        dir ('ui') {
           sh 'ng build'
        }
    }

    stage ('Build Container for UI with latest build') {
        dir ('ui') {
           sh 'docker build -t cerebrumovh/cerebrum-ui .'
        }
    }

    stage ('Deploy UI container') {
       sh 'docker run -d -p 4200:80 --name cerebrum-ui cerebrumovh/cerebrum-ui'
    }
}


