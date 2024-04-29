package floatviewer.api.figmaplugin

import scala.scalajs.js
import js.annotation._

@js.native
trait PluginAPI extends js.Object {
  def fileKey: String | Unit = js.native
  def closePlugin(message: String = ???): Unit = js.native
  def showUI(html: String, options: ShowUIOptions = ???): Unit = js.native
  def ui: UIAPI = js.native
  def root: DocumentNode = js.native
}

@js.native
trait ShowUIOptions extends js.Object {
  var title: String = js.native
  var width: Double = js.native
  var height: Double = js.native
}

@js.native
trait UIAPI extends js.Object {
  var onmessage: MessageEventHandler | Unit = js.native
}

type MessageEventHandler = js.Function1[MessageEvent, Unit]

@js.native
trait MessageEvent extends js.Object {
  var `type`: String = js.native
}

@js.native
trait DocumentNode extends BaseNodeMixin {
  def `type`: String = js.native
}

@js.native
trait BaseNodeMixin extends js.Object {
  def id: String = js.native
  var name: String = js.native
}
