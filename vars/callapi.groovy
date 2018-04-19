def callme(message) {
    def response = steps.httpRequest url:"http://ip.jsontest.com/"

    def responseContent = steps.readJSON text: response.content

    return responseContent
}



def download(artifactory) {
    def server = artifactory.server 'Main'

    def downloadSpec = """{
    "files": [
        {
        "pattern": "samples/com/mycompany/app/my-app/1.0-SNAPSHOT/my-app-1.0-20180418.163328-1.jar",
        "target": "my-app-1.0-20180418.163328-1.jar",
        "flat": "true"
        }
    ]
    }"""
    server.download(downloadSpec)
}

def compile(artifactory) {
    def server = artifactory.server 'Main'
    
    def maven = artifactory.newMavenBuild()

    maven.resolver server: server, releaseRepo: 'jcenter', snapshotRepo: 'jcenter'

    maven.deployer server: server, releaseRepo: 'samples', snapshotRepo: 'samples'

    maven.deployer.deployArtifacts = true

    def buildInfo = maven.run pom: './my-app/pom.xml', goals: 'clean package'
}