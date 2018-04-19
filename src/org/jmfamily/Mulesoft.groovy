package org.jmfamily;

class Mulesoft implements Serializable {
    def steps

    Mulesoft(steps) {
        this.steps = steps
    }

    def CallApi() {
        def response = steps.httpRequest url:"http://ip.jsontest.com/"

        def responseContent = steps.readJSON text: response.content

        return responseContent
    }

    def MavenBuild(artifactory) {
        /*def server = artifactory.server 'local'
    
        def maven = artifactory.newMavenBuild()
    
        maven.resolver server: server, releaseRepo: 'jcenter', snapshotRepo: 'jcenter'
    
        maven.deployer server: server, releaseRepo: 'samples', snapshotRepo: 'samples'
    
        maven.deployer.deployArtifacts = true
       
        def buildInfo = maven.run pom: './my-app/pom.xml', goals: 'clean package'

        */
    }
}