public class LaplacianFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int[][] theFilter={{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
    Pixel[][] data = pi.getWeightedPixelArray(theFilter, 1);
    pi.setData(data);
  }
}
