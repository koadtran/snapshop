
public class EdgyFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    int[][] theFilter={{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
    Pixel[][] data = pi.getWeightedPixelArray(theFilter, 1);
    pi.setData(data);
  }
}
