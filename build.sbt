name := "boomer"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.google.code.morphia" % "morphia" % "0.99",
  "org.mongodb" % "mongo-java-driver" % "2.7.3",
  "com.google.code.morphia" % "morphia-logging-slf4j" % "0.99",
  "org.owasp.esapi" % "esapi" % "2.1.0",
  "org.jasypt" % "jasypt" % "1.9.2",
  "org.apache.commons" % "commons-email" % "1.3.3",
  "com.typesafe.play.plugins" %% "play-plugins-mailer" % "2.3.0",
  "com.nimbusds" % "nimbus-jose-jwt" % "2.10.1",
  "commons-beanutils" % "commons-beanutils" % "1.9.2"
)


resolvers += "Maven repository" at "http://morphia.googlecode.com/svn/mavenrepo/"

resolvers += "MongoDb Java Driver Repository" at "http://repo1.maven.org/maven2/org/mongodb/mongo-java-driver/"

resolvers += "Local Maven Repository" at "file://home/dustin/maven/repository"


play.Project.playJavaSettings

