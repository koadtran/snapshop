# SnapShop

A small Java Swing image-editing app. Load a photo, click a filter, watch it transform. Built as an exercise in the Filter design pattern — each effect is a self-contained class that implements a common `Filter` interface, so adding a new one is a two-line change.

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

Requires JDK 8 or newer.

Once the app opens, click **Set file** to pick an image, then click any filter button to apply it. **Save** writes the result to disk.

## Adding a new filter

1. Create `MyFilter.java` implementing the `Filter` interface:
```java
   public class MyFilter implements Filter {
       public void filter(PixelImage pi) {
           Pixel[][] data = pi.getData();
           // ...transform data...
           pi.setData(data);
       }
   }
```
2. Register it in `SnapShopConfiguration.configure()`:
```java
   theShop.addFilter(new MyFilter(), "My Filter");
```
3. Rebuild — a new button appears in the UI.

## Project layout

'''
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
'''

## Author

Khoa Dang Tran
