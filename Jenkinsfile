node {
    withMaven(
        maven: 'maven-3',
        mavenLocalRepo: '.repository'
    ) {
        stage("Checkout SCM") {
            checkout scm
        }

        stage("Build Reception Service") {
            sh "mvn -f cool-erp/reception/pom.xml clean install"
        }
        
         stage("Build Shipping Service") {
            sh "mvn -f cool-erp/shipping/pom.xml clean install"
        }
    }

    stage('Build docker images'){
        docker.withServer("unix:///var/run/docker.sock") {
            docker.build("daniellavoie/sopra-reception", "cool-erp/reception")
            docker.build("daniellavoie/sopra-shipping", "cool-erp/shipping")

            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github-daniellavoie', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                sh "docker login --password=${PASSWORD} --username=${USERNAME}"

                sh "docker tag ${USERNAME}/sopra-reception ${USERNAME}/sopra-reception:staging"
                sh "docker tag ${USERNAME}/sopra-reception ${USERNAME}/sopra-shipping:staging"
            }
        }
    }

    stage('Deploy Staging environment') {
        try {
            sh "/usr/local/bin/docker-compose -f cool-erp/docker-compose/staging/docker-compose.yml down"
        } catch(e){ }

        sh "/usr/local/bin/docker-compose -f cool-erp/docker-compose/staging/docker-compose.yml up -d"
    }
}
