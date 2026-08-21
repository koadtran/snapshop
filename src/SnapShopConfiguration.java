/**
 * A class to configure the SnapShop application
 *
 * @author Khoa Dang Tran
 * @version
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {

    theShop.setDefaultFilename("billg.jpg");
    theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
    theShop.addFilter(new FlipVerticalFilter(),"Flip vertical");
    theShop.addFilter(new NegativeFilter(),"Negative");
    theShop.addFilter(new GaussianFilter(),"Gaussian Filter");
    theShop.addFilter(new LaplacianFilter(),"Laplacian Filter");
    theShop.addFilter(new UnsharpMaskingFilter(),"Unsharp Masking Filter");
    theShop.addFilter(new EdgyFilter(),"Edgy Filter");
    //theShop.addFilter(new AdditionalFilter(),"Additional Filter");
  }
}
