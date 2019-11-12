pipeline {
  agent any
  stages {
    stage('Buzz Buzz') {
      steps {
        echo 'Hello World'
      }
    }
    stage('Hello World') {
      steps {
        echo 'Hello World'
      }
    }
    stage('Build') {
      steps {
        sh './gradlew build -x test'
      }
    }
  }
}