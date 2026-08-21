public class WarmingFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    Pixel[][] data = pi.getData();

    for (int row = 0; row < pi.getHeight(); row++)
    {
      for (int col = 0; col < pi.getWidth(); col++)
      {
        data[row][col].red+=4;
        if (data[row][col].red>255){
            data[row][col].red=255;
        }
      }
    }
    pi.setData(data);
  }
}