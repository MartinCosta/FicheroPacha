import java.util.Comparator;

public class ClientNameComparator implements Comparator{


    public int compare(Object arg0, Object arg1) {
            ClientLog user0 = (ClientLog) arg0;
            ClientLog user1 = (ClientLog) arg1;

            int flag = user0.getNameClient().compareTo(user1.getNameClient());
            if (flag == 0) {
                return user0.getNameClient().compareTo(user1.getNameClient());
            } else {
                return flag;
            }
        }

    }
