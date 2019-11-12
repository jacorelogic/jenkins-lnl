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
    stage('Test') {
      steps {
        sh './scripts/run_tests.sh'
        junit 'build/test-results/**/*.xml'
        archiveArtifacts(artifacts: 'build/libs/*.jar', fingerprint: true, onlyIfSuccessful: true)
      }
    }
  }
}