figma.showUI(__html__);

figma.ui.onmessage = (msg: { type: string, count: number }) => {
  if (msg.type === "create-rectangles") {
    const nodes: SceneNode[] = [];
    for (let i = 0; i < msg.count; i++) {
      const rect = figma.createRectangle();
      rect.x = i * 150;
      rect.fills = [{ type: "SOLID", color: { r: 1, g: 0.5, b: 0 } }];
      figma.currentPage.appendChild(rect);
      nodes.push(rect);
    }
    figma.currentPage.selection = nodes;
    figma.viewport.scrollAndZoomIntoView(nodes);
  }
  if (msg.type === "load") {
    const { width: viewportWidth, height: viewportheight } =
      figma.viewport.bounds;
    const width = Math.round(viewportWidth / 2);
    const height = Math.round(viewportheight / 2);
    const url = `https://www.figma.com/file/${figma.fileKey}/${figma.root.name}?type=design&mode=design`;
    figma.ui.postMessage({ url, width, height });
    figma.showUI(`<script>window.location.href = "${url}";</script>`, {
      width,
      height,
    });
  }
  if (msg.type === "cancel") {
    figma.closePlugin();
  }
};
