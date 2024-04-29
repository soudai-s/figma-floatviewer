package floatviewer.api

import floatviewer.api.figmaplugin.Globals

object API {
  def main(args: Array[String]): Unit = {
    println("Hello World! in API")
    Globals.figma.showUI(Globals.__html__)
    Globals.figma.ui.onmessage = { msg =>
      close()
    }
  }

  def close(): Unit = {
    Globals.figma.closePlugin()
  }
}
