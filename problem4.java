class problem4 {
  public static void main(String[] args) {
    int[] test = {0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165};
    //answer(test);
    int[] testA = answer(test);

    for (int i = 0; i < 16; i++)
      System.out.print(testA[i] + " ");
    System.out.println();

  }

  public static int[] answer(int[] digest) {

    int neg  = 0;
    int[] messege = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    for(int i = 0; i < 16; i++) {
      for(int j = 0; j < 256; j++) {
          int step1 = 129 * j;

          int step2 = 0;
          if(i == 0)
            step2 = step1 ^ neg;
          else
            step2 = step1 ^ messege[i-1];

          int step3 = step2 % 256;

          if(step3 == digest[i]) {
            messege[i] = j;
            break;
          }
      }
    }
    return messege;
  }
}
