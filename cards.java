public class cards
{
  private int number;
  private String type;
  
  public cards()
  {
    number = 1;
    type = "ace";
  }
  public cards(int n, String t)
  {
    number = n;
    type = t;
  }
  
  public String getType()
  {
    return type;
  }
  
  public int getNumber()
  {
    return number;
  }
} 