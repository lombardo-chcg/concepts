public class PezDispenser {
  public static final int MAX_PEZ = 12;
  private String mCharName;
  private int mPezCount;

  public PezDispenser(String charName) {
    mCharName = charName;
    mPezCount = 0;
  }

  public boolean dispense() {
    boolean wasDispensed = false;
    if (!isEmpty()) {
      mPezCount--;
      wasDispensed = true;
    }
    return wasDispensed;
  }

  public boolean isEmpty() {
    return mPezCount == 0;
  }

  public void load() {
    load(MAX_PEZ);
  }

  public void load(int pezAmount) {
    int newAmount = pezAmount + mPezCount;
    if (newAmount > MAX_PEZ) {
      throw new IllegalArgumentException("You have exceeded the max!");
    } else {
      mPezCount = newAmount;
    }
  }

  public String getCharName() {
    return mCharName;
  }
}

// TRY/CATCH BLOCK
// try {
//   some code here
// } catch(<Exception> <FreeVariable>) {
//   FreeVariable.getMessage();
// }

// method signatures = same method name with different input
