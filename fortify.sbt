// this makes it so sbt can resolve the plugin
credentials += Credentials(
  Path.userHome / ".lightbend" / "commercial.credentials")
resolvers += Resolver.url(
  "lightbend-commercial-releases",
  new URL("http://repo.lightbend.com/commercial-releases/"))(
  Resolver.ivyStylePatterns)

// enable the plugin
addCompilerPlugin(
  "com.lightbend" %% "scala-fortify" % "0.1.3"
    classifier "assembly" cross CrossVersion.patch)

// configure the plugin
scalacOptions += s"-P:fortify:build=play-webgoat"
