package floatviewer.ui

import scala.scalajs.js
import org.scalajs.dom
import floatviewer.ui.figmaplugin.FigmaWindow

object UI {
  def main(args: Array[String]): Unit = {
    println("Hello World! in UI")
    dom.document.querySelector("#app").innerHTML = s"""
      <div>
        <h2>Float Viewer</h2>
        <button id="load">Load</button>
        <button id="close">Close</button>
      </div>
    """
    val closeDom = dom.document.getElementById("close")
    closeDom.addEventListener("click", { (e: dom.Event) =>
      val onCloseMessageValue = js.Dynamic.literal(
        "pluginMessage" -> js.Dynamic.literal("type" -> "close")
      )
      FigmaWindow.postMessage(onCloseMessageValue, "*")
    })
    val loadDom = dom.document.getElementById("load")
    loadDom.addEventListener("click", { (e: dom.Event) =>
      val onLoadMessageValue = js.Dynamic.literal(
        "pluginMessage" -> js.Dynamic.literal("type" -> "load"),
        "pluginId" -> "1"
      )
      FigmaWindow.postMessage(onLoadMessageValue, "https://www.figma.com")
    })
  }
}
