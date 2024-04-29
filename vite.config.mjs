import { defineConfig } from "vite";
import { viteSingleFile } from "vite-plugin-singlefile";
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";

export default defineConfig(({ mode }) => {
  if (mode == "ui") {
    return {
      plugins: [
        viteSingleFile(),
        scalaJSPlugin({
          projectID: "ui",
        }),
      ],
      build: {
        cssCodeSplit: false,
        assetsInlineLimit: 100000000,
        outDir: "./dist/ui",
      },
    };
  }

  if (mode == "api") {
    return {
      plugins: [
        scalaJSPlugin({
          projectID: "api",
        }),
      ],
      publicDir: "./api/target/scala-3.2.2/api-opt",
      build: {
        outDir: "./dist/api",
      },
    };
  }

  return {};
});
