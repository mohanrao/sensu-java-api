# Releasing Sensu-Java-Api

Sensu-Java-Api is a library intended to interact with a full stack Sensu cluster. 
The API must have access to the running Sensu server, and supports 
requests authenticated with a username / password.

Please review integration instructions in the README.md included with this project.

# Publishing Sensu-Java-API

Sensu-Java-Api has multiple publishing tasks available via gradle command.
It offers publishing configuration for Artifactory, Maven and Bintray (Jcenter) in the build.gradle file.

## Publishing to Artifactory

Run the command below to deploy artifacts + generated build-info metadata to Artifactory, using project publications.
```
gradle artifactoryPublish
```

## Publishing to Bintray

Run the command below to publish artifacts to bintray.com.
```
gradle bintrayUpload
```

## Publishing to Maven

Run the command below to generate the Maven POM file for publication 'main'.
```
gradle generatePomFileForMainPublication
```

Run the command below to publish Maven publication 'main' to the local Maven repository.
```
gradle publishMainPublicationToMavenLocal
```

Run the command below to publish all Maven publications produced by this project to the local Maven cache.
```
gradle publishToMavenLocal
```

## Publish all
Run the command below to publish all publications produced by this project.
```
gradle publish
```
