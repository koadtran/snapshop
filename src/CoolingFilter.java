public class CoolingFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    Pixel[][] data = pi.getData();

    for (int row = 0; row < pi.getHeight(); row++)
    {
      for (int col = 0; col < pi.getWidth(); col++)
      {
        data[row][col].blue+=4;
        if (data[row][col].blue>255){
            data[row][col].blue=255;
        }
      }
    }
    pi.setData(data);
  }
}