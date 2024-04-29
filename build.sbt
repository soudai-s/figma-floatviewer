import org.scalajs.linker.interface.ModuleSplitStyle

lazy val commonSettings = Seq(
  scalaVersion := "3.2.2",
  scalaJSUseMainModuleInitializer := true,
)

lazy val ui = project
  .in(file("ui"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(
    name := "ui",
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("ui")))
    },
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0",
  )

lazy val api = project
  .in(file("api"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(
    name := "api",
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("api")))
    },
  )
