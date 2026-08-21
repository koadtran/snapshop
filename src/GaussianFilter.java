public class GaussianFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int[][] theFilter={{1,2,1},{2,4,2},{1,2,1}};
    Pixel[][] data = pi.getWeightedPixelArray(theFilter, 16);
    pi.setData(data);
  }
}
