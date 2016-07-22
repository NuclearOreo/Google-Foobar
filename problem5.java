import java.util.StringTokenizer;
import java.util.ArrayList;

class problem5 {
  public static void main(String[] args) {
    String document = "a b c d a";
    String[] searchTerms = {"a", "c", "d"};

    System.out.println(answer(document,searchTerms));
  }

  public static String answer(String document, String[] searchTerms) {
    String delim = " ";
    StringTokenizer token = new StringTokenizer(document,delim);

    ArrayList<String> documentTokened = new ArrayList<String>();
    while(token.hasMoreElements())
      documentTokened.add(token.nextElement().toString());

    int start = 0;
    int end = documentTokened.size()-1;

    for(int i = 1; i < documentTokened.size(); i++) {
      int start2 = i;
      int end2 = giveRange(i,documentTokened,searchTerms);

      int a = end - start;
      int b = end2 - start2;

      if(b < a){
        start = start2;
        end = end2;
      }
    }

    String ret = "";
    for(int i = start; i < end+1; i++)
      ret = ret + documentTokened.get(i) + " ";

    return ret.substring(0,ret.length()-1);
  }

  public static int giveRange(int start, ArrayList<String> document, String[] list) {
    boolean flist[] = new boolean[list.length];
    int end = 1000000;

    for(int i = 0; i < list.length; i++)
      flist[i] = false;

    for(int i = start; i < document.size(); i++) {
      for(int j = 0; j < list.length; j++)
        if(document.get(i).compareTo(list[j]) == 0)
          flist[j] = true;

      int count = 0;
      for(int j = 0; j < list.length; j++)
        if(flist[j] == true)
          count++;

      if(count == list.length){
        end = i;
        break;
      }
    }
    return end;
  }

}
