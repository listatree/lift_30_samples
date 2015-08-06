name := "Lift 3.0 starter template"

version := "0.0.1"

organization := "net.liftweb"

// Lift 3 is only available for Scala 2.11+ now
scalaVersion := "2.11.6"

resolvers ++= Seq("snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "https://oss.sonatype.org/content/repositories/releases"
                )

seq(webSettings :_*)

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "3.0-SNAPSHOT"
  Seq(
    "net.liftweb"           %% "lift-webkit"        % liftVersion           % "compile",
    "net.liftweb"           %% "lift-mapper"        % liftVersion           % "compile",
    "net.liftweb"           %% "lift-util"          % liftVersion           % "compile",
    "net.liftweb"           %% "lift-json-ext"      % liftVersion           % "compile",
    "org.eclipse.jetty"     %  "jetty-webapp"       % "9.2.3.v20140905"     % "container,test",
    "org.eclipse.jetty"     %  "jetty-plus"         % "9.2.3.v20140905"     % "container,test",
    "javax.servlet"         %  "servlet-api"        % "2.5"                 % "provided->default",
    "ch.qos.logback"        % "logback-classic"     % "1.0.6",
    "org.parboiled"         %% "parboiled-scala"    % "1.1.7",
    "com.h2database"        % "h2"                  % "1.3.167",
    "org.specs2"            % "specs2_2.10.0-M7"    % "1.12.1"              % "test"
  )
}

// Adding a standalone visi source code since only scala 2.10 is available on official repos
unmanagedSourceDirectories in Compile <+= baseDirectory( _ / "visi" )
