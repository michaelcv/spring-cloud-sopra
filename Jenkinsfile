node {
    withMaven(
        maven: 'maven-3',
        mavenLocalRepo: '.repository'
    ) {
        stage("Checkout SCM") {
            checkout scm
        }

        stage("Build Eureka Server") {
            sh "mvn -f cool-erp/eureka-server/pom.xml clean install"
        }

        stage("Build Config Server") {
            sh "mvn -f cool-erp/config-server/pom.xml clean install"
        }
    }

    stage('Build docker images'){
        docker.withServer("unix:///var/run/docker.sock") {
            docker.build("daniellavoie/sopra-eureka-server", "cool-erp/eureka-server")
            docker.build("daniellavoie/sopra-config-server", "cool-erp/config-server")
        }
    }

    stage('Deploy Staging environment') {
        try {
            sh "/usr/local/bin/docker-compose -f cool-erp/docker-compose/coolerp-staging/docker-compose.yml down"
        } catch(e){ }

        sh "/usr/local/bin/docker-compose -f cool-erp/docker-compose/coolerp-staging/docker-compose.yml up -d"
    }
}