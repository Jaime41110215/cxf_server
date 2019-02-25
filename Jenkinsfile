pipeline {
    agent any 
    stages {
        stage('test') {
            steps {
                echo 'Hello world!' 
            }
        }
        stage('build') {
            steps {
                echo 'Good Morning!' 
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Jaime41110215/cxf_server.git']]])
            }
        }
    }
}
