import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionResolver {

    public static String resolve(String expression) {
        int k = 0;
        String[] dataArray = expression.split(" ");
        List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).equals("*")) {
                dataList.set(i + 1, String.valueOf(Double.parseDouble(dataList.get(i - 1)) * Double.parseDouble(dataList.get(i + 1))));
                dataList.remove(i);
                dataList.remove(i - 1);
                i--;
            }

            if (dataList.get(i).equals("/")) {
                dataList.set(i + 1, String.valueOf(Double.parseDouble(dataList.get(i - 1)) / Double.parseDouble(dataList.get(i + 1))));
                dataList.remove(i);
                dataList.remove(i - 1);
                i--;
            }
        }

        for (int i = 0; i < dataList.size() - k; i++) {
            if (dataList.get(i).equals("+")) {
                dataList.set(i + 1, String.valueOf(Double.parseDouble(dataList.get(i - 1)) + Double.parseDouble(dataList.get(i + 1))));
                dataList.remove(i);
                dataList.remove(i - 1);
                i--;
            }

            if (dataList.get(i).equals("-")) {
                dataList.set(i + 1, String.valueOf(Double.parseDouble(dataList.get(i - 1)) - Double.parseDouble(dataList.get(i + 1))));
                dataList.remove(i);
                dataList.remove(i - 1);
                i--;
            }
        }

        if ((Double.parseDouble(dataList.get(0)) * 10) % 10 == 0) {
            long res = (long) Double.parseDouble(dataList.get(0));
            return String.valueOf(res);
        }
        else {
            return dataList.get(0);
        }
    }
}
