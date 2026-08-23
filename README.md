# SnapShop

A small Java Swing image-editing app. Load a photo, click a filter, watch it transform.

## Filters

- **Flip Horizontal / Vertical** — mirror the image
- **Negative** — invert every pixel's color
- **Gaussian** — blur with a Gaussian kernel
- **Laplacian** — edge detection via the Laplacian operator
- **Unsharp Masking** — sharpen by subtracting a blurred copy from the original
- **Edgy** — an edge-emphasis convolution
- **Cooling / Warming** — shift the color temperature

## Tech

- Java + Swing (AWT for image handling)
- Convolution-based filters using a shared weighted-pixel utility on `PixelImage`
- Pluggable filter architecture — implement `Filter.filter(PixelImage)` and register the class in `SnapShopConfiguration`

## Build & run

```bash
mkdir -p build
javac -d build src/*.java
jar cfe SnapShop.jar SnapShop -C build .
java -jar SnapShop.jar
```

When the app opens, a text field is pre-filled with the default image filename. Type any image path into the field (or keep the default), click **Load**, then click any filter button to apply the effect. The default filename is set in `SnapShopConfiguration`.

## Project layout

```
src/
├── SnapShop.java # main window, UI wiring, entry point
├── SnapShopConfiguration.java # registers filters and default image
├── Filter.java # interface every filter implements
├── PixelImage.java # image data + convolution helper
├── Pixel.java # RGB pixel
├── FlipHorizontalFilter.java
├── FlipVerticalFilter.java
├── NegativeFilter.java
├── GaussianFilter.java
├── LaplacianFilter.java
├── UnsharpMaskingFilter.java
├── EdgyFilter.java
├── CoolingFilter.java
└── WarmingFilter.java
```
