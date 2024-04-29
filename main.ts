figma.showUI(__html__);

figma.ui.onmessage = (msg: { type: string }) => {
  if (msg.type === "cancel") {
    figma.closePlugin();
  }
};
