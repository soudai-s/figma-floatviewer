package floatviewer.api

import floatviewer.api.figmaplugin.Globals

object API {
  def main(args: Array[String]): Unit = {
    println("Hello World! in API")
    Globals.figma.showUI(Globals.__html__)
    Globals.figma.ui.onmessage = { msg =>
      handleMessage(msg.`type`)
    }
  }

  def handleMessage(messageType: String): Unit = {
    messageType match {
      case "load" => load()
      case "close" => close()
    }
  }

  def load(): Unit = {
    val url = s"https://www.figma.com/file/${Globals.figma.fileKey}/${Globals.figma.root.name}?type=design&mode=design"
    Globals.figma.showUI(s"<script>window.location.href = \"${url}\";</script>")
  }

  def close(): Unit = {
    Globals.figma.closePlugin()
  }
}
