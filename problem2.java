class problem2 {
  public static void main(String[] args) {
    int[] x = {1,2};
    System.out.println(answer(x));
  }

  public static int answer(int[] x) {
    int sum = 0;
    int len = x.length;

    for (int i = 0;i < len; i++)
      sum+=x[i];

    int count = 0;
    int target = sum/len;
    for (int i = 0; i < len; i++)
      if(x[i] > target)
        count += x[i] - target;

      if(sum%len == 0)
        return len;
      else
        return len-1;
  }

}
