import java.util.HashMap;

public class Rating {
   private HashMap<User,Integer> userRatingMap;


    private void setUserRatingMap( HashMap<User,Integer> userRatingMap){

        this.userRatingMap = userRatingMap;
    }


    public HashMap<User, Integer> getUserRatingMap(){
        return userRatingMap;
    }

    public void sortUsers(){

    }

}
